package org.xtext.geodes.trustdsl.formatting2;

import com.google.inject.Inject;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.xtext.geodes.trustdsl.services.TrustDSLGrammarAccess;
import org.xtext.geodes.trustdsl.trustDSL.Agent;
import org.xtext.geodes.trustdsl.trustDSL.Belief;
import org.xtext.geodes.trustdsl.trustDSL.Element;
import org.xtext.geodes.trustdsl.trustDSL.TrustModel;
import org.xtext.geodes.trustdsl.trustDSL.UncertainElement;

public class TrustDSLFormatter extends AbstractJavaFormatter {
	@Inject
	TrustDSLGrammarAccess grammarAccess;
	
//	@Override
    protected void configureFormatting(IFormattableDocument document) {
        // This is the entry point. Leave empty unless you want to format globally.
    }
    
    
    protected void format(TrustModel model, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
//        ISemanticRegion documentKeyword = textRegionExtensions.regionFor(model).keyword("document");
//        if (documentKeyword != null) {
//            doc.append(documentKeyword, it -> it.setNewLines(1));
//        }
        for (Element elem: model.getElements()) {
        	doc.format(elem);
        }
		
	}

    protected void format(Agent agent, IFormattableDocument doc) {
        ISemanticRegion documentKeyword = textRegionExtensions.regionFor(agent).keyword(grammarAccess.getAgentAccess().getAgentKeyword_0());
        if (documentKeyword != null) {
            doc.prepend(documentKeyword, it -> it.setNewLines(1));
        }		
	}
    
    protected void format(UncertainElement ue, IFormattableDocument doc) {
    	ISemanticRegion leftCurlyRegion = textRegionExtensions.regionFor(ue).keyword(grammarAccess.getUncertainElementAccess().getLeftCurlyBracketKeyword_2());
        doc.append(leftCurlyRegion, it -> it.setNewLines(1));
        
        ISemanticRegion rightCurlyRegion = textRegionExtensions.regionFor(ue).keyword(grammarAccess.getUncertainElementAccess().getRightCurlyBracketKeyword_8());
        doc.append(rightCurlyRegion, it -> it.setNewLines(1));

        
        doc.interior(leftCurlyRegion, rightCurlyRegion, it -> it.indent());
        
        for (Belief belief : ue.getBeliefs()) {
            doc.format(belief);
        }
	}
    
    protected void format(Belief belief, IFormattableDocument doc) {
    	ISemanticRegion comma = textRegionExtensions.regionFor(belief)
	        .keyword(",");
	    if (comma != null) {
	        doc.prepend(comma, it -> it.oneSpace());
	        doc.append(comma, it -> it.oneSpace());
	    } else {
	        ISemanticRegion beliefKeyword = textRegionExtensions.regionFor(belief)
	            .keyword(grammarAccess.getBeliefAccess().getBeliefKeyword_0());
	        if (beliefKeyword != null) {
	            doc.prepend(beliefKeyword, it -> it.setNewLines(1));
	        }
	    }
    }
}
