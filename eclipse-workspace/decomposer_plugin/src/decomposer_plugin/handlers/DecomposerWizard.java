package decomposer_plugin.handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

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

    /**
     * Splits the PROVN file based on the clusters defined in the JSON file.
     */
    private void splitProvn(String filePath, String jsonFile, String outputDir) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<String>> clusters = objectMapper.readValue(new File(jsonFile), Map.class);

        for (Map.Entry<String, List<String>> entry : clusters.entrySet()) {
            String clusterName = entry.getKey();
            List<String> entities = entry.getValue();

            StringBuilder clusterContent = new StringBuilder();
            clusterContent.append("document\n\n")
                          .append("prefix epi <http://www.cs.rpi.edu/~hendler/>\n")
                          .append("prefix prov <http://www.prov.org>\n\n");

            // Process each line in the PROVN file.
            for (String line : lines) {
                for (String entity : entities) {
                    if (line.contains(entity)) {
                        clusterContent.append(line).append("\n");
                        break;
                    }
                }
            }
            clusterContent.append("\nendDocument");

            Files.write(Paths.get(outputDir, clusterName + ".provn"), clusterContent.toString().getBytes());
        }
    }
}