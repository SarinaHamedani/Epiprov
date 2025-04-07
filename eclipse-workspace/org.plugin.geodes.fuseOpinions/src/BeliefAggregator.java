import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.xtext.geodes.trustdsl.trustDSL.Agent;
import org.xtext.geodes.trustdsl.trustDSL.Belief;
import org.xtext.geodes.trustdsl.trustDSL.Element;
import org.xtext.geodes.trustdsl.trustDSL.SBoolean;
import org.xtext.geodes.trustdsl.trustDSL.TrustDSLFactory;
import org.xtext.geodes.trustdsl.trustDSL.TrustModel;
import org.xtext.geodes.trustdsl.trustDSL.UncertainElement;
import org.xtext.geodes.trustdsl.trustDSL.UncertainElementFusion;
import org.xtext.geodes.trustdsl.trustDSL.impl.SBooleanImpl;

public class BeliefAggregator extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // Obtain the selected file from the current structured selection.
        IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentStructuredSelection(event);
        if (selection == null || selection.isEmpty()) {
            return null;
        }
        Object element = selection.getFirstElement();
        if (!(element instanceof IFile)) {
            return null;
        }
        IFile file = (IFile) element;
        
        try {
            // Load the TrustDSL model from the selected file.
            URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
            ResourceSet resourceSet = new ResourceSetImpl();
            Resource resource = resourceSet.getResource(uri, true);
            resource.load(Collections.EMPTY_MAP);
            
            // Expect the root element to be a TrustModel.
            EObject root = resource.getContents().get(0);
            if (!(root instanceof TrustModel)) {
                throw new ExecutionException("The file does not contain a valid TrustModel.");
            }
            TrustModel model = (TrustModel) root;
            
            // Create a new list for the updated model elements.
            List<Element> newElements = new ArrayList<>();
            // Iterate over all elements in the model.
            for (Element elem : new ArrayList<>(model.getElements())) {
                // Check if the element is an UncertainElement.
                if (elem instanceof UncertainElement) {
                	UncertainElement ue = (UncertainElement) elem;
                	List<Belief> beliefs = ue.getBeliefs();
                	List<SBooleanFusion> opinions = new ArrayList<>();

                	for (Belief b : beliefs) {
                	    // Cast each opinion to SBooleanFusion
                	    SBoolean opinion = b.getOpinion();
                	    SBooleanFusion bf = new SBooleanFusion(opinion.getBelief(), opinion.getDisbelief(), opinion.getUncertainty(), opinion.getBaseRate());
                	    opinions.add(bf);
                	}

                	// Calculate fusion results using fusion operator methods.
                	SBooleanFusion aleatoryCumulativeBF1 = SBooleanFusion.cumulativeBeliefFusion(opinions);
                	SBooleanFusion averageingBF1 = SBooleanFusion.averageBeliefFusion(opinions);
                	SBooleanFusion beliefConstraintFusion1 = SBooleanFusion.beliefConstraintFusion(opinions);
                	SBooleanFusion consensusCompromiseBF1 = SBooleanFusion.consensusAndCompromiseFusion(opinions);
                	SBooleanFusion epistemicCumulativeBF1 = SBooleanFusion.epistemicCumulativeBeliefFusion(opinions);
                	SBooleanFusion weightedBF1 = SBooleanFusion.weightedBeliefFusion(opinions);

                    SBoolean aleatoryCumulativeBF = this.toSBoolean(aleatoryCumulativeBF1);
                    SBoolean averageingBF = this.toSBoolean(averageingBF1);
                    SBoolean beliefConstraintFusion = this.toSBoolean(beliefConstraintFusion1);
                    SBoolean consensusCompromiseBF = this.toSBoolean(consensusCompromiseBF1);
                    SBoolean epistemicCumulativeBF = this.toSBoolean(epistemicCumulativeBF1);
                    SBoolean weightedBF = this.toSBoolean(weightedBF1);
                    // Create a new UncertainElementFusion instance and copy data from the original UncertainElement.
                    UncertainElementFusion uef = TrustDSLFactory.eINSTANCE.createUncertainElementFusion();
                    uef.setName(ue.getName());
                    uef.getBeliefs().addAll(beliefs);
                    uef.setAleatoryCumulativeBF(aleatoryCumulativeBF);
                    uef.setAverageingBF(averageingBF);
                    uef.setBeliefConstraintFusion(beliefConstraintFusion);
                    uef.setConsensusCompromiseBF(consensusCompromiseBF);
                    uef.setEpistemicCumulativeBF(epistemicCumulativeBF);
                    uef.setWeightedBF(weightedBF);
                    
                    // Add the new fusion element instead of the old one.
                    newElements.add(uef);
                } else {
                    // For all other elements, keep them unchanged.
                    newElements.add(elem);
                }
            }
            
            // Replace the model's elements with the updated list.
            model.getElements().clear();
            model.getElements().addAll(newElements);
            
            // Save the modified model back to the file.
            resource.save(Collections.EMPTY_MAP);
            System.out.println("Fusion applied and file updated: " + file.getName());
            
            // Write the formatted model representation to a new file.
            writeFormattedModel(model, file);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecutionException("Error processing trustdsl file: " + file.getName(), e);
        }
        
        return null;
    }
    
    public SBoolean toSBoolean(SBooleanFusion bf) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	Constructor<SBooleanImpl> cons = SBooleanImpl.class.getDeclaredConstructor();
        cons.setAccessible(true);
        SBoolean sBoolean = cons.newInstance(); 
        
        sBoolean.setBelief(bf.b);
        sBoolean.setDisbelief(bf.d);
        sBoolean.setUncertainty(bf.u);
        sBoolean.setBaseRate(bf.a);
        
        return sBoolean;
    }
    
    /**
     * Writes the formatted TrustModel into a file.
     * The output file is created in the same directory as the original file,
     * with the same base name and a ".formatted.trustdsl" extension.
     */
    private void writeFormattedModel(TrustModel model, IFile originalFile) throws IOException {
        String originalPath = originalFile.getLocation().toOSString();
        String formattedPath;
        int dotIndex = originalPath.lastIndexOf(".");
        if (dotIndex > 0) {
            formattedPath = originalPath.substring(0, dotIndex) + ".formatted.trustdsl";
        } else {
            formattedPath = originalPath + ".formatted.trustdsl";
        }
        
        StringBuilder sb = new StringBuilder();
        for (Element elem : model.getElements()) {
            if (elem instanceof Agent) {
                Agent agent = (Agent) elem;
                sb.append("Agent ").append(agent.getName()).append(System.lineSeparator());
            } else if (elem instanceof UncertainElementFusion) {
                UncertainElementFusion uef = (UncertainElementFusion) elem;
                sb.append(System.lineSeparator());
                sb.append("UncertainElement ").append(uef.getName()).append(" {").append(System.lineSeparator());
                sb.append("    beliefs {").append(System.lineSeparator());
                List<Belief> beliefs = uef.getBeliefs();
                for (int i = 0; i < beliefs.size(); i++) {
                    Belief b = beliefs.get(i);
                    SBoolean opinion = (SBoolean) b.getOpinion();
                    String opinionStr = String.format("(%s, %s, %s, %s)",
                            opinion.getBelief(),
                            opinion.getDisbelief(),
                            opinion.getUncertainty(),
                            opinion.getBaseRate());
                    sb.append("        Belief ").append(b.getName()).append(" ").append(opinionStr);
                    if (i < beliefs.size() - 1) {
                        sb.append(",");
                    }
                    sb.append(System.lineSeparator());
                }
                sb.append("    }").append(System.lineSeparator());
                sb.append("    aleatoryCumulativeBF = ").append(uef.getAleatoryCumulativeBF()).append(System.lineSeparator());
                sb.append("    averageingBF = ").append(uef.getAverageingBF()).append(System.lineSeparator());
                sb.append("    beliefConstraintFusion = ").append(uef.getBeliefConstraintFusion()).append(System.lineSeparator());
                sb.append("    consensusCompromiseBF = ").append(uef.getConsensusCompromiseBF()).append(System.lineSeparator());
                sb.append("    epistemicCumulativeBF = ").append(uef.getEpistemicCumulativeBF()).append(System.lineSeparator());
                sb.append("    weightedBF = ").append(uef.getWeightedBF()).append(System.lineSeparator());
                sb.append("}").append(System.lineSeparator());
            }
        }
        
        Files.write(Paths.get(formattedPath), sb.toString().getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Formatted model written to file: " + formattedPath);
    }
}
