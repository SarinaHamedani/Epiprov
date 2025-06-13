package decomposer_plugin.handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.wizard.Wizard;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The main wizard class. It contains one page for inputting the three file paths.
 */
class DecomposerWizard extends Wizard {

    private InputFilesWizardPage inputPage;

    public DecomposerWizard() {
        setWindowTitle("Decomposer Wizard");
    }

    @Override
    public void addPages() {
        inputPage = new InputFilesWizardPage();
        addPage(inputPage);
    }

    @Override
    public boolean performFinish() {
        // Retrieve file paths from the wizard page
        String emodlFile = inputPage.getEmodlFile();
        String provnFile = inputPage.getProvnFile();
        String jsonFile = inputPage.getJsonFile();

        // For this example, we assume the three files are in the same directory.
        File file = new File(emodlFile);
        String directory = file.getParent();
        // Create output directories relative to the chosen directory.
        String outputDirEmodl = directory + File.separator + "output_clusters";
        String outputDirProvn = directory + File.separator + "output_provn";
        new File(outputDirEmodl).mkdirs();
        new File(outputDirProvn).mkdirs();

        try {
            splitEmodl(emodlFile, jsonFile, outputDirEmodl);
            splitProvn(provnFile, jsonFile, outputDirProvn);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Splits the EMODL file based on the clusters defined in the JSON file.
     */
    private void splitEmodl(String filePath, String jsonFile, String outputDir) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        ObjectMapper objectMapper = new ObjectMapper();
        // Assumes JSON is a map from cluster names to lists of keywords.
        Map<String, List<String>> clusters = objectMapper.readValue(new File(jsonFile), Map.class);

        for (Map.Entry<String, List<String>> entry : clusters.entrySet()) {
            String clusterName = entry.getKey();
            List<String> keywords = entry.getValue();

            StringBuilder clusterContent = new StringBuilder();
            clusterContent.append("(import (rnrs) (emodl cmslib))\n\n")
                          .append("(start-model \"").append(clusterName).append("\")\n\n");

            // Go through each line in the EMODL file and add it if it contains a keyword.
            for (String line : content.split("\n")) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        clusterContent.append(line).append("\n");
                        break;
                    }
                }
            }
            clusterContent.append("\n\n(end-model)");

            Files.write(Paths.get(outputDir, clusterName + ".emodl"), clusterContent.toString().getBytes());
        }
    }

    private static String stripNamespace(String token) {
        token = token.trim();
        int index = token.indexOf(":");
        if (index != -1) {
            return token.substring(index + 1).trim();
        }
        return token;
    }
    
    /**
     * Finds the definition lines for the given entity.
     * It also looks for a wasAttributedTo relation to pull in an associated agent.
     */
    public static List<String> findEntityDefinition(String entityName, List<String> provnLines) {
	    List<String> entityDefinitions = new ArrayList<>();
	    String associatedAgent = null;
	    Set<String> associatedActivities = new HashSet<>();
	
	    // Pattern for entity definition
	    Pattern entityPattern = Pattern.compile("\\bentity\\([^:]+:" + Pattern.quote(entityName));
	    
	    // Pattern for wasAttributedTo(entity, agent)
	    Pattern wasAttributedToPattern = Pattern.compile("\\bwasAttributedTo\\([^:]+:" + Pattern.quote(entityName) + ",\\s*([^,\\)]+)");
	
	    // Pattern for wasGeneratedBy(entity, activity)
	    Pattern wasGeneratedByPattern = Pattern.compile("\\bwasGeneratedBy\\([^:]+:" + Pattern.quote(entityName) + ",\\s*([^,\\)]+)");
	
	    // Pattern for used(activity, entity)
	    Pattern usedPattern = Pattern.compile("\\bused\\([^:]+:([^,\\)]+),\\s*[^:]+:" + Pattern.quote(entityName) + "\\)");
	
	    for (String line : provnLines) {
	        Matcher m = entityPattern.matcher(line);
	        if (m.find()) {
	            entityDefinitions.add(line);
	            continue;
	        }
	
	        Matcher attrMatcher = wasAttributedToPattern.matcher(line);
	        if (attrMatcher.find()) {
	            entityDefinitions.add(line);
	            associatedAgent = stripNamespace(attrMatcher.group(1));
	            continue;
	        }
	
	        Matcher genMatcher = wasGeneratedByPattern.matcher(line);
	        if (genMatcher.find()) {
	            entityDefinitions.add(line);
	            associatedActivities.add(stripNamespace(genMatcher.group(1)));
	        }
	
	        Matcher usedMatcher = usedPattern.matcher(line);
	        if (usedMatcher.find()) {
	            entityDefinitions.add(line);
	            associatedActivities.add(stripNamespace(usedMatcher.group(1)));
	        }
	    }
	
	    // Add agent definition if found
	    if (associatedAgent != null) {
	        Pattern agentPattern = Pattern.compile("\\bagent\\([^:]+:" + Pattern.quote(associatedAgent));
	        for (String line : provnLines) {
	            Matcher agentMatcher = agentPattern.matcher(line);
	            if (agentMatcher.find()) {
	                entityDefinitions.add(line);
	                break;
	            }
	        }
	    }
	
	    // Add all associated activity definitions
	    for (String activity : associatedActivities) {
	        Pattern activityPattern = Pattern.compile("\\bactivity\\([^:]+:" + Pattern.quote(activity));
	        for (String line : provnLines) {
	            Matcher activityMatcher = activityPattern.matcher(line);
	            if (activityMatcher.find()) {
	                entityDefinitions.add(line);
	                break;
	            }
	        }
	    }
	
	    return entityDefinitions;
	}

    
    /**
     * Recursively extracts all lines from the PROVN file that are related to any of the given entity names.
     * It processes derivations, attributions, specializations, hadMember relationships, and more.
     */
    public static List<String> extractRelatedLinesProvn(List<String> provnLines, Set<String> clusterParameters, Set<String> allKnownParameters) {
	    List<String> relatedLines = new ArrayList<>();
	    Queue<String> queue = new LinkedList<>(clusterParameters);
	    Set<String> seen = new HashSet<>();
	
	    while (!queue.isEmpty()) {
	        String currentEntity = stripNamespace(queue.poll());
	
	        if (seen.contains(currentEntity)) {
	            continue;
	        }
	        seen.add(currentEntity);
	
	        for (String line : provnLines) {
	            if (!line.matches(".*\\b" + Pattern.quote(currentEntity) + "\\b.*")) continue;
	
	            // Extract all QualifiedName references in the line
	            Set<String> referenced = new HashSet<>();
	            Matcher m;
	
	            m = Pattern.compile("\\b(?:entity|activity|agent)\\([^:]+:([^,\\)\\]]+)").matcher(line);
	            while (m.find()) referenced.add(stripNamespace(m.group(1)));
	
	            m = Pattern.compile("wasDerivedFrom\\([^:]+:([^,\\)]+),\\s*[^:]+:([^,\\)]+)").matcher(line);
	            while (m.find()) {
	                referenced.add(stripNamespace(m.group(1)));
	                referenced.add(stripNamespace(m.group(2)));
	            }
	
	            m = Pattern.compile("wasGeneratedBy\\([^:]+:([^,\\)]+),\\s*[^:]+:([^,\\)]+)").matcher(line);
	            while (m.find()) {
	                referenced.add(stripNamespace(m.group(1)));
	                referenced.add(stripNamespace(m.group(2)));
	            }
	
	            m = Pattern.compile("wasAttributedTo\\([^:]+:([^,\\)]+),\\s*[^:]+:([^,\\)]+)").matcher(line);
	            while (m.find()) {
	                referenced.add(stripNamespace(m.group(1)));
	                referenced.add(stripNamespace(m.group(2)));
	            }
	
	            m = Pattern.compile("specializationOf\\([^:]+:([^,\\)]+),?\\s*[^:]*:?(.*)?\\)").matcher(line);
	            while (m.find()) {
	                referenced.add(stripNamespace(m.group(1)));
	                referenced.add(stripNamespace(m.group(2)));
	            }
	
	            m = Pattern.compile("hadMember\\([^:]+:([^,\\)]+)").matcher(line);
	            while (m.find()) referenced.add(stripNamespace(m.group(1)));
	
	            boolean referencesOtherParam = referenced.stream()
	                .anyMatch(ref -> allKnownParameters.contains(ref) && !clusterParameters.contains(ref));
	
	            if (referencesOtherParam) {
	                continue; // skip this line entirely
	            }
	
	            if (!relatedLines.contains(line)) {
	                relatedLines.add(line);
	            }
	
	            for (String ref : referenced) {
	                if (!seen.contains(ref)) {
	                    queue.add(ref);
	                }
	            }
	
	            // For hadMember: also include the entity definition
	            Matcher hadMemberMatcher = Pattern.compile("hadMember\\([^:]+:([^,\\)]+)").matcher(line);
	            while (hadMemberMatcher.find()) {
	                String member = stripNamespace(hadMemberMatcher.group(1));
	                List<String> memberDefs = findEntityDefinition(member, provnLines);
	                for (String def : memberDefs) {
	                    if (!relatedLines.contains(def)) {
	                        relatedLines.add(def);
	                    }
	                }
	                if (!seen.contains(member)) {
	                    queue.add(member);
	                }
	            }
	        }
	    }
	
	    return relatedLines;
    }

    /**
     * Splits the given PROVN file into clusters.
     * Each cluster is determined by a mapping (read from a JSON file) from cluster names to lists of entity names.
     * For each cluster, it finds all related lines (definitions and relationships) and writes a valid PROVN document.
     */
    public static void splitProvn(String filePath, String clusterFile, String outputDir) throws IOException {
        // Read all lines from the PROVN file.
        List<String> provnLines = Files.readAllLines(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        // Read clusters as a Map<String, List<String>>
        Map<String, List<String>> clusters = objectMapper.readValue(new File(clusterFile), Map.class);
        
        Set<String> allKnownParameters = new HashSet<>();
        for (List<String> params : clusters.values()) {
            allKnownParameters.addAll(params);
        }

        
        // Process each cluster.
        for (Map.Entry<String, List<String>> entry : clusters.entrySet()) {
            String clusterName = entry.getKey();
            Set<String> entityNames = new HashSet<>(entry.getValue());
            
            List<String> clusterLines = extractRelatedLinesProvn(provnLines, entityNames, allKnownParameters);
            if (!clusterLines.isEmpty()) {
                StringBuilder clusterContent = new StringBuilder();
                clusterContent.append("document\n\n")
                              .append("prefix epi <http://www.cs.rpi.edu/~hendler/>\n")
                              .append("prefix prov <http://www.prov.org>\n\n");
                
                for (String line : clusterLines) {
                    clusterContent.append(line).append("\n");
                }
                clusterContent.append("\nendDocument");
                
                Files.write(Paths.get(outputDir, clusterName + ".provn"),
                        clusterContent.toString().getBytes());
                System.out.println("Cluster '" + clusterName + "' written to " + outputDir);
            }
        }
    }
}