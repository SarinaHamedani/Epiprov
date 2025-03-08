package org.xtext.geodes.trustdsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.geodes.trustdsl.services.TrustDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTrustDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Agent'", "'UncertainElement'", "'{'", "'beliefs'", "','", "'}'", "'Belief'", "'('", "')'", "'UncertainElementFusion'", "'aleatoryCumulativeBF'", "'='", "'averageingBF'", "'beliefConstraintFusion'", "'epistemicCumulativeBF'", "'weightedBF'", "'.'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTrustDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTrustDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTrustDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTrustDSL.g"; }



     	private TrustDSLGrammarAccess grammarAccess;

        public InternalTrustDSLParser(TokenStream input, TrustDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "TrustModel";
       	}

       	@Override
       	protected TrustDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTrustModel"
    // InternalTrustDSL.g:64:1: entryRuleTrustModel returns [EObject current=null] : iv_ruleTrustModel= ruleTrustModel EOF ;
    public final EObject entryRuleTrustModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrustModel = null;


        try {
            // InternalTrustDSL.g:64:51: (iv_ruleTrustModel= ruleTrustModel EOF )
            // InternalTrustDSL.g:65:2: iv_ruleTrustModel= ruleTrustModel EOF
            {
             newCompositeNode(grammarAccess.getTrustModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrustModel=ruleTrustModel();

            state._fsp--;

             current =iv_ruleTrustModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrustModel"


    // $ANTLR start "ruleTrustModel"
    // InternalTrustDSL.g:71:1: ruleTrustModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleTrustModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalTrustDSL.g:77:2: ( ( (lv_elements_0_0= ruleElement ) )* )
            // InternalTrustDSL.g:78:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // InternalTrustDSL.g:78:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)||LA1_0==17||LA1_0==20) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTrustDSL.g:79:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // InternalTrustDSL.g:79:3: (lv_elements_0_0= ruleElement )
            	    // InternalTrustDSL.g:80:4: lv_elements_0_0= ruleElement
            	    {

            	    				newCompositeNode(grammarAccess.getTrustModelAccess().getElementsElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getTrustModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.xtext.geodes.trustdsl.TrustDSL.Element");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrustModel"


    // $ANTLR start "entryRuleElement"
    // InternalTrustDSL.g:100:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalTrustDSL.g:100:48: (iv_ruleElement= ruleElement EOF )
            // InternalTrustDSL.g:101:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalTrustDSL.g:107:1: ruleElement returns [EObject current=null] : (this_Agent_0= ruleAgent | this_UncertainElement_1= ruleUncertainElement | this_UncertainElementFusion_2= ruleUncertainElementFusion | this_Belief_3= ruleBelief ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Agent_0 = null;

        EObject this_UncertainElement_1 = null;

        EObject this_UncertainElementFusion_2 = null;

        EObject this_Belief_3 = null;



        	enterRule();

        try {
            // InternalTrustDSL.g:113:2: ( (this_Agent_0= ruleAgent | this_UncertainElement_1= ruleUncertainElement | this_UncertainElementFusion_2= ruleUncertainElementFusion | this_Belief_3= ruleBelief ) )
            // InternalTrustDSL.g:114:2: (this_Agent_0= ruleAgent | this_UncertainElement_1= ruleUncertainElement | this_UncertainElementFusion_2= ruleUncertainElementFusion | this_Belief_3= ruleBelief )
            {
            // InternalTrustDSL.g:114:2: (this_Agent_0= ruleAgent | this_UncertainElement_1= ruleUncertainElement | this_UncertainElementFusion_2= ruleUncertainElementFusion | this_Belief_3= ruleBelief )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 20:
                {
                alt2=3;
                }
                break;
            case 17:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalTrustDSL.g:115:3: this_Agent_0= ruleAgent
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getAgentParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Agent_0=ruleAgent();

                    state._fsp--;


                    			current = this_Agent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTrustDSL.g:124:3: this_UncertainElement_1= ruleUncertainElement
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getUncertainElementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UncertainElement_1=ruleUncertainElement();

                    state._fsp--;


                    			current = this_UncertainElement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTrustDSL.g:133:3: this_UncertainElementFusion_2= ruleUncertainElementFusion
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getUncertainElementFusionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_UncertainElementFusion_2=ruleUncertainElementFusion();

                    state._fsp--;


                    			current = this_UncertainElementFusion_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTrustDSL.g:142:3: this_Belief_3= ruleBelief
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getBeliefParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Belief_3=ruleBelief();

                    state._fsp--;


                    			current = this_Belief_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleAgent"
    // InternalTrustDSL.g:154:1: entryRuleAgent returns [EObject current=null] : iv_ruleAgent= ruleAgent EOF ;
    public final EObject entryRuleAgent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAgent = null;


        try {
            // InternalTrustDSL.g:154:46: (iv_ruleAgent= ruleAgent EOF )
            // InternalTrustDSL.g:155:2: iv_ruleAgent= ruleAgent EOF
            {
             newCompositeNode(grammarAccess.getAgentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAgent=ruleAgent();

            state._fsp--;

             current =iv_ruleAgent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAgent"


    // $ANTLR start "ruleAgent"
    // InternalTrustDSL.g:161:1: ruleAgent returns [EObject current=null] : (otherlv_0= 'Agent' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAgent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTrustDSL.g:167:2: ( (otherlv_0= 'Agent' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTrustDSL.g:168:2: (otherlv_0= 'Agent' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTrustDSL.g:168:2: (otherlv_0= 'Agent' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTrustDSL.g:169:3: otherlv_0= 'Agent' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAgentAccess().getAgentKeyword_0());
            		
            // InternalTrustDSL.g:173:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTrustDSL.g:174:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTrustDSL.g:174:4: (lv_name_1_0= RULE_ID )
            // InternalTrustDSL.g:175:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAgentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAgentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAgent"


    // $ANTLR start "entryRuleUncertainElement"
    // InternalTrustDSL.g:195:1: entryRuleUncertainElement returns [EObject current=null] : iv_ruleUncertainElement= ruleUncertainElement EOF ;
    public final EObject entryRuleUncertainElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUncertainElement = null;


        try {
            // InternalTrustDSL.g:195:57: (iv_ruleUncertainElement= ruleUncertainElement EOF )
            // InternalTrustDSL.g:196:2: iv_ruleUncertainElement= ruleUncertainElement EOF
            {
             newCompositeNode(grammarAccess.getUncertainElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUncertainElement=ruleUncertainElement();

            state._fsp--;

             current =iv_ruleUncertainElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUncertainElement"


    // $ANTLR start "ruleUncertainElement"
    // InternalTrustDSL.g:202:1: ruleUncertainElement returns [EObject current=null] : (otherlv_0= 'UncertainElement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= '}' ) ;
    public final EObject ruleUncertainElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_beliefs_5_0 = null;

        EObject lv_beliefs_7_0 = null;



        	enterRule();

        try {
            // InternalTrustDSL.g:208:2: ( (otherlv_0= 'UncertainElement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= '}' ) )
            // InternalTrustDSL.g:209:2: (otherlv_0= 'UncertainElement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= '}' )
            {
            // InternalTrustDSL.g:209:2: (otherlv_0= 'UncertainElement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= '}' )
            // InternalTrustDSL.g:210:3: otherlv_0= 'UncertainElement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUncertainElementAccess().getUncertainElementKeyword_0());
            		
            // InternalTrustDSL.g:214:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTrustDSL.g:215:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTrustDSL.g:215:4: (lv_name_1_0= RULE_ID )
            // InternalTrustDSL.g:216:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUncertainElementAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUncertainElementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getUncertainElementAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getUncertainElementAccess().getBeliefsKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getUncertainElementAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalTrustDSL.g:244:3: ( (lv_beliefs_5_0= ruleBelief ) )
            // InternalTrustDSL.g:245:4: (lv_beliefs_5_0= ruleBelief )
            {
            // InternalTrustDSL.g:245:4: (lv_beliefs_5_0= ruleBelief )
            // InternalTrustDSL.g:246:5: lv_beliefs_5_0= ruleBelief
            {

            					newCompositeNode(grammarAccess.getUncertainElementAccess().getBeliefsBeliefParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_8);
            lv_beliefs_5_0=ruleBelief();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUncertainElementRule());
            					}
            					add(
            						current,
            						"beliefs",
            						lv_beliefs_5_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.Belief");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTrustDSL.g:263:3: (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTrustDSL.g:264:4: otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) )
            	    {
            	    otherlv_6=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_6, grammarAccess.getUncertainElementAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTrustDSL.g:268:4: ( (lv_beliefs_7_0= ruleBelief ) )
            	    // InternalTrustDSL.g:269:5: (lv_beliefs_7_0= ruleBelief )
            	    {
            	    // InternalTrustDSL.g:269:5: (lv_beliefs_7_0= ruleBelief )
            	    // InternalTrustDSL.g:270:6: lv_beliefs_7_0= ruleBelief
            	    {

            	    						newCompositeNode(grammarAccess.getUncertainElementAccess().getBeliefsBeliefParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_beliefs_7_0=ruleBelief();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUncertainElementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"beliefs",
            	    							lv_beliefs_7_0,
            	    							"org.xtext.geodes.trustdsl.TrustDSL.Belief");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_8=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_8, grammarAccess.getUncertainElementAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getUncertainElementAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUncertainElement"


    // $ANTLR start "entryRuleBelief"
    // InternalTrustDSL.g:300:1: entryRuleBelief returns [EObject current=null] : iv_ruleBelief= ruleBelief EOF ;
    public final EObject entryRuleBelief() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBelief = null;


        try {
            // InternalTrustDSL.g:300:47: (iv_ruleBelief= ruleBelief EOF )
            // InternalTrustDSL.g:301:2: iv_ruleBelief= ruleBelief EOF
            {
             newCompositeNode(grammarAccess.getBeliefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBelief=ruleBelief();

            state._fsp--;

             current =iv_ruleBelief; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBelief"


    // $ANTLR start "ruleBelief"
    // InternalTrustDSL.g:307:1: ruleBelief returns [EObject current=null] : (otherlv_0= 'Belief' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (lv_opinion_5_0= ruleSBoolean ) ) otherlv_6= ')' ) ;
    public final EObject ruleBelief() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_opinion_5_0 = null;



        	enterRule();

        try {
            // InternalTrustDSL.g:313:2: ( (otherlv_0= 'Belief' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (lv_opinion_5_0= ruleSBoolean ) ) otherlv_6= ')' ) )
            // InternalTrustDSL.g:314:2: (otherlv_0= 'Belief' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (lv_opinion_5_0= ruleSBoolean ) ) otherlv_6= ')' )
            {
            // InternalTrustDSL.g:314:2: (otherlv_0= 'Belief' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (lv_opinion_5_0= ruleSBoolean ) ) otherlv_6= ')' )
            // InternalTrustDSL.g:315:3: otherlv_0= 'Belief' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ',' ( (lv_opinion_5_0= ruleSBoolean ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getBeliefAccess().getBeliefKeyword_0());
            		
            // InternalTrustDSL.g:319:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTrustDSL.g:320:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTrustDSL.g:320:4: (lv_name_1_0= RULE_ID )
            // InternalTrustDSL.g:321:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBeliefAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBeliefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getBeliefAccess().getLeftParenthesisKeyword_2());
            		
            // InternalTrustDSL.g:341:3: ( (otherlv_3= RULE_ID ) )
            // InternalTrustDSL.g:342:4: (otherlv_3= RULE_ID )
            {
            // InternalTrustDSL.g:342:4: (otherlv_3= RULE_ID )
            // InternalTrustDSL.g:343:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBeliefRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_3, grammarAccess.getBeliefAccess().getAgentAgentCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getBeliefAccess().getCommaKeyword_4());
            		
            // InternalTrustDSL.g:358:3: ( (lv_opinion_5_0= ruleSBoolean ) )
            // InternalTrustDSL.g:359:4: (lv_opinion_5_0= ruleSBoolean )
            {
            // InternalTrustDSL.g:359:4: (lv_opinion_5_0= ruleSBoolean )
            // InternalTrustDSL.g:360:5: lv_opinion_5_0= ruleSBoolean
            {

            					newCompositeNode(grammarAccess.getBeliefAccess().getOpinionSBooleanParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_12);
            lv_opinion_5_0=ruleSBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBeliefRule());
            					}
            					set(
            						current,
            						"opinion",
            						lv_opinion_5_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.SBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getBeliefAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBelief"


    // $ANTLR start "entryRuleSBoolean"
    // InternalTrustDSL.g:385:1: entryRuleSBoolean returns [EObject current=null] : iv_ruleSBoolean= ruleSBoolean EOF ;
    public final EObject entryRuleSBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSBoolean = null;


        try {
            // InternalTrustDSL.g:385:49: (iv_ruleSBoolean= ruleSBoolean EOF )
            // InternalTrustDSL.g:386:2: iv_ruleSBoolean= ruleSBoolean EOF
            {
             newCompositeNode(grammarAccess.getSBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSBoolean=ruleSBoolean();

            state._fsp--;

             current =iv_ruleSBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSBoolean"


    // $ANTLR start "ruleSBoolean"
    // InternalTrustDSL.g:392:1: ruleSBoolean returns [EObject current=null] : (otherlv_0= '(' ( (lv_belief_1_0= ruleREAL ) ) otherlv_2= ',' ( (lv_disbelief_3_0= ruleREAL ) ) otherlv_4= ',' ( (lv_uncertainty_5_0= ruleREAL ) ) otherlv_6= ',' ( (lv_baseRate_7_0= ruleREAL ) ) otherlv_8= ')' ) ;
    public final EObject ruleSBoolean() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_belief_1_0 = null;

        AntlrDatatypeRuleToken lv_disbelief_3_0 = null;

        AntlrDatatypeRuleToken lv_uncertainty_5_0 = null;

        AntlrDatatypeRuleToken lv_baseRate_7_0 = null;



        	enterRule();

        try {
            // InternalTrustDSL.g:398:2: ( (otherlv_0= '(' ( (lv_belief_1_0= ruleREAL ) ) otherlv_2= ',' ( (lv_disbelief_3_0= ruleREAL ) ) otherlv_4= ',' ( (lv_uncertainty_5_0= ruleREAL ) ) otherlv_6= ',' ( (lv_baseRate_7_0= ruleREAL ) ) otherlv_8= ')' ) )
            // InternalTrustDSL.g:399:2: (otherlv_0= '(' ( (lv_belief_1_0= ruleREAL ) ) otherlv_2= ',' ( (lv_disbelief_3_0= ruleREAL ) ) otherlv_4= ',' ( (lv_uncertainty_5_0= ruleREAL ) ) otherlv_6= ',' ( (lv_baseRate_7_0= ruleREAL ) ) otherlv_8= ')' )
            {
            // InternalTrustDSL.g:399:2: (otherlv_0= '(' ( (lv_belief_1_0= ruleREAL ) ) otherlv_2= ',' ( (lv_disbelief_3_0= ruleREAL ) ) otherlv_4= ',' ( (lv_uncertainty_5_0= ruleREAL ) ) otherlv_6= ',' ( (lv_baseRate_7_0= ruleREAL ) ) otherlv_8= ')' )
            // InternalTrustDSL.g:400:3: otherlv_0= '(' ( (lv_belief_1_0= ruleREAL ) ) otherlv_2= ',' ( (lv_disbelief_3_0= ruleREAL ) ) otherlv_4= ',' ( (lv_uncertainty_5_0= ruleREAL ) ) otherlv_6= ',' ( (lv_baseRate_7_0= ruleREAL ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getSBooleanAccess().getLeftParenthesisKeyword_0());
            		
            // InternalTrustDSL.g:404:3: ( (lv_belief_1_0= ruleREAL ) )
            // InternalTrustDSL.g:405:4: (lv_belief_1_0= ruleREAL )
            {
            // InternalTrustDSL.g:405:4: (lv_belief_1_0= ruleREAL )
            // InternalTrustDSL.g:406:5: lv_belief_1_0= ruleREAL
            {

            					newCompositeNode(grammarAccess.getSBooleanAccess().getBeliefREALParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_belief_1_0=ruleREAL();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSBooleanRule());
            					}
            					set(
            						current,
            						"belief",
            						lv_belief_1_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.REAL");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getSBooleanAccess().getCommaKeyword_2());
            		
            // InternalTrustDSL.g:427:3: ( (lv_disbelief_3_0= ruleREAL ) )
            // InternalTrustDSL.g:428:4: (lv_disbelief_3_0= ruleREAL )
            {
            // InternalTrustDSL.g:428:4: (lv_disbelief_3_0= ruleREAL )
            // InternalTrustDSL.g:429:5: lv_disbelief_3_0= ruleREAL
            {

            					newCompositeNode(grammarAccess.getSBooleanAccess().getDisbeliefREALParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_disbelief_3_0=ruleREAL();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSBooleanRule());
            					}
            					set(
            						current,
            						"disbelief",
            						lv_disbelief_3_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.REAL");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getSBooleanAccess().getCommaKeyword_4());
            		
            // InternalTrustDSL.g:450:3: ( (lv_uncertainty_5_0= ruleREAL ) )
            // InternalTrustDSL.g:451:4: (lv_uncertainty_5_0= ruleREAL )
            {
            // InternalTrustDSL.g:451:4: (lv_uncertainty_5_0= ruleREAL )
            // InternalTrustDSL.g:452:5: lv_uncertainty_5_0= ruleREAL
            {

            					newCompositeNode(grammarAccess.getSBooleanAccess().getUncertaintyREALParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_uncertainty_5_0=ruleREAL();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSBooleanRule());
            					}
            					set(
            						current,
            						"uncertainty",
            						lv_uncertainty_5_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.REAL");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_13); 

            			newLeafNode(otherlv_6, grammarAccess.getSBooleanAccess().getCommaKeyword_6());
            		
            // InternalTrustDSL.g:473:3: ( (lv_baseRate_7_0= ruleREAL ) )
            // InternalTrustDSL.g:474:4: (lv_baseRate_7_0= ruleREAL )
            {
            // InternalTrustDSL.g:474:4: (lv_baseRate_7_0= ruleREAL )
            // InternalTrustDSL.g:475:5: lv_baseRate_7_0= ruleREAL
            {

            					newCompositeNode(grammarAccess.getSBooleanAccess().getBaseRateREALParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_baseRate_7_0=ruleREAL();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSBooleanRule());
            					}
            					set(
            						current,
            						"baseRate",
            						lv_baseRate_7_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.REAL");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSBooleanAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSBoolean"


    // $ANTLR start "entryRuleUncertainElementFusion"
    // InternalTrustDSL.g:500:1: entryRuleUncertainElementFusion returns [EObject current=null] : iv_ruleUncertainElementFusion= ruleUncertainElementFusion EOF ;
    public final EObject entryRuleUncertainElementFusion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUncertainElementFusion = null;


        try {
            // InternalTrustDSL.g:500:63: (iv_ruleUncertainElementFusion= ruleUncertainElementFusion EOF )
            // InternalTrustDSL.g:501:2: iv_ruleUncertainElementFusion= ruleUncertainElementFusion EOF
            {
             newCompositeNode(grammarAccess.getUncertainElementFusionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUncertainElementFusion=ruleUncertainElementFusion();

            state._fsp--;

             current =iv_ruleUncertainElementFusion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUncertainElementFusion"


    // $ANTLR start "ruleUncertainElementFusion"
    // InternalTrustDSL.g:507:1: ruleUncertainElementFusion returns [EObject current=null] : (otherlv_0= 'UncertainElementFusion' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= 'aleatoryCumulativeBF' otherlv_10= '=' ( (lv_aleatoryCumulativeBF_11_0= ruleSBoolean ) ) otherlv_12= 'averageingBF' otherlv_13= '=' ( (lv_averageingBF_14_0= ruleSBoolean ) ) otherlv_15= 'beliefConstraintFusion' otherlv_16= '=' ( (lv_beliefConstraintFusion_17_0= ruleSBoolean ) ) otherlv_18= 'epistemicCumulativeBF' otherlv_19= '=' ( (lv_epistemicCumulativeBF_20_0= ruleSBoolean ) ) otherlv_21= 'weightedBF' otherlv_22= '=' ( (lv_weightedBF_23_0= ruleSBoolean ) ) otherlv_24= '}' ) ;
    public final EObject ruleUncertainElementFusion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        EObject lv_beliefs_5_0 = null;

        EObject lv_beliefs_7_0 = null;

        EObject lv_aleatoryCumulativeBF_11_0 = null;

        EObject lv_averageingBF_14_0 = null;

        EObject lv_beliefConstraintFusion_17_0 = null;

        EObject lv_epistemicCumulativeBF_20_0 = null;

        EObject lv_weightedBF_23_0 = null;



        	enterRule();

        try {
            // InternalTrustDSL.g:513:2: ( (otherlv_0= 'UncertainElementFusion' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= 'aleatoryCumulativeBF' otherlv_10= '=' ( (lv_aleatoryCumulativeBF_11_0= ruleSBoolean ) ) otherlv_12= 'averageingBF' otherlv_13= '=' ( (lv_averageingBF_14_0= ruleSBoolean ) ) otherlv_15= 'beliefConstraintFusion' otherlv_16= '=' ( (lv_beliefConstraintFusion_17_0= ruleSBoolean ) ) otherlv_18= 'epistemicCumulativeBF' otherlv_19= '=' ( (lv_epistemicCumulativeBF_20_0= ruleSBoolean ) ) otherlv_21= 'weightedBF' otherlv_22= '=' ( (lv_weightedBF_23_0= ruleSBoolean ) ) otherlv_24= '}' ) )
            // InternalTrustDSL.g:514:2: (otherlv_0= 'UncertainElementFusion' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= 'aleatoryCumulativeBF' otherlv_10= '=' ( (lv_aleatoryCumulativeBF_11_0= ruleSBoolean ) ) otherlv_12= 'averageingBF' otherlv_13= '=' ( (lv_averageingBF_14_0= ruleSBoolean ) ) otherlv_15= 'beliefConstraintFusion' otherlv_16= '=' ( (lv_beliefConstraintFusion_17_0= ruleSBoolean ) ) otherlv_18= 'epistemicCumulativeBF' otherlv_19= '=' ( (lv_epistemicCumulativeBF_20_0= ruleSBoolean ) ) otherlv_21= 'weightedBF' otherlv_22= '=' ( (lv_weightedBF_23_0= ruleSBoolean ) ) otherlv_24= '}' )
            {
            // InternalTrustDSL.g:514:2: (otherlv_0= 'UncertainElementFusion' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= 'aleatoryCumulativeBF' otherlv_10= '=' ( (lv_aleatoryCumulativeBF_11_0= ruleSBoolean ) ) otherlv_12= 'averageingBF' otherlv_13= '=' ( (lv_averageingBF_14_0= ruleSBoolean ) ) otherlv_15= 'beliefConstraintFusion' otherlv_16= '=' ( (lv_beliefConstraintFusion_17_0= ruleSBoolean ) ) otherlv_18= 'epistemicCumulativeBF' otherlv_19= '=' ( (lv_epistemicCumulativeBF_20_0= ruleSBoolean ) ) otherlv_21= 'weightedBF' otherlv_22= '=' ( (lv_weightedBF_23_0= ruleSBoolean ) ) otherlv_24= '}' )
            // InternalTrustDSL.g:515:3: otherlv_0= 'UncertainElementFusion' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'beliefs' otherlv_4= '{' ( (lv_beliefs_5_0= ruleBelief ) ) (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )* otherlv_8= '}' otherlv_9= 'aleatoryCumulativeBF' otherlv_10= '=' ( (lv_aleatoryCumulativeBF_11_0= ruleSBoolean ) ) otherlv_12= 'averageingBF' otherlv_13= '=' ( (lv_averageingBF_14_0= ruleSBoolean ) ) otherlv_15= 'beliefConstraintFusion' otherlv_16= '=' ( (lv_beliefConstraintFusion_17_0= ruleSBoolean ) ) otherlv_18= 'epistemicCumulativeBF' otherlv_19= '=' ( (lv_epistemicCumulativeBF_20_0= ruleSBoolean ) ) otherlv_21= 'weightedBF' otherlv_22= '=' ( (lv_weightedBF_23_0= ruleSBoolean ) ) otherlv_24= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUncertainElementFusionAccess().getUncertainElementFusionKeyword_0());
            		
            // InternalTrustDSL.g:519:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTrustDSL.g:520:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTrustDSL.g:520:4: (lv_name_1_0= RULE_ID )
            // InternalTrustDSL.g:521:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUncertainElementFusionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUncertainElementFusionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getUncertainElementFusionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getUncertainElementFusionAccess().getBeliefsKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getUncertainElementFusionAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalTrustDSL.g:549:3: ( (lv_beliefs_5_0= ruleBelief ) )
            // InternalTrustDSL.g:550:4: (lv_beliefs_5_0= ruleBelief )
            {
            // InternalTrustDSL.g:550:4: (lv_beliefs_5_0= ruleBelief )
            // InternalTrustDSL.g:551:5: lv_beliefs_5_0= ruleBelief
            {

            					newCompositeNode(grammarAccess.getUncertainElementFusionAccess().getBeliefsBeliefParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_8);
            lv_beliefs_5_0=ruleBelief();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUncertainElementFusionRule());
            					}
            					add(
            						current,
            						"beliefs",
            						lv_beliefs_5_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.Belief");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTrustDSL.g:568:3: (otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTrustDSL.g:569:4: otherlv_6= ',' ( (lv_beliefs_7_0= ruleBelief ) )
            	    {
            	    otherlv_6=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_6, grammarAccess.getUncertainElementFusionAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTrustDSL.g:573:4: ( (lv_beliefs_7_0= ruleBelief ) )
            	    // InternalTrustDSL.g:574:5: (lv_beliefs_7_0= ruleBelief )
            	    {
            	    // InternalTrustDSL.g:574:5: (lv_beliefs_7_0= ruleBelief )
            	    // InternalTrustDSL.g:575:6: lv_beliefs_7_0= ruleBelief
            	    {

            	    						newCompositeNode(grammarAccess.getUncertainElementFusionAccess().getBeliefsBeliefParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_beliefs_7_0=ruleBelief();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUncertainElementFusionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"beliefs",
            	    							lv_beliefs_7_0,
            	    							"org.xtext.geodes.trustdsl.TrustDSL.Belief");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_8=(Token)match(input,16,FOLLOW_14); 

            			newLeafNode(otherlv_8, grammarAccess.getUncertainElementFusionAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_9=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getUncertainElementFusionAccess().getAleatoryCumulativeBFKeyword_8());
            		
            otherlv_10=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getUncertainElementFusionAccess().getEqualsSignKeyword_9());
            		
            // InternalTrustDSL.g:605:3: ( (lv_aleatoryCumulativeBF_11_0= ruleSBoolean ) )
            // InternalTrustDSL.g:606:4: (lv_aleatoryCumulativeBF_11_0= ruleSBoolean )
            {
            // InternalTrustDSL.g:606:4: (lv_aleatoryCumulativeBF_11_0= ruleSBoolean )
            // InternalTrustDSL.g:607:5: lv_aleatoryCumulativeBF_11_0= ruleSBoolean
            {

            					newCompositeNode(grammarAccess.getUncertainElementFusionAccess().getAleatoryCumulativeBFSBooleanParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_16);
            lv_aleatoryCumulativeBF_11_0=ruleSBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUncertainElementFusionRule());
            					}
            					set(
            						current,
            						"aleatoryCumulativeBF",
            						lv_aleatoryCumulativeBF_11_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.SBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,23,FOLLOW_15); 

            			newLeafNode(otherlv_12, grammarAccess.getUncertainElementFusionAccess().getAverageingBFKeyword_11());
            		
            otherlv_13=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_13, grammarAccess.getUncertainElementFusionAccess().getEqualsSignKeyword_12());
            		
            // InternalTrustDSL.g:632:3: ( (lv_averageingBF_14_0= ruleSBoolean ) )
            // InternalTrustDSL.g:633:4: (lv_averageingBF_14_0= ruleSBoolean )
            {
            // InternalTrustDSL.g:633:4: (lv_averageingBF_14_0= ruleSBoolean )
            // InternalTrustDSL.g:634:5: lv_averageingBF_14_0= ruleSBoolean
            {

            					newCompositeNode(grammarAccess.getUncertainElementFusionAccess().getAverageingBFSBooleanParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_17);
            lv_averageingBF_14_0=ruleSBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUncertainElementFusionRule());
            					}
            					set(
            						current,
            						"averageingBF",
            						lv_averageingBF_14_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.SBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,24,FOLLOW_15); 

            			newLeafNode(otherlv_15, grammarAccess.getUncertainElementFusionAccess().getBeliefConstraintFusionKeyword_14());
            		
            otherlv_16=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_16, grammarAccess.getUncertainElementFusionAccess().getEqualsSignKeyword_15());
            		
            // InternalTrustDSL.g:659:3: ( (lv_beliefConstraintFusion_17_0= ruleSBoolean ) )
            // InternalTrustDSL.g:660:4: (lv_beliefConstraintFusion_17_0= ruleSBoolean )
            {
            // InternalTrustDSL.g:660:4: (lv_beliefConstraintFusion_17_0= ruleSBoolean )
            // InternalTrustDSL.g:661:5: lv_beliefConstraintFusion_17_0= ruleSBoolean
            {

            					newCompositeNode(grammarAccess.getUncertainElementFusionAccess().getBeliefConstraintFusionSBooleanParserRuleCall_16_0());
            				
            pushFollow(FOLLOW_18);
            lv_beliefConstraintFusion_17_0=ruleSBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUncertainElementFusionRule());
            					}
            					set(
            						current,
            						"beliefConstraintFusion",
            						lv_beliefConstraintFusion_17_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.SBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_18=(Token)match(input,25,FOLLOW_15); 

            			newLeafNode(otherlv_18, grammarAccess.getUncertainElementFusionAccess().getEpistemicCumulativeBFKeyword_17());
            		
            otherlv_19=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_19, grammarAccess.getUncertainElementFusionAccess().getEqualsSignKeyword_18());
            		
            // InternalTrustDSL.g:686:3: ( (lv_epistemicCumulativeBF_20_0= ruleSBoolean ) )
            // InternalTrustDSL.g:687:4: (lv_epistemicCumulativeBF_20_0= ruleSBoolean )
            {
            // InternalTrustDSL.g:687:4: (lv_epistemicCumulativeBF_20_0= ruleSBoolean )
            // InternalTrustDSL.g:688:5: lv_epistemicCumulativeBF_20_0= ruleSBoolean
            {

            					newCompositeNode(grammarAccess.getUncertainElementFusionAccess().getEpistemicCumulativeBFSBooleanParserRuleCall_19_0());
            				
            pushFollow(FOLLOW_19);
            lv_epistemicCumulativeBF_20_0=ruleSBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUncertainElementFusionRule());
            					}
            					set(
            						current,
            						"epistemicCumulativeBF",
            						lv_epistemicCumulativeBF_20_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.SBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_21=(Token)match(input,26,FOLLOW_15); 

            			newLeafNode(otherlv_21, grammarAccess.getUncertainElementFusionAccess().getWeightedBFKeyword_20());
            		
            otherlv_22=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_22, grammarAccess.getUncertainElementFusionAccess().getEqualsSignKeyword_21());
            		
            // InternalTrustDSL.g:713:3: ( (lv_weightedBF_23_0= ruleSBoolean ) )
            // InternalTrustDSL.g:714:4: (lv_weightedBF_23_0= ruleSBoolean )
            {
            // InternalTrustDSL.g:714:4: (lv_weightedBF_23_0= ruleSBoolean )
            // InternalTrustDSL.g:715:5: lv_weightedBF_23_0= ruleSBoolean
            {

            					newCompositeNode(grammarAccess.getUncertainElementFusionAccess().getWeightedBFSBooleanParserRuleCall_22_0());
            				
            pushFollow(FOLLOW_9);
            lv_weightedBF_23_0=ruleSBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUncertainElementFusionRule());
            					}
            					set(
            						current,
            						"weightedBF",
            						lv_weightedBF_23_0,
            						"org.xtext.geodes.trustdsl.TrustDSL.SBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_24=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_24, grammarAccess.getUncertainElementFusionAccess().getRightCurlyBracketKeyword_23());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUncertainElementFusion"


    // $ANTLR start "entryRuleREAL"
    // InternalTrustDSL.g:740:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // InternalTrustDSL.g:740:44: (iv_ruleREAL= ruleREAL EOF )
            // InternalTrustDSL.g:741:2: iv_ruleREAL= ruleREAL EOF
            {
             newCompositeNode(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleREAL=ruleREAL();

            state._fsp--;

             current =iv_ruleREAL.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleREAL"


    // $ANTLR start "ruleREAL"
    // InternalTrustDSL.g:747:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalTrustDSL.g:753:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalTrustDSL.g:754:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalTrustDSL.g:754:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalTrustDSL.g:755:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,27,FOLLOW_13); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getREALAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleREAL"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000121802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000139800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});

}