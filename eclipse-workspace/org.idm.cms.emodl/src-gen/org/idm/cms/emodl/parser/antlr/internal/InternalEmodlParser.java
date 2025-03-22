package org.idm.cms.emodl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.idm.cms.emodl.services.EmodlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEmodlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_INLINE_COMMENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "'import'", "')'", "'(start-model'", "'(end-model)'", "'(species'", "'(param'", "'(func'", "'(observe'", "'(reaction'", "'(state-event'", "'(time-event'", "'(locale'", "'(set-locale'", "'(json'", "'+'", "'-'", "'*'", "'/'", "'^'", "'min'", "'max'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_INLINE_COMMENT=8;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_NUMBER=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalEmodlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEmodlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEmodlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEmodl.g"; }



     	private EmodlGrammarAccess grammarAccess;

        public InternalEmodlParser(TokenStream input, EmodlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "EModel";
       	}

       	@Override
       	protected EmodlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleEModel"
    // InternalEmodl.g:64:1: entryRuleEModel returns [EObject current=null] : iv_ruleEModel= ruleEModel EOF ;
    public final EObject entryRuleEModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEModel = null;


        try {
            // InternalEmodl.g:64:47: (iv_ruleEModel= ruleEModel EOF )
            // InternalEmodl.g:65:2: iv_ruleEModel= ruleEModel EOF
            {
             newCompositeNode(grammarAccess.getEModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEModel=ruleEModel();

            state._fsp--;

             current =iv_ruleEModel; 
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
    // $ANTLR end "entryRuleEModel"


    // $ANTLR start "ruleEModel"
    // InternalEmodl.g:71:1: ruleEModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_startModel_1_0= ruleStartModel ) ) ( (lv_elements_2_0= ruleElement ) )* ( (lv_endModel_3_0= ruleEndModel ) ) ) ;
    public final EObject ruleEModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_startModel_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_endModel_3_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:77:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_startModel_1_0= ruleStartModel ) ) ( (lv_elements_2_0= ruleElement ) )* ( (lv_endModel_3_0= ruleEndModel ) ) ) )
            // InternalEmodl.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_startModel_1_0= ruleStartModel ) ) ( (lv_elements_2_0= ruleElement ) )* ( (lv_endModel_3_0= ruleEndModel ) ) )
            {
            // InternalEmodl.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_startModel_1_0= ruleStartModel ) ) ( (lv_elements_2_0= ruleElement ) )* ( (lv_endModel_3_0= ruleEndModel ) ) )
            // InternalEmodl.g:79:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_startModel_1_0= ruleStartModel ) ) ( (lv_elements_2_0= ruleElement ) )* ( (lv_endModel_3_0= ruleEndModel ) )
            {
            // InternalEmodl.g:79:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEmodl.g:80:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalEmodl.g:80:4: (lv_imports_0_0= ruleImport )
            	    // InternalEmodl.g:81:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getEModelAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.idm.cms.emodl.Emodl.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalEmodl.g:98:3: ( (lv_startModel_1_0= ruleStartModel ) )
            // InternalEmodl.g:99:4: (lv_startModel_1_0= ruleStartModel )
            {
            // InternalEmodl.g:99:4: (lv_startModel_1_0= ruleStartModel )
            // InternalEmodl.g:100:5: lv_startModel_1_0= ruleStartModel
            {

            					newCompositeNode(grammarAccess.getEModelAccess().getStartModelStartModelParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_startModel_1_0=ruleStartModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEModelRule());
            					}
            					set(
            						current,
            						"startModel",
            						lv_startModel_1_0,
            						"org.idm.cms.emodl.Emodl.StartModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEmodl.g:117:3: ( (lv_elements_2_0= ruleElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=18 && LA2_0<=27)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalEmodl.g:118:4: (lv_elements_2_0= ruleElement )
            	    {
            	    // InternalEmodl.g:118:4: (lv_elements_2_0= ruleElement )
            	    // InternalEmodl.g:119:5: lv_elements_2_0= ruleElement
            	    {

            	    					newCompositeNode(grammarAccess.getEModelAccess().getElementsElementParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_elements_2_0=ruleElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_2_0,
            	    						"org.idm.cms.emodl.Emodl.Element");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalEmodl.g:136:3: ( (lv_endModel_3_0= ruleEndModel ) )
            // InternalEmodl.g:137:4: (lv_endModel_3_0= ruleEndModel )
            {
            // InternalEmodl.g:137:4: (lv_endModel_3_0= ruleEndModel )
            // InternalEmodl.g:138:5: lv_endModel_3_0= ruleEndModel
            {

            					newCompositeNode(grammarAccess.getEModelAccess().getEndModelEndModelParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_endModel_3_0=ruleEndModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEModelRule());
            					}
            					set(
            						current,
            						"endModel",
            						lv_endModel_3_0,
            						"org.idm.cms.emodl.Emodl.EndModel");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleEModel"


    // $ANTLR start "entryRuleImport"
    // InternalEmodl.g:159:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalEmodl.g:159:47: (iv_ruleImport= ruleImport EOF )
            // InternalEmodl.g:160:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalEmodl.g:166:1: ruleImport returns [EObject current=null] : ( () otherlv_1= '(' otherlv_2= 'import' ( (lv_groups_3_0= ruleImportGroup ) )+ otherlv_4= ')' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_groups_3_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:172:2: ( ( () otherlv_1= '(' otherlv_2= 'import' ( (lv_groups_3_0= ruleImportGroup ) )+ otherlv_4= ')' ) )
            // InternalEmodl.g:173:2: ( () otherlv_1= '(' otherlv_2= 'import' ( (lv_groups_3_0= ruleImportGroup ) )+ otherlv_4= ')' )
            {
            // InternalEmodl.g:173:2: ( () otherlv_1= '(' otherlv_2= 'import' ( (lv_groups_3_0= ruleImportGroup ) )+ otherlv_4= ')' )
            // InternalEmodl.g:174:3: () otherlv_1= '(' otherlv_2= 'import' ( (lv_groups_3_0= ruleImportGroup ) )+ otherlv_4= ')'
            {
            // InternalEmodl.g:174:3: ()
            // InternalEmodl.g:175:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getImportAccess().getImportAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getImportAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getImportKeyword_2());
            		
            // InternalEmodl.g:189:3: ( (lv_groups_3_0= ruleImportGroup ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalEmodl.g:190:4: (lv_groups_3_0= ruleImportGroup )
            	    {
            	    // InternalEmodl.g:190:4: (lv_groups_3_0= ruleImportGroup )
            	    // InternalEmodl.g:191:5: lv_groups_3_0= ruleImportGroup
            	    {

            	    					newCompositeNode(grammarAccess.getImportAccess().getGroupsImportGroupParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_groups_3_0=ruleImportGroup();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getImportRule());
            	    					}
            	    					add(
            	    						current,
            	    						"groups",
            	    						lv_groups_3_0,
            	    						"org.idm.cms.emodl.Emodl.ImportGroup");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportGroup"
    // InternalEmodl.g:216:1: entryRuleImportGroup returns [EObject current=null] : iv_ruleImportGroup= ruleImportGroup EOF ;
    public final EObject entryRuleImportGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportGroup = null;


        try {
            // InternalEmodl.g:216:52: (iv_ruleImportGroup= ruleImportGroup EOF )
            // InternalEmodl.g:217:2: iv_ruleImportGroup= ruleImportGroup EOF
            {
             newCompositeNode(grammarAccess.getImportGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportGroup=ruleImportGroup();

            state._fsp--;

             current =iv_ruleImportGroup; 
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
    // $ANTLR end "entryRuleImportGroup"


    // $ANTLR start "ruleImportGroup"
    // InternalEmodl.g:223:1: ruleImportGroup returns [EObject current=null] : (otherlv_0= '(' ( (lv_imports_1_0= RULE_ID ) )+ otherlv_2= ')' ) ;
    public final EObject ruleImportGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_imports_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalEmodl.g:229:2: ( (otherlv_0= '(' ( (lv_imports_1_0= RULE_ID ) )+ otherlv_2= ')' ) )
            // InternalEmodl.g:230:2: (otherlv_0= '(' ( (lv_imports_1_0= RULE_ID ) )+ otherlv_2= ')' )
            {
            // InternalEmodl.g:230:2: (otherlv_0= '(' ( (lv_imports_1_0= RULE_ID ) )+ otherlv_2= ')' )
            // InternalEmodl.g:231:3: otherlv_0= '(' ( (lv_imports_1_0= RULE_ID ) )+ otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getImportGroupAccess().getLeftParenthesisKeyword_0());
            		
            // InternalEmodl.g:235:3: ( (lv_imports_1_0= RULE_ID ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalEmodl.g:236:4: (lv_imports_1_0= RULE_ID )
            	    {
            	    // InternalEmodl.g:236:4: (lv_imports_1_0= RULE_ID )
            	    // InternalEmodl.g:237:5: lv_imports_1_0= RULE_ID
            	    {
            	    lv_imports_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(lv_imports_1_0, grammarAccess.getImportGroupAccess().getImportsIDTerminalRuleCall_1_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getImportGroupRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"imports",
            	    						lv_imports_1_0,
            	    						"org.eclipse.xtext.common.Terminals.ID");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_2=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getImportGroupAccess().getRightParenthesisKeyword_2());
            		

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
    // $ANTLR end "ruleImportGroup"


    // $ANTLR start "entryRuleStartModel"
    // InternalEmodl.g:261:1: entryRuleStartModel returns [EObject current=null] : iv_ruleStartModel= ruleStartModel EOF ;
    public final EObject entryRuleStartModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartModel = null;


        try {
            // InternalEmodl.g:261:51: (iv_ruleStartModel= ruleStartModel EOF )
            // InternalEmodl.g:262:2: iv_ruleStartModel= ruleStartModel EOF
            {
             newCompositeNode(grammarAccess.getStartModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartModel=ruleStartModel();

            state._fsp--;

             current =iv_ruleStartModel; 
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
    // $ANTLR end "entryRuleStartModel"


    // $ANTLR start "ruleStartModel"
    // InternalEmodl.g:268:1: ruleStartModel returns [EObject current=null] : (otherlv_0= '(start-model' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= ')' ) ;
    public final EObject ruleStartModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalEmodl.g:274:2: ( (otherlv_0= '(start-model' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= ')' ) )
            // InternalEmodl.g:275:2: (otherlv_0= '(start-model' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= ')' )
            {
            // InternalEmodl.g:275:2: (otherlv_0= '(start-model' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= ')' )
            // InternalEmodl.g:276:3: otherlv_0= '(start-model' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getStartModelAccess().getStartModelKeyword_0());
            		
            // InternalEmodl.g:280:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalEmodl.g:281:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalEmodl.g:281:4: (lv_name_1_0= RULE_STRING )
            // InternalEmodl.g:282:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStartModelAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStartModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getStartModelAccess().getRightParenthesisKeyword_2());
            		

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
    // $ANTLR end "ruleStartModel"


    // $ANTLR start "entryRuleEndModel"
    // InternalEmodl.g:306:1: entryRuleEndModel returns [EObject current=null] : iv_ruleEndModel= ruleEndModel EOF ;
    public final EObject entryRuleEndModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndModel = null;


        try {
            // InternalEmodl.g:306:49: (iv_ruleEndModel= ruleEndModel EOF )
            // InternalEmodl.g:307:2: iv_ruleEndModel= ruleEndModel EOF
            {
             newCompositeNode(grammarAccess.getEndModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndModel=ruleEndModel();

            state._fsp--;

             current =iv_ruleEndModel; 
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
    // $ANTLR end "entryRuleEndModel"


    // $ANTLR start "ruleEndModel"
    // InternalEmodl.g:313:1: ruleEndModel returns [EObject current=null] : ( () otherlv_1= '(end-model)' ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleEndModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalEmodl.g:319:2: ( ( () otherlv_1= '(end-model)' ( (lv_name_2_0= RULE_ID ) )? ) )
            // InternalEmodl.g:320:2: ( () otherlv_1= '(end-model)' ( (lv_name_2_0= RULE_ID ) )? )
            {
            // InternalEmodl.g:320:2: ( () otherlv_1= '(end-model)' ( (lv_name_2_0= RULE_ID ) )? )
            // InternalEmodl.g:321:3: () otherlv_1= '(end-model)' ( (lv_name_2_0= RULE_ID ) )?
            {
            // InternalEmodl.g:321:3: ()
            // InternalEmodl.g:322:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEndModelAccess().getEndModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getEndModelAccess().getEndModelKeyword_1());
            		
            // InternalEmodl.g:332:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalEmodl.g:333:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalEmodl.g:333:4: (lv_name_2_0= RULE_ID )
                    // InternalEmodl.g:334:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getEndModelAccess().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEndModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleEndModel"


    // $ANTLR start "entryRuleElement"
    // InternalEmodl.g:354:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_INLINE_COMMENT", "RULE_WS");

        try {
            // InternalEmodl.g:356:2: (iv_ruleElement= ruleElement EOF )
            // InternalEmodl.g:357:2: iv_ruleElement= ruleElement EOF
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalEmodl.g:366:1: ruleElement returns [EObject current=null] : (this_Species_0= ruleSpecies | this_Parameter_1= ruleParameter | this_Function_2= ruleFunction | this_Observable_3= ruleObservable | this_Reaction_4= ruleReaction | this_StateEvent_5= ruleStateEvent | this_TimeEvent_6= ruleTimeEvent | this_Locale_7= ruleLocale | this_SetLocale_8= ruleSetLocale | this_Json_9= ruleJson ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Species_0 = null;

        EObject this_Parameter_1 = null;

        EObject this_Function_2 = null;

        EObject this_Observable_3 = null;

        EObject this_Reaction_4 = null;

        EObject this_StateEvent_5 = null;

        EObject this_TimeEvent_6 = null;

        EObject this_Locale_7 = null;

        EObject this_SetLocale_8 = null;

        EObject this_Json_9 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_INLINE_COMMENT", "RULE_WS");

        try {
            // InternalEmodl.g:373:2: ( (this_Species_0= ruleSpecies | this_Parameter_1= ruleParameter | this_Function_2= ruleFunction | this_Observable_3= ruleObservable | this_Reaction_4= ruleReaction | this_StateEvent_5= ruleStateEvent | this_TimeEvent_6= ruleTimeEvent | this_Locale_7= ruleLocale | this_SetLocale_8= ruleSetLocale | this_Json_9= ruleJson ) )
            // InternalEmodl.g:374:2: (this_Species_0= ruleSpecies | this_Parameter_1= ruleParameter | this_Function_2= ruleFunction | this_Observable_3= ruleObservable | this_Reaction_4= ruleReaction | this_StateEvent_5= ruleStateEvent | this_TimeEvent_6= ruleTimeEvent | this_Locale_7= ruleLocale | this_SetLocale_8= ruleSetLocale | this_Json_9= ruleJson )
            {
            // InternalEmodl.g:374:2: (this_Species_0= ruleSpecies | this_Parameter_1= ruleParameter | this_Function_2= ruleFunction | this_Observable_3= ruleObservable | this_Reaction_4= ruleReaction | this_StateEvent_5= ruleStateEvent | this_TimeEvent_6= ruleTimeEvent | this_Locale_7= ruleLocale | this_SetLocale_8= ruleSetLocale | this_Json_9= ruleJson )
            int alt6=10;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt6=1;
                }
                break;
            case 19:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=3;
                }
                break;
            case 21:
                {
                alt6=4;
                }
                break;
            case 22:
                {
                alt6=5;
                }
                break;
            case 23:
                {
                alt6=6;
                }
                break;
            case 24:
                {
                alt6=7;
                }
                break;
            case 25:
                {
                alt6=8;
                }
                break;
            case 26:
                {
                alt6=9;
                }
                break;
            case 27:
                {
                alt6=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalEmodl.g:375:3: this_Species_0= ruleSpecies
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getSpeciesParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Species_0=ruleSpecies();

                    state._fsp--;


                    			current = this_Species_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalEmodl.g:384:3: this_Parameter_1= ruleParameter
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getParameterParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Parameter_1=ruleParameter();

                    state._fsp--;


                    			current = this_Parameter_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalEmodl.g:393:3: this_Function_2= ruleFunction
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getFunctionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Function_2=ruleFunction();

                    state._fsp--;


                    			current = this_Function_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalEmodl.g:402:3: this_Observable_3= ruleObservable
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getObservableParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Observable_3=ruleObservable();

                    state._fsp--;


                    			current = this_Observable_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalEmodl.g:411:3: this_Reaction_4= ruleReaction
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getReactionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Reaction_4=ruleReaction();

                    state._fsp--;


                    			current = this_Reaction_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalEmodl.g:420:3: this_StateEvent_5= ruleStateEvent
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getStateEventParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_StateEvent_5=ruleStateEvent();

                    state._fsp--;


                    			current = this_StateEvent_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalEmodl.g:429:3: this_TimeEvent_6= ruleTimeEvent
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getTimeEventParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeEvent_6=ruleTimeEvent();

                    state._fsp--;


                    			current = this_TimeEvent_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalEmodl.g:438:3: this_Locale_7= ruleLocale
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getLocaleParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Locale_7=ruleLocale();

                    state._fsp--;


                    			current = this_Locale_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalEmodl.g:447:3: this_SetLocale_8= ruleSetLocale
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getSetLocaleParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetLocale_8=ruleSetLocale();

                    state._fsp--;


                    			current = this_SetLocale_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalEmodl.g:456:3: this_Json_9= ruleJson
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getJsonParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_Json_9=ruleJson();

                    state._fsp--;


                    			current = this_Json_9;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleSpecies"
    // InternalEmodl.g:471:1: entryRuleSpecies returns [EObject current=null] : iv_ruleSpecies= ruleSpecies EOF ;
    public final EObject entryRuleSpecies() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecies = null;


        try {
            // InternalEmodl.g:471:48: (iv_ruleSpecies= ruleSpecies EOF )
            // InternalEmodl.g:472:2: iv_ruleSpecies= ruleSpecies EOF
            {
             newCompositeNode(grammarAccess.getSpeciesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecies=ruleSpecies();

            state._fsp--;

             current =iv_ruleSpecies; 
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
    // $ANTLR end "entryRuleSpecies"


    // $ANTLR start "ruleSpecies"
    // InternalEmodl.g:478:1: ruleSpecies returns [EObject current=null] : (otherlv_0= '(species' ( (lv_name_1_0= RULE_ID ) ) ( (lv_initialPopulation_2_0= RULE_NUMBER ) ) otherlv_3= ')' ) ;
    public final EObject ruleSpecies() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_initialPopulation_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalEmodl.g:484:2: ( (otherlv_0= '(species' ( (lv_name_1_0= RULE_ID ) ) ( (lv_initialPopulation_2_0= RULE_NUMBER ) ) otherlv_3= ')' ) )
            // InternalEmodl.g:485:2: (otherlv_0= '(species' ( (lv_name_1_0= RULE_ID ) ) ( (lv_initialPopulation_2_0= RULE_NUMBER ) ) otherlv_3= ')' )
            {
            // InternalEmodl.g:485:2: (otherlv_0= '(species' ( (lv_name_1_0= RULE_ID ) ) ( (lv_initialPopulation_2_0= RULE_NUMBER ) ) otherlv_3= ')' )
            // InternalEmodl.g:486:3: otherlv_0= '(species' ( (lv_name_1_0= RULE_ID ) ) ( (lv_initialPopulation_2_0= RULE_NUMBER ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getSpeciesAccess().getSpeciesKeyword_0());
            		
            // InternalEmodl.g:490:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:491:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:491:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:492:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSpeciesAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpeciesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:508:3: ( (lv_initialPopulation_2_0= RULE_NUMBER ) )
            // InternalEmodl.g:509:4: (lv_initialPopulation_2_0= RULE_NUMBER )
            {
            // InternalEmodl.g:509:4: (lv_initialPopulation_2_0= RULE_NUMBER )
            // InternalEmodl.g:510:5: lv_initialPopulation_2_0= RULE_NUMBER
            {
            lv_initialPopulation_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_11); 

            					newLeafNode(lv_initialPopulation_2_0, grammarAccess.getSpeciesAccess().getInitialPopulationNUMBERTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpeciesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"initialPopulation",
            						lv_initialPopulation_2_0,
            						"org.idm.cms.emodl.Emodl.NUMBER");
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSpeciesAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleSpecies"


    // $ANTLR start "entryRuleParameter"
    // InternalEmodl.g:534:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalEmodl.g:534:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalEmodl.g:535:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalEmodl.g:541:1: ruleParameter returns [EObject current=null] : (otherlv_0= '(param' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_NUMBER ) ) otherlv_3= ')' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalEmodl.g:547:2: ( (otherlv_0= '(param' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_NUMBER ) ) otherlv_3= ')' ) )
            // InternalEmodl.g:548:2: (otherlv_0= '(param' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_NUMBER ) ) otherlv_3= ')' )
            {
            // InternalEmodl.g:548:2: (otherlv_0= '(param' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_NUMBER ) ) otherlv_3= ')' )
            // InternalEmodl.g:549:3: otherlv_0= '(param' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_NUMBER ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterAccess().getParamKeyword_0());
            		
            // InternalEmodl.g:553:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:554:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:554:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:555:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:571:3: ( (lv_value_2_0= RULE_NUMBER ) )
            // InternalEmodl.g:572:4: (lv_value_2_0= RULE_NUMBER )
            {
            // InternalEmodl.g:572:4: (lv_value_2_0= RULE_NUMBER )
            // InternalEmodl.g:573:5: lv_value_2_0= RULE_NUMBER
            {
            lv_value_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_11); 

            					newLeafNode(lv_value_2_0, grammarAccess.getParameterAccess().getValueNUMBERTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.idm.cms.emodl.Emodl.NUMBER");
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleFunction"
    // InternalEmodl.g:597:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalEmodl.g:597:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalEmodl.g:598:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalEmodl.g:604:1: ruleFunction returns [EObject current=null] : (otherlv_0= '(func' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:610:2: ( (otherlv_0= '(func' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalEmodl.g:611:2: (otherlv_0= '(func' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalEmodl.g:611:2: (otherlv_0= '(func' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalEmodl.g:612:3: otherlv_0= '(func' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getFuncKeyword_0());
            		
            // InternalEmodl.g:616:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:617:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:617:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:618:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:634:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalEmodl.g:635:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalEmodl.g:635:4: (lv_expression_2_0= ruleExpression )
            // InternalEmodl.g:636:5: lv_expression_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getFunctionAccess().getExpressionExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_expression_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"org.idm.cms.emodl.Emodl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleObservable"
    // InternalEmodl.g:661:1: entryRuleObservable returns [EObject current=null] : iv_ruleObservable= ruleObservable EOF ;
    public final EObject entryRuleObservable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObservable = null;


        try {
            // InternalEmodl.g:661:51: (iv_ruleObservable= ruleObservable EOF )
            // InternalEmodl.g:662:2: iv_ruleObservable= ruleObservable EOF
            {
             newCompositeNode(grammarAccess.getObservableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObservable=ruleObservable();

            state._fsp--;

             current =iv_ruleObservable; 
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
    // $ANTLR end "entryRuleObservable"


    // $ANTLR start "ruleObservable"
    // InternalEmodl.g:668:1: ruleObservable returns [EObject current=null] : (otherlv_0= '(observe' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleObservable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:674:2: ( (otherlv_0= '(observe' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalEmodl.g:675:2: (otherlv_0= '(observe' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalEmodl.g:675:2: (otherlv_0= '(observe' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalEmodl.g:676:3: otherlv_0= '(observe' ( (lv_name_1_0= RULE_ID ) ) ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getObservableAccess().getObserveKeyword_0());
            		
            // InternalEmodl.g:680:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:681:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:681:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:682:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getObservableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObservableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:698:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalEmodl.g:699:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalEmodl.g:699:4: (lv_expression_2_0= ruleExpression )
            // InternalEmodl.g:700:5: lv_expression_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getObservableAccess().getExpressionExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_expression_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObservableRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"org.idm.cms.emodl.Emodl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getObservableAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleObservable"


    // $ANTLR start "entryRuleReaction"
    // InternalEmodl.g:725:1: entryRuleReaction returns [EObject current=null] : iv_ruleReaction= ruleReaction EOF ;
    public final EObject entryRuleReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReaction = null;


        try {
            // InternalEmodl.g:725:49: (iv_ruleReaction= ruleReaction EOF )
            // InternalEmodl.g:726:2: iv_ruleReaction= ruleReaction EOF
            {
             newCompositeNode(grammarAccess.getReactionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReaction=ruleReaction();

            state._fsp--;

             current =iv_ruleReaction; 
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
    // $ANTLR end "entryRuleReaction"


    // $ANTLR start "ruleReaction"
    // InternalEmodl.g:732:1: ruleReaction returns [EObject current=null] : (otherlv_0= '(reaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' otherlv_5= '(' ( (otherlv_6= RULE_ID ) )* otherlv_7= ')' ( (lv_propensityFunction_8_0= ruleExpression ) ) otherlv_9= ')' ) ;
    public final EObject ruleReaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_propensityFunction_8_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:738:2: ( (otherlv_0= '(reaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' otherlv_5= '(' ( (otherlv_6= RULE_ID ) )* otherlv_7= ')' ( (lv_propensityFunction_8_0= ruleExpression ) ) otherlv_9= ')' ) )
            // InternalEmodl.g:739:2: (otherlv_0= '(reaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' otherlv_5= '(' ( (otherlv_6= RULE_ID ) )* otherlv_7= ')' ( (lv_propensityFunction_8_0= ruleExpression ) ) otherlv_9= ')' )
            {
            // InternalEmodl.g:739:2: (otherlv_0= '(reaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' otherlv_5= '(' ( (otherlv_6= RULE_ID ) )* otherlv_7= ')' ( (lv_propensityFunction_8_0= ruleExpression ) ) otherlv_9= ')' )
            // InternalEmodl.g:740:3: otherlv_0= '(reaction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' otherlv_5= '(' ( (otherlv_6= RULE_ID ) )* otherlv_7= ')' ( (lv_propensityFunction_8_0= ruleExpression ) ) otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getReactionAccess().getReactionKeyword_0());
            		
            // InternalEmodl.g:744:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:745:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:745:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:746:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getReactionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReactionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getReactionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalEmodl.g:766:3: ( (otherlv_3= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalEmodl.g:767:4: (otherlv_3= RULE_ID )
            	    {
            	    // InternalEmodl.g:767:4: (otherlv_3= RULE_ID )
            	    // InternalEmodl.g:768:5: otherlv_3= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getReactionRule());
            	    					}
            	    				
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_3, grammarAccess.getReactionAccess().getInputSpeciesSpeciesCrossReference_3_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getReactionAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,13,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getReactionAccess().getLeftParenthesisKeyword_5());
            		
            // InternalEmodl.g:787:3: ( (otherlv_6= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalEmodl.g:788:4: (otherlv_6= RULE_ID )
            	    {
            	    // InternalEmodl.g:788:4: (otherlv_6= RULE_ID )
            	    // InternalEmodl.g:789:5: otherlv_6= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getReactionRule());
            	    					}
            	    				
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    					newLeafNode(otherlv_6, grammarAccess.getReactionAccess().getOutputSpeciesSpeciesCrossReference_6_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getReactionAccess().getRightParenthesisKeyword_7());
            		
            // InternalEmodl.g:804:3: ( (lv_propensityFunction_8_0= ruleExpression ) )
            // InternalEmodl.g:805:4: (lv_propensityFunction_8_0= ruleExpression )
            {
            // InternalEmodl.g:805:4: (lv_propensityFunction_8_0= ruleExpression )
            // InternalEmodl.g:806:5: lv_propensityFunction_8_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getReactionAccess().getPropensityFunctionExpressionParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_11);
            lv_propensityFunction_8_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReactionRule());
            					}
            					set(
            						current,
            						"propensityFunction",
            						lv_propensityFunction_8_0,
            						"org.idm.cms.emodl.Emodl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getReactionAccess().getRightParenthesisKeyword_9());
            		

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
    // $ANTLR end "ruleReaction"


    // $ANTLR start "entryRuleStateEvent"
    // InternalEmodl.g:831:1: entryRuleStateEvent returns [EObject current=null] : iv_ruleStateEvent= ruleStateEvent EOF ;
    public final EObject entryRuleStateEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateEvent = null;


        try {
            // InternalEmodl.g:831:51: (iv_ruleStateEvent= ruleStateEvent EOF )
            // InternalEmodl.g:832:2: iv_ruleStateEvent= ruleStateEvent EOF
            {
             newCompositeNode(grammarAccess.getStateEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateEvent=ruleStateEvent();

            state._fsp--;

             current =iv_ruleStateEvent; 
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
    // $ANTLR end "entryRuleStateEvent"


    // $ANTLR start "ruleStateEvent"
    // InternalEmodl.g:838:1: ruleStateEvent returns [EObject current=null] : (otherlv_0= '(state-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_predicate_2_0= ruleExpression ) ) ( (lv_variableValuePairs_3_0= ruleVariableValuePairs ) ) otherlv_4= ')' ) ;
    public final EObject ruleStateEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        EObject lv_predicate_2_0 = null;

        EObject lv_variableValuePairs_3_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:844:2: ( (otherlv_0= '(state-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_predicate_2_0= ruleExpression ) ) ( (lv_variableValuePairs_3_0= ruleVariableValuePairs ) ) otherlv_4= ')' ) )
            // InternalEmodl.g:845:2: (otherlv_0= '(state-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_predicate_2_0= ruleExpression ) ) ( (lv_variableValuePairs_3_0= ruleVariableValuePairs ) ) otherlv_4= ')' )
            {
            // InternalEmodl.g:845:2: (otherlv_0= '(state-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_predicate_2_0= ruleExpression ) ) ( (lv_variableValuePairs_3_0= ruleVariableValuePairs ) ) otherlv_4= ')' )
            // InternalEmodl.g:846:3: otherlv_0= '(state-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_predicate_2_0= ruleExpression ) ) ( (lv_variableValuePairs_3_0= ruleVariableValuePairs ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getStateEventAccess().getStateEventKeyword_0());
            		
            // InternalEmodl.g:850:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:851:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:851:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:852:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStateEventAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:868:3: ( (lv_predicate_2_0= ruleExpression ) )
            // InternalEmodl.g:869:4: (lv_predicate_2_0= ruleExpression )
            {
            // InternalEmodl.g:869:4: (lv_predicate_2_0= ruleExpression )
            // InternalEmodl.g:870:5: lv_predicate_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getStateEventAccess().getPredicateExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_predicate_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateEventRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_2_0,
            						"org.idm.cms.emodl.Emodl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEmodl.g:887:3: ( (lv_variableValuePairs_3_0= ruleVariableValuePairs ) )
            // InternalEmodl.g:888:4: (lv_variableValuePairs_3_0= ruleVariableValuePairs )
            {
            // InternalEmodl.g:888:4: (lv_variableValuePairs_3_0= ruleVariableValuePairs )
            // InternalEmodl.g:889:5: lv_variableValuePairs_3_0= ruleVariableValuePairs
            {

            					newCompositeNode(grammarAccess.getStateEventAccess().getVariableValuePairsVariableValuePairsParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_variableValuePairs_3_0=ruleVariableValuePairs();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateEventRule());
            					}
            					set(
            						current,
            						"variableValuePairs",
            						lv_variableValuePairs_3_0,
            						"org.idm.cms.emodl.Emodl.VariableValuePairs");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getStateEventAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleStateEvent"


    // $ANTLR start "entryRuleTimeEvent"
    // InternalEmodl.g:914:1: entryRuleTimeEvent returns [EObject current=null] : iv_ruleTimeEvent= ruleTimeEvent EOF ;
    public final EObject entryRuleTimeEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEvent = null;


        try {
            // InternalEmodl.g:914:50: (iv_ruleTimeEvent= ruleTimeEvent EOF )
            // InternalEmodl.g:915:2: iv_ruleTimeEvent= ruleTimeEvent EOF
            {
             newCompositeNode(grammarAccess.getTimeEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeEvent=ruleTimeEvent();

            state._fsp--;

             current =iv_ruleTimeEvent; 
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
    // $ANTLR end "entryRuleTimeEvent"


    // $ANTLR start "ruleTimeEvent"
    // InternalEmodl.g:921:1: ruleTimeEvent returns [EObject current=null] : (otherlv_0= '(time-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_time_2_0= RULE_NUMBER ) ) ( (lv_iterations_3_0= RULE_INT ) )? ( (lv_variableValuePairs_4_0= ruleVariableValuePairs ) ) otherlv_5= ')' ) ;
    public final EObject ruleTimeEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_time_2_0=null;
        Token lv_iterations_3_0=null;
        Token otherlv_5=null;
        EObject lv_variableValuePairs_4_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:927:2: ( (otherlv_0= '(time-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_time_2_0= RULE_NUMBER ) ) ( (lv_iterations_3_0= RULE_INT ) )? ( (lv_variableValuePairs_4_0= ruleVariableValuePairs ) ) otherlv_5= ')' ) )
            // InternalEmodl.g:928:2: (otherlv_0= '(time-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_time_2_0= RULE_NUMBER ) ) ( (lv_iterations_3_0= RULE_INT ) )? ( (lv_variableValuePairs_4_0= ruleVariableValuePairs ) ) otherlv_5= ')' )
            {
            // InternalEmodl.g:928:2: (otherlv_0= '(time-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_time_2_0= RULE_NUMBER ) ) ( (lv_iterations_3_0= RULE_INT ) )? ( (lv_variableValuePairs_4_0= ruleVariableValuePairs ) ) otherlv_5= ')' )
            // InternalEmodl.g:929:3: otherlv_0= '(time-event' ( (lv_name_1_0= RULE_ID ) ) ( (lv_time_2_0= RULE_NUMBER ) ) ( (lv_iterations_3_0= RULE_INT ) )? ( (lv_variableValuePairs_4_0= ruleVariableValuePairs ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeEventAccess().getTimeEventKeyword_0());
            		
            // InternalEmodl.g:933:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:934:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:934:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:935:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTimeEventAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:951:3: ( (lv_time_2_0= RULE_NUMBER ) )
            // InternalEmodl.g:952:4: (lv_time_2_0= RULE_NUMBER )
            {
            // InternalEmodl.g:952:4: (lv_time_2_0= RULE_NUMBER )
            // InternalEmodl.g:953:5: lv_time_2_0= RULE_NUMBER
            {
            lv_time_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_15); 

            					newLeafNode(lv_time_2_0, grammarAccess.getTimeEventAccess().getTimeNUMBERTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"time",
            						lv_time_2_0,
            						"org.idm.cms.emodl.Emodl.NUMBER");
            				

            }


            }

            // InternalEmodl.g:969:3: ( (lv_iterations_3_0= RULE_INT ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalEmodl.g:970:4: (lv_iterations_3_0= RULE_INT )
                    {
                    // InternalEmodl.g:970:4: (lv_iterations_3_0= RULE_INT )
                    // InternalEmodl.g:971:5: lv_iterations_3_0= RULE_INT
                    {
                    lv_iterations_3_0=(Token)match(input,RULE_INT,FOLLOW_6); 

                    					newLeafNode(lv_iterations_3_0, grammarAccess.getTimeEventAccess().getIterationsINTTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTimeEventRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"iterations",
                    						lv_iterations_3_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }
                    break;

            }

            // InternalEmodl.g:987:3: ( (lv_variableValuePairs_4_0= ruleVariableValuePairs ) )
            // InternalEmodl.g:988:4: (lv_variableValuePairs_4_0= ruleVariableValuePairs )
            {
            // InternalEmodl.g:988:4: (lv_variableValuePairs_4_0= ruleVariableValuePairs )
            // InternalEmodl.g:989:5: lv_variableValuePairs_4_0= ruleVariableValuePairs
            {

            					newCompositeNode(grammarAccess.getTimeEventAccess().getVariableValuePairsVariableValuePairsParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_11);
            lv_variableValuePairs_4_0=ruleVariableValuePairs();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeEventRule());
            					}
            					set(
            						current,
            						"variableValuePairs",
            						lv_variableValuePairs_4_0,
            						"org.idm.cms.emodl.Emodl.VariableValuePairs");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTimeEventAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleTimeEvent"


    // $ANTLR start "entryRuleLocale"
    // InternalEmodl.g:1014:1: entryRuleLocale returns [EObject current=null] : iv_ruleLocale= ruleLocale EOF ;
    public final EObject entryRuleLocale() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocale = null;


        try {
            // InternalEmodl.g:1014:47: (iv_ruleLocale= ruleLocale EOF )
            // InternalEmodl.g:1015:2: iv_ruleLocale= ruleLocale EOF
            {
             newCompositeNode(grammarAccess.getLocaleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocale=ruleLocale();

            state._fsp--;

             current =iv_ruleLocale; 
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
    // $ANTLR end "entryRuleLocale"


    // $ANTLR start "ruleLocale"
    // InternalEmodl.g:1021:1: ruleLocale returns [EObject current=null] : (otherlv_0= '(locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleLocale() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalEmodl.g:1027:2: ( (otherlv_0= '(locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // InternalEmodl.g:1028:2: (otherlv_0= '(locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // InternalEmodl.g:1028:2: (otherlv_0= '(locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' )
            // InternalEmodl.g:1029:3: otherlv_0= '(locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getLocaleAccess().getLocaleKeyword_0());
            		
            // InternalEmodl.g:1033:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:1034:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:1034:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:1035:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLocaleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocaleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getLocaleAccess().getRightParenthesisKeyword_2());
            		

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
    // $ANTLR end "ruleLocale"


    // $ANTLR start "entryRuleSetLocale"
    // InternalEmodl.g:1059:1: entryRuleSetLocale returns [EObject current=null] : iv_ruleSetLocale= ruleSetLocale EOF ;
    public final EObject entryRuleSetLocale() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetLocale = null;


        try {
            // InternalEmodl.g:1059:50: (iv_ruleSetLocale= ruleSetLocale EOF )
            // InternalEmodl.g:1060:2: iv_ruleSetLocale= ruleSetLocale EOF
            {
             newCompositeNode(grammarAccess.getSetLocaleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetLocale=ruleSetLocale();

            state._fsp--;

             current =iv_ruleSetLocale; 
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
    // $ANTLR end "entryRuleSetLocale"


    // $ANTLR start "ruleSetLocale"
    // InternalEmodl.g:1066:1: ruleSetLocale returns [EObject current=null] : (otherlv_0= '(set-locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleSetLocale() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalEmodl.g:1072:2: ( (otherlv_0= '(set-locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // InternalEmodl.g:1073:2: (otherlv_0= '(set-locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // InternalEmodl.g:1073:2: (otherlv_0= '(set-locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')' )
            // InternalEmodl.g:1074:3: otherlv_0= '(set-locale' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getSetLocaleAccess().getSetLocaleKeyword_0());
            		
            // InternalEmodl.g:1078:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:1079:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:1079:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:1080:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSetLocaleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetLocaleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getSetLocaleAccess().getRightParenthesisKeyword_2());
            		

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
    // $ANTLR end "ruleSetLocale"


    // $ANTLR start "entryRuleJson"
    // InternalEmodl.g:1104:1: entryRuleJson returns [EObject current=null] : iv_ruleJson= ruleJson EOF ;
    public final EObject entryRuleJson() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJson = null;


        try {
            // InternalEmodl.g:1104:45: (iv_ruleJson= ruleJson EOF )
            // InternalEmodl.g:1105:2: iv_ruleJson= ruleJson EOF
            {
             newCompositeNode(grammarAccess.getJsonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJson=ruleJson();

            state._fsp--;

             current =iv_ruleJson; 
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
    // $ANTLR end "entryRuleJson"


    // $ANTLR start "ruleJson"
    // InternalEmodl.g:1111:1: ruleJson returns [EObject current=null] : (otherlv_0= '(json' ( (lv_name_1_0= RULE_ID ) ) ( (lv_file_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final EObject ruleJson() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_file_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalEmodl.g:1117:2: ( (otherlv_0= '(json' ( (lv_name_1_0= RULE_ID ) ) ( (lv_file_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // InternalEmodl.g:1118:2: (otherlv_0= '(json' ( (lv_name_1_0= RULE_ID ) ) ( (lv_file_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // InternalEmodl.g:1118:2: (otherlv_0= '(json' ( (lv_name_1_0= RULE_ID ) ) ( (lv_file_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // InternalEmodl.g:1119:3: otherlv_0= '(json' ( (lv_name_1_0= RULE_ID ) ) ( (lv_file_2_0= RULE_STRING ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getJsonAccess().getJsonKeyword_0());
            		
            // InternalEmodl.g:1123:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEmodl.g:1124:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEmodl.g:1124:4: (lv_name_1_0= RULE_ID )
            // InternalEmodl.g:1125:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJsonAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:1141:3: ( (lv_file_2_0= RULE_STRING ) )
            // InternalEmodl.g:1142:4: (lv_file_2_0= RULE_STRING )
            {
            // InternalEmodl.g:1142:4: (lv_file_2_0= RULE_STRING )
            // InternalEmodl.g:1143:5: lv_file_2_0= RULE_STRING
            {
            lv_file_2_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_file_2_0, grammarAccess.getJsonAccess().getFileSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonRule());
            					}
            					setWithLastConsumed(
            						current,
            						"file",
            						lv_file_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJsonAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJson"


    // $ANTLR start "entryRuleVariableValuePairs"
    // InternalEmodl.g:1167:1: entryRuleVariableValuePairs returns [EObject current=null] : iv_ruleVariableValuePairs= ruleVariableValuePairs EOF ;
    public final EObject entryRuleVariableValuePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableValuePairs = null;


        try {
            // InternalEmodl.g:1167:59: (iv_ruleVariableValuePairs= ruleVariableValuePairs EOF )
            // InternalEmodl.g:1168:2: iv_ruleVariableValuePairs= ruleVariableValuePairs EOF
            {
             newCompositeNode(grammarAccess.getVariableValuePairsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableValuePairs=ruleVariableValuePairs();

            state._fsp--;

             current =iv_ruleVariableValuePairs; 
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
    // $ANTLR end "entryRuleVariableValuePairs"


    // $ANTLR start "ruleVariableValuePairs"
    // InternalEmodl.g:1174:1: ruleVariableValuePairs returns [EObject current=null] : (otherlv_0= '(' ( (lv_variableValuePairs_1_0= ruleVariableValuePair ) )+ otherlv_2= ')' ) ;
    public final EObject ruleVariableValuePairs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_variableValuePairs_1_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:1180:2: ( (otherlv_0= '(' ( (lv_variableValuePairs_1_0= ruleVariableValuePair ) )+ otherlv_2= ')' ) )
            // InternalEmodl.g:1181:2: (otherlv_0= '(' ( (lv_variableValuePairs_1_0= ruleVariableValuePair ) )+ otherlv_2= ')' )
            {
            // InternalEmodl.g:1181:2: (otherlv_0= '(' ( (lv_variableValuePairs_1_0= ruleVariableValuePair ) )+ otherlv_2= ')' )
            // InternalEmodl.g:1182:3: otherlv_0= '(' ( (lv_variableValuePairs_1_0= ruleVariableValuePair ) )+ otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableValuePairsAccess().getLeftParenthesisKeyword_0());
            		
            // InternalEmodl.g:1186:3: ( (lv_variableValuePairs_1_0= ruleVariableValuePair ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==13) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalEmodl.g:1187:4: (lv_variableValuePairs_1_0= ruleVariableValuePair )
            	    {
            	    // InternalEmodl.g:1187:4: (lv_variableValuePairs_1_0= ruleVariableValuePair )
            	    // InternalEmodl.g:1188:5: lv_variableValuePairs_1_0= ruleVariableValuePair
            	    {

            	    					newCompositeNode(grammarAccess.getVariableValuePairsAccess().getVariableValuePairsVariableValuePairParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_variableValuePairs_1_0=ruleVariableValuePair();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getVariableValuePairsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variableValuePairs",
            	    						lv_variableValuePairs_1_0,
            	    						"org.idm.cms.emodl.Emodl.VariableValuePair");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_2=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableValuePairsAccess().getRightParenthesisKeyword_2());
            		

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
    // $ANTLR end "ruleVariableValuePairs"


    // $ANTLR start "entryRuleVariableValuePair"
    // InternalEmodl.g:1213:1: entryRuleVariableValuePair returns [EObject current=null] : iv_ruleVariableValuePair= ruleVariableValuePair EOF ;
    public final EObject entryRuleVariableValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableValuePair = null;


        try {
            // InternalEmodl.g:1213:58: (iv_ruleVariableValuePair= ruleVariableValuePair EOF )
            // InternalEmodl.g:1214:2: iv_ruleVariableValuePair= ruleVariableValuePair EOF
            {
             newCompositeNode(grammarAccess.getVariableValuePairRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableValuePair=ruleVariableValuePair();

            state._fsp--;

             current =iv_ruleVariableValuePair; 
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
    // $ANTLR end "entryRuleVariableValuePair"


    // $ANTLR start "ruleVariableValuePair"
    // InternalEmodl.g:1220:1: ruleVariableValuePair returns [EObject current=null] : (otherlv_0= '(' ( (lv_variable_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleVariableValuePair() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variable_1_0=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:1226:2: ( (otherlv_0= '(' ( (lv_variable_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalEmodl.g:1227:2: (otherlv_0= '(' ( (lv_variable_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalEmodl.g:1227:2: (otherlv_0= '(' ( (lv_variable_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalEmodl.g:1228:3: otherlv_0= '(' ( (lv_variable_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableValuePairAccess().getLeftParenthesisKeyword_0());
            		
            // InternalEmodl.g:1232:3: ( (lv_variable_1_0= RULE_ID ) )
            // InternalEmodl.g:1233:4: (lv_variable_1_0= RULE_ID )
            {
            // InternalEmodl.g:1233:4: (lv_variable_1_0= RULE_ID )
            // InternalEmodl.g:1234:5: lv_variable_1_0= RULE_ID
            {
            lv_variable_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_variable_1_0, grammarAccess.getVariableValuePairAccess().getVariableIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableValuePairRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalEmodl.g:1250:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalEmodl.g:1251:4: (lv_value_2_0= ruleExpression )
            {
            // InternalEmodl.g:1251:4: (lv_value_2_0= ruleExpression )
            // InternalEmodl.g:1252:5: lv_value_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getVariableValuePairAccess().getValueExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableValuePairRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.idm.cms.emodl.Emodl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getVariableValuePairAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleVariableValuePair"


    // $ANTLR start "entryRuleExpression"
    // InternalEmodl.g:1277:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalEmodl.g:1277:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalEmodl.g:1278:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalEmodl.g:1284:1: ruleExpression returns [EObject current=null] : ( ( () ( (lv_expression_1_0= ruleBinaryOperation ) ) ) | (otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ) | ( (lv_name_5_0= ruleLiteral ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_1_0 = null;

        EObject lv_expression_3_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:1290:2: ( ( ( () ( (lv_expression_1_0= ruleBinaryOperation ) ) ) | (otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ) | ( (lv_name_5_0= ruleLiteral ) ) ) )
            // InternalEmodl.g:1291:2: ( ( () ( (lv_expression_1_0= ruleBinaryOperation ) ) ) | (otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ) | ( (lv_name_5_0= ruleLiteral ) ) )
            {
            // InternalEmodl.g:1291:2: ( ( () ( (lv_expression_1_0= ruleBinaryOperation ) ) ) | (otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ) | ( (lv_name_5_0= ruleLiteral ) ) )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                int LA11_1 = input.LA(2);

                if ( ((LA11_1>=28 && LA11_1<=34)) ) {
                    alt11=1;
                }
                else if ( (LA11_1==RULE_ID||LA11_1==RULE_NUMBER||LA11_1==13) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==RULE_ID||LA11_0==RULE_NUMBER) ) {
                alt11=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalEmodl.g:1292:3: ( () ( (lv_expression_1_0= ruleBinaryOperation ) ) )
                    {
                    // InternalEmodl.g:1292:3: ( () ( (lv_expression_1_0= ruleBinaryOperation ) ) )
                    // InternalEmodl.g:1293:4: () ( (lv_expression_1_0= ruleBinaryOperation ) )
                    {
                    // InternalEmodl.g:1293:4: ()
                    // InternalEmodl.g:1294:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getExpressionAccess().getExpressionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalEmodl.g:1300:4: ( (lv_expression_1_0= ruleBinaryOperation ) )
                    // InternalEmodl.g:1301:5: (lv_expression_1_0= ruleBinaryOperation )
                    {
                    // InternalEmodl.g:1301:5: (lv_expression_1_0= ruleBinaryOperation )
                    // InternalEmodl.g:1302:6: lv_expression_1_0= ruleBinaryOperation
                    {

                    						newCompositeNode(grammarAccess.getExpressionAccess().getExpressionBinaryOperationParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_1_0=ruleBinaryOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_1_0,
                    							"org.idm.cms.emodl.Emodl.BinaryOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEmodl.g:1321:3: (otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' )
                    {
                    // InternalEmodl.g:1321:3: (otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' )
                    // InternalEmodl.g:1322:4: otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_14); 

                    				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalEmodl.g:1326:4: ( (lv_expression_3_0= ruleExpression ) )
                    // InternalEmodl.g:1327:5: (lv_expression_3_0= ruleExpression )
                    {
                    // InternalEmodl.g:1327:5: (lv_expression_3_0= ruleExpression )
                    // InternalEmodl.g:1328:6: lv_expression_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getExpressionAccess().getExpressionExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_expression_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_3_0,
                    							"org.idm.cms.emodl.Emodl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getRightParenthesisKeyword_1_2());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalEmodl.g:1351:3: ( (lv_name_5_0= ruleLiteral ) )
                    {
                    // InternalEmodl.g:1351:3: ( (lv_name_5_0= ruleLiteral ) )
                    // InternalEmodl.g:1352:4: (lv_name_5_0= ruleLiteral )
                    {
                    // InternalEmodl.g:1352:4: (lv_name_5_0= ruleLiteral )
                    // InternalEmodl.g:1353:5: lv_name_5_0= ruleLiteral
                    {

                    					newCompositeNode(grammarAccess.getExpressionAccess().getNameLiteralParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_name_5_0=ruleLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionRule());
                    					}
                    					set(
                    						current,
                    						"name",
                    						lv_name_5_0,
                    						"org.idm.cms.emodl.Emodl.Literal");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBinaryOperation"
    // InternalEmodl.g:1374:1: entryRuleBinaryOperation returns [EObject current=null] : iv_ruleBinaryOperation= ruleBinaryOperation EOF ;
    public final EObject entryRuleBinaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperation = null;


        try {
            // InternalEmodl.g:1374:56: (iv_ruleBinaryOperation= ruleBinaryOperation EOF )
            // InternalEmodl.g:1375:2: iv_ruleBinaryOperation= ruleBinaryOperation EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryOperation=ruleBinaryOperation();

            state._fsp--;

             current =iv_ruleBinaryOperation; 
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
    // $ANTLR end "entryRuleBinaryOperation"


    // $ANTLR start "ruleBinaryOperation"
    // InternalEmodl.g:1381:1: ruleBinaryOperation returns [EObject current=null] : (otherlv_0= '(' ( (lv_operator_1_0= ruleBinaryOperator ) ) ( (lv_left_2_0= ruleExpression ) ) ( (lv_right_3_0= ruleExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruleBinaryOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_left_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEmodl.g:1387:2: ( (otherlv_0= '(' ( (lv_operator_1_0= ruleBinaryOperator ) ) ( (lv_left_2_0= ruleExpression ) ) ( (lv_right_3_0= ruleExpression ) ) otherlv_4= ')' ) )
            // InternalEmodl.g:1388:2: (otherlv_0= '(' ( (lv_operator_1_0= ruleBinaryOperator ) ) ( (lv_left_2_0= ruleExpression ) ) ( (lv_right_3_0= ruleExpression ) ) otherlv_4= ')' )
            {
            // InternalEmodl.g:1388:2: (otherlv_0= '(' ( (lv_operator_1_0= ruleBinaryOperator ) ) ( (lv_left_2_0= ruleExpression ) ) ( (lv_right_3_0= ruleExpression ) ) otherlv_4= ')' )
            // InternalEmodl.g:1389:3: otherlv_0= '(' ( (lv_operator_1_0= ruleBinaryOperator ) ) ( (lv_left_2_0= ruleExpression ) ) ( (lv_right_3_0= ruleExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getBinaryOperationAccess().getLeftParenthesisKeyword_0());
            		
            // InternalEmodl.g:1393:3: ( (lv_operator_1_0= ruleBinaryOperator ) )
            // InternalEmodl.g:1394:4: (lv_operator_1_0= ruleBinaryOperator )
            {
            // InternalEmodl.g:1394:4: (lv_operator_1_0= ruleBinaryOperator )
            // InternalEmodl.g:1395:5: lv_operator_1_0= ruleBinaryOperator
            {

            					newCompositeNode(grammarAccess.getBinaryOperationAccess().getOperatorBinaryOperatorParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
            lv_operator_1_0=ruleBinaryOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryOperationRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"org.idm.cms.emodl.Emodl.BinaryOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEmodl.g:1412:3: ( (lv_left_2_0= ruleExpression ) )
            // InternalEmodl.g:1413:4: (lv_left_2_0= ruleExpression )
            {
            // InternalEmodl.g:1413:4: (lv_left_2_0= ruleExpression )
            // InternalEmodl.g:1414:5: lv_left_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBinaryOperationAccess().getLeftExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_left_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryOperationRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.idm.cms.emodl.Emodl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalEmodl.g:1431:3: ( (lv_right_3_0= ruleExpression ) )
            // InternalEmodl.g:1432:4: (lv_right_3_0= ruleExpression )
            {
            // InternalEmodl.g:1432:4: (lv_right_3_0= ruleExpression )
            // InternalEmodl.g:1433:5: lv_right_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBinaryOperationAccess().getRightExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_right_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryOperationRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"org.idm.cms.emodl.Emodl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getBinaryOperationAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleBinaryOperation"


    // $ANTLR start "entryRuleLiteral"
    // InternalEmodl.g:1458:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // InternalEmodl.g:1458:47: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalEmodl.g:1459:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral.getText(); 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalEmodl.g:1465:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_NUMBER_1=null;


        	enterRule();

        try {
            // InternalEmodl.g:1471:2: ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) )
            // InternalEmodl.g:1472:2: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER )
            {
            // InternalEmodl.g:1472:2: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_NUMBER) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalEmodl.g:1473:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getLiteralAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalEmodl.g:1481:3: this_NUMBER_1= RULE_NUMBER
                    {
                    this_NUMBER_1=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

                    			current.merge(this_NUMBER_1);
                    		

                    			newLeafNode(this_NUMBER_1, grammarAccess.getLiteralAccess().getNUMBERTerminalRuleCall_1());
                    		

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBinaryOperator"
    // InternalEmodl.g:1492:1: entryRuleBinaryOperator returns [String current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final String entryRuleBinaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOperator = null;


        try {
            // InternalEmodl.g:1492:54: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // InternalEmodl.g:1493:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator.getText(); 
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
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // InternalEmodl.g:1499:1: ruleBinaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '^' | kw= 'min' | kw= 'max' ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEmodl.g:1505:2: ( (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '^' | kw= 'min' | kw= 'max' ) )
            // InternalEmodl.g:1506:2: (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '^' | kw= 'min' | kw= 'max' )
            {
            // InternalEmodl.g:1506:2: (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '^' | kw= 'min' | kw= 'max' )
            int alt13=7;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt13=1;
                }
                break;
            case 29:
                {
                alt13=2;
                }
                break;
            case 30:
                {
                alt13=3;
                }
                break;
            case 31:
                {
                alt13=4;
                }
                break;
            case 32:
                {
                alt13=5;
                }
                break;
            case 33:
                {
                alt13=6;
                }
                break;
            case 34:
                {
                alt13=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalEmodl.g:1507:3: kw= '+'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getPlusSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalEmodl.g:1513:3: kw= '-'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getHyphenMinusKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalEmodl.g:1519:3: kw= '*'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getAsteriskKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalEmodl.g:1525:3: kw= '/'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getSolidusKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalEmodl.g:1531:3: kw= '^'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getCircumflexAccentKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalEmodl.g:1537:3: kw= 'min'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getMinKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalEmodl.g:1543:3: kw= 'max'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getMaxKeyword_6());
                    		

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
    // $ANTLR end "ruleBinaryOperator"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000FFE0000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000007F0000000L});

}