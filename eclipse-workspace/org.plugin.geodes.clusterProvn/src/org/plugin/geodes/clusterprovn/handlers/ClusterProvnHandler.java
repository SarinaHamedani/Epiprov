package org.plugin.geodes.clusterprovn.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class ClusterProvnHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection selection = HandlerUtil.getCurrentSelection(event);
        if (selection instanceof IStructuredSelection) {
            Object element = ((IStructuredSelection) selection).getFirstElement();
            if (element instanceof IFile) {
                IFile file = (IFile) element;
                if ("provn".equals(file.getFileExtension())) {
                    try {
                        clusterParameters(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new ExecutionException("Error processing .provn file", e);
                    }
                }
            }
        }
        return null;
    }

    private void clusterParameters(IFile file) throws Exception {
        // Build a mapping of any entity to its direct sources from "wasDerivedFrom" relationships.
        // For instance, if we have: wasDerivedFrom(prov:latent_period, prov:Shenzhen_Study)
        // then derivationMap records: "latent_period" -> { "Shenzhen_Study" }
        Map<String, Set<String>> derivationMap = new HashMap<>();

        // Collect root parameters from hadMember statements.
        Set<String> rootParams = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                // Collect root parameters.
                if (line.startsWith("hadMember")) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String param = parts[1].replaceAll("[()\\s]", "").replace("prov:", "");
                        rootParams.add(param);
                    }
                }
                // Collect wasDerivedFrom relationships.
                if (line.startsWith("wasDerivedFrom")) {
                    String inside = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
                    String[] parts = inside.split(",");
                    if (parts.length == 2) {
                        String from = parts[0].replace("prov:", "").trim();
                        String to = parts[1].replace("prov:", "").trim();
                        derivationMap.computeIfAbsent(from, k -> new HashSet<>()).add(to);
                    }
                }
            }
        }

        // For each root parameter, compute its final source set by going two layers deep.
        // For each parameter:
        //   - Get its direct (first-layer) sources.
        //   - For each direct source, if that source has its own wasDerivedFrom entries, use those (second layer);
        //     otherwise, keep the direct source.
        // If no source is found, assign "Unknown".
        Map<String, Set<String>> finalSourcesForParam = new HashMap<>();
        for (String param : rootParams) {
            Set<String> directSources = derivationMap.getOrDefault(param, new HashSet<>());
            Set<String> finalSources = new HashSet<>();
            for (String ds : directSources) {
                Set<String> secondLayer = derivationMap.getOrDefault(ds, new HashSet<>());
                if (!secondLayer.isEmpty()) {
                    finalSources.addAll(secondLayer);
                } else {
                    finalSources.add(ds);
                }
            }
            if (finalSources.isEmpty()) {
                finalSources.add("Unknown");
            }
            finalSourcesForParam.put(param, finalSources);
        }

        // Now perform clustering so that each cluster of parameters has at least one common final source.
        // We want the clusters to be as big as possible while maintaining that the intersection
        // of final sources for all parameters in a cluster is non-empty.
        List<Cluster> clusters = new ArrayList<>();
        // Initially, each parameter is its own cluster.
        for (String param : rootParams) {
            clusters.add(new Cluster(param, finalSourcesForParam.get(param)));
        }

        boolean merged = true;
        while (merged) {
            merged = false;
            outer:
            for (int i = 0; i < clusters.size(); i++) {
                for (int j = i + 1; j < clusters.size(); j++) {
                    Cluster ci = clusters.get(i);
                    Cluster cj = clusters.get(j);
                    // Compute the intersection of common final sources.
                    Set<String> intersection = new HashSet<>(ci.commonSources);
                    intersection.retainAll(cj.commonSources);
                    if (!intersection.isEmpty()) {
                        // Merge clusters: union their parameters and update common sources.
                        ci.params.addAll(cj.params);
                        ci.commonSources = intersection;
                        clusters.remove(j);
                        merged = true;
                        break outer;
                    }
                }
            }
        }

        // Build final mapping: choose for each cluster a representative final source
        // (lexicographically smallest from the common sources) and map it to the cluster's parameters.
        Map<String, Set<String>> sourceToParams = new HashMap<>();
        for (Cluster cl : clusters) {
            String rep;
            if (cl.commonSources.isEmpty()) {
                rep = "Unknown";
            } else {
                rep = new TreeSet<>(cl.commonSources).first();
            }
            sourceToParams.put(rep, cl.params);
        }

        writeJsonOutput(sourceToParams, file.getParent().getLocation().toFile());
    }

    // Cluster helper class: holds the set of parameters and their common final sources.
    private class Cluster {
        Set<String> params;
        Set<String> commonSources;

        Cluster(String param, Set<String> sources) {
            this.params = new HashSet<>();
            this.params.add(param);
            // Make a defensive copy.
            this.commonSources = new HashSet<>(sources);
        }
    }

    private void writeJsonOutput(Map<String, Set<String>> clusters, File outputDir) throws IOException {
        File output = new File(outputDir, "clustered_output.json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write("{\n");
            int i = 0;
            int size = clusters.size();
            for (Map.Entry<String, Set<String>> entry : clusters.entrySet()) {
                writer.write(String.format("  \"%s\": [", entry.getKey()));
                int j = 0;
                int paramsSize = entry.getValue().size();
                for (String param : entry.getValue()) {
                    writer.write("\"" + param + "\"");
                    if (++j < paramsSize) {
                        writer.write(", ");
                    }
                }
                writer.write("]");
                if (++i < size) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("}\n");
        }
    }
}
