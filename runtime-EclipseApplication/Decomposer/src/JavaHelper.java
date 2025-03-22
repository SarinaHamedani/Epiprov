import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;


import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class JavaHelper {

    /**
     * Merges all `UncertainElements` in the active diagram into `UncertainElementFusion`.
     */
    public static void fuseUncertainElements() {
        Project project = Application.getInstance().getProject();
        if (project == null) {
            Application.getInstance().getGUILog().showError("No active MagicDraw project found.");
            return;
        }

        String profileName = "BeliefUncertaintyProfile";
        String stereotypeName = "UncertainElementFusion";

        Stereotype uncertainElementStereotype = getStereotype(project, profileName, stereotypeName);
        if (uncertainElementStereotype == null) {
            Application.getInstance().getGUILog().showError("Stereotype UncertainElementFusion not found in profile: " + profileName);
            return;
        }

        List<Element> stereotypedElements = getStereotypedElements(project, uncertainElementStereotype);
        for (Element element : stereotypedElements) {
            List<Belief> beliefs = getBeliefs(element);
            List<SBoolean> fusionValues = new ArrayList<>();

            for (Belief belief : beliefs) {
                fusionValues.add(belief.getOpinion());
            }

            if (fusionValues.size() > 1 && differentAgents(beliefs)) {
                applyFusionMethods(project, element, uncertainElementStereotype, fusionValues);
            }
        }
    }

    private static void applyFusionMethods(List<SBoolean> opinions) {
        System.out.println("FUSION RESULTS for: " + element.getHumanName());

        SBoolean BCF = SBoolean.beliefConstraintFusion(opinions);

        SBoolean ABF = SBoolean.averageBeliefFusion(opinions);

        SBoolean ACBF = SBoolean.cumulativeBeliefFusion(opinions);

        SBoolean ECBF = SBoolean.epistemicCumulativeBeliefFusion(opinions);

        SBoolean WBF = SBoolean.weightedBeliefFusion(opinions);

        SBoolean CC = SBoolean.consensusAndCompromiseFusion(opinions);
        
    }

    
    private static boolean sameBaseRates(List<SBoolean> beliefs) {
        double baseRate = beliefs.get(0).baseRate();
        return beliefs.stream().allMatch(b -> b.baseRate() == baseRate);
    }
    

    private static List<Belief> getBeliefs(Element element) {
        List<Belief> results = new ArrayList<>();
        List<InstanceSpecification> tagValues = StereotypesHelper.getStereotypePropertyValue(element, "UncertainElement", "beliefs");

        for (InstanceSpecification tagValue : tagValues) {
            String agent = null;
            String opinion = null;

            for (EObject obj : tagValue.eContents()) {
                if (obj instanceof LiteralString) {
                    opinion = ((LiteralString) obj).getValue();
                } else if (obj instanceof InstanceSpecification) {
                    agent = ModelHelper.getValueString((InstanceSpecification) obj);
                }
            }

            if (agent != null && opinion != null) {
                try {
                    results.add(new Belief(agent, new SBoolean(opinion)));
                } catch (InputMismatchException error) {
                    Application.getInstance().getGUILog().showError("[ERROR] " + error.getMessage());
                }
            }
        }
        return results;
    }
}
