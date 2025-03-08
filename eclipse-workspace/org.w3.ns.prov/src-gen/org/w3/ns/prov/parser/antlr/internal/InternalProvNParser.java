package org.w3.ns.prov.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.w3.ns.prov.services.ProvNGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalProvNParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_URISTRING", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'document'", "'endDocument'", "'prefix'", "'entity'", "'('", "','", "'['", "']'", "')'", "'activity'", "'agent'", "'wasDerivedFrom'", "'wasGeneratedBy'", "'used'", "'wasAssociatedWith'", "'wasAttributedTo'", "'hadMember'", "'='", "':'", "'-'", "'T'", "'Z'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_URISTRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalProvNParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalProvNParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalProvNParser.tokenNames; }
    public String getGrammarFileName() { return "InternalProvN.g"; }



     	private ProvNGrammarAccess grammarAccess;

        public InternalProvNParser(TokenStream input, ProvNGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Document";
       	}

       	@Override
       	protected ProvNGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDocument"
    // InternalProvN.g:64:1: entryRuleDocument returns [EObject current=null] : iv_ruleDocument= ruleDocument EOF ;
    public final EObject entryRuleDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocument = null;


        try {
            // InternalProvN.g:64:49: (iv_ruleDocument= ruleDocument EOF )
            // InternalProvN.g:65:2: iv_ruleDocument= ruleDocument EOF
            {
             newCompositeNode(grammarAccess.getDocumentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocument=ruleDocument();

            state._fsp--;

             current =iv_ruleDocument; 
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
    // $ANTLR end "entryRuleDocument"


    // $ANTLR start "ruleDocument"
    // InternalProvN.g:71:1: ruleDocument returns [EObject current=null] : (otherlv_0= 'document' ( (lv_name_1_0= ruleModel ) ) otherlv_2= 'endDocument' ) ;
    public final EObject ruleDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:77:2: ( (otherlv_0= 'document' ( (lv_name_1_0= ruleModel ) ) otherlv_2= 'endDocument' ) )
            // InternalProvN.g:78:2: (otherlv_0= 'document' ( (lv_name_1_0= ruleModel ) ) otherlv_2= 'endDocument' )
            {
            // InternalProvN.g:78:2: (otherlv_0= 'document' ( (lv_name_1_0= ruleModel ) ) otherlv_2= 'endDocument' )
            // InternalProvN.g:79:3: otherlv_0= 'document' ( (lv_name_1_0= ruleModel ) ) otherlv_2= 'endDocument'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDocumentAccess().getDocumentKeyword_0());
            		
            // InternalProvN.g:83:3: ( (lv_name_1_0= ruleModel ) )
            // InternalProvN.g:84:4: (lv_name_1_0= ruleModel )
            {
            // InternalProvN.g:84:4: (lv_name_1_0= ruleModel )
            // InternalProvN.g:85:5: lv_name_1_0= ruleModel
            {

            					newCompositeNode(grammarAccess.getDocumentAccess().getNameModelParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDocumentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.w3.ns.prov.ProvN.Model");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDocumentAccess().getEndDocumentKeyword_2());
            		

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
    // $ANTLR end "ruleDocument"


    // $ANTLR start "entryRuleModel"
    // InternalProvN.g:110:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalProvN.g:110:46: (iv_ruleModel= ruleModel EOF )
            // InternalProvN.g:111:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalProvN.g:117:1: ruleModel returns [EObject current=null] : ( () ( (lv_namespaces_1_0= ruleNamespace ) )* ( (lv_statements_2_0= ruleStatement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_namespaces_1_0 = null;

        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:123:2: ( ( () ( (lv_namespaces_1_0= ruleNamespace ) )* ( (lv_statements_2_0= ruleStatement ) )* ) )
            // InternalProvN.g:124:2: ( () ( (lv_namespaces_1_0= ruleNamespace ) )* ( (lv_statements_2_0= ruleStatement ) )* )
            {
            // InternalProvN.g:124:2: ( () ( (lv_namespaces_1_0= ruleNamespace ) )* ( (lv_statements_2_0= ruleStatement ) )* )
            // InternalProvN.g:125:3: () ( (lv_namespaces_1_0= ruleNamespace ) )* ( (lv_statements_2_0= ruleStatement ) )*
            {
            // InternalProvN.g:125:3: ()
            // InternalProvN.g:126:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getModelAccess().getModelAction_0(),
            					current);
            			

            }

            // InternalProvN.g:132:3: ( (lv_namespaces_1_0= ruleNamespace ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalProvN.g:133:4: (lv_namespaces_1_0= ruleNamespace )
            	    {
            	    // InternalProvN.g:133:4: (lv_namespaces_1_0= ruleNamespace )
            	    // InternalProvN.g:134:5: lv_namespaces_1_0= ruleNamespace
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getNamespacesNamespaceParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_namespaces_1_0=ruleNamespace();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"namespaces",
            	    						lv_namespaces_1_0,
            	    						"org.w3.ns.prov.ProvN.Namespace");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalProvN.g:151:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15||(LA2_0>=21 && LA2_0<=28)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalProvN.g:152:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalProvN.g:152:4: (lv_statements_2_0= ruleStatement )
            	    // InternalProvN.g:153:5: lv_statements_2_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_2_0,
            	    						"org.w3.ns.prov.ProvN.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleNamespace"
    // InternalProvN.g:174:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalProvN.g:174:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalProvN.g:175:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace; 
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
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalProvN.g:181:1: ruleNamespace returns [EObject current=null] : ( () otherlv_1= 'prefix' ( (lv_name_2_0= RULE_ID ) ) ( (lv_uri_3_0= RULE_URISTRING ) ) ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_uri_3_0=null;


        	enterRule();

        try {
            // InternalProvN.g:187:2: ( ( () otherlv_1= 'prefix' ( (lv_name_2_0= RULE_ID ) ) ( (lv_uri_3_0= RULE_URISTRING ) ) ) )
            // InternalProvN.g:188:2: ( () otherlv_1= 'prefix' ( (lv_name_2_0= RULE_ID ) ) ( (lv_uri_3_0= RULE_URISTRING ) ) )
            {
            // InternalProvN.g:188:2: ( () otherlv_1= 'prefix' ( (lv_name_2_0= RULE_ID ) ) ( (lv_uri_3_0= RULE_URISTRING ) ) )
            // InternalProvN.g:189:3: () otherlv_1= 'prefix' ( (lv_name_2_0= RULE_ID ) ) ( (lv_uri_3_0= RULE_URISTRING ) )
            {
            // InternalProvN.g:189:3: ()
            // InternalProvN.g:190:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNamespaceAccess().getNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getNamespaceAccess().getPrefixKeyword_1());
            		
            // InternalProvN.g:200:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalProvN.g:201:4: (lv_name_2_0= RULE_ID )
            {
            // InternalProvN.g:201:4: (lv_name_2_0= RULE_ID )
            // InternalProvN.g:202:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getNamespaceAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNamespaceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalProvN.g:218:3: ( (lv_uri_3_0= RULE_URISTRING ) )
            // InternalProvN.g:219:4: (lv_uri_3_0= RULE_URISTRING )
            {
            // InternalProvN.g:219:4: (lv_uri_3_0= RULE_URISTRING )
            // InternalProvN.g:220:5: lv_uri_3_0= RULE_URISTRING
            {
            lv_uri_3_0=(Token)match(input,RULE_URISTRING,FOLLOW_2); 

            					newLeafNode(lv_uri_3_0, grammarAccess.getNamespaceAccess().getUriURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNamespaceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"uri",
            						lv_uri_3_0,
            						"org.w3.ns.prov.ProvN.URISTRING");
            				

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
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleStatement"
    // InternalProvN.g:240:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalProvN.g:240:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalProvN.g:241:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalProvN.g:247:1: ruleStatement returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Activity_1= ruleActivity | this_Agent_2= ruleAgent | this_Relation_3= ruleRelation ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Activity_1 = null;

        EObject this_Agent_2 = null;

        EObject this_Relation_3 = null;



        	enterRule();

        try {
            // InternalProvN.g:253:2: ( (this_Entity_0= ruleEntity | this_Activity_1= ruleActivity | this_Agent_2= ruleAgent | this_Relation_3= ruleRelation ) )
            // InternalProvN.g:254:2: (this_Entity_0= ruleEntity | this_Activity_1= ruleActivity | this_Agent_2= ruleAgent | this_Relation_3= ruleRelation )
            {
            // InternalProvN.g:254:2: (this_Entity_0= ruleEntity | this_Activity_1= ruleActivity | this_Agent_2= ruleAgent | this_Relation_3= ruleRelation )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 22:
                {
                alt3=3;
                }
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalProvN.g:255:3: this_Entity_0= ruleEntity
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalProvN.g:264:3: this_Activity_1= ruleActivity
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getActivityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Activity_1=ruleActivity();

                    state._fsp--;


                    			current = this_Activity_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalProvN.g:273:3: this_Agent_2= ruleAgent
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getAgentParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Agent_2=ruleAgent();

                    state._fsp--;


                    			current = this_Agent_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalProvN.g:282:3: this_Relation_3= ruleRelation
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getRelationParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Relation_3=ruleRelation();

                    state._fsp--;


                    			current = this_Relation_3;
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleEntity"
    // InternalProvN.g:294:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalProvN.g:294:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalProvN.g:295:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalProvN.g:301:1: ruleEntity returns [EObject current=null] : ( () otherlv_1= 'entity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_attributes_8_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:307:2: ( ( () otherlv_1= 'entity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' ) )
            // InternalProvN.g:308:2: ( () otherlv_1= 'entity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' )
            {
            // InternalProvN.g:308:2: ( () otherlv_1= 'entity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' )
            // InternalProvN.g:309:3: () otherlv_1= 'entity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')'
            {
            // InternalProvN.g:309:3: ()
            // InternalProvN.g:310:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEntityAccess().getEntityAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityAccess().getEntityKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getLeftParenthesisKeyword_2());
            		
            // InternalProvN.g:324:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalProvN.g:325:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalProvN.g:325:4: (lv_name_3_0= ruleQualifiedName )
            // InternalProvN.g:326:5: lv_name_3_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getEntityAccess().getNameQualifiedNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.w3.ns.prov.ProvN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:343:3: (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalProvN.g:344:4: otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']'
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getEntityAccess().getLeftSquareBracketKeyword_4_1());
                    			
                    // InternalProvN.g:352:4: ( (lv_attributes_6_0= ruleAttribute ) )
                    // InternalProvN.g:353:5: (lv_attributes_6_0= ruleAttribute )
                    {
                    // InternalProvN.g:353:5: (lv_attributes_6_0= ruleAttribute )
                    // InternalProvN.g:354:6: lv_attributes_6_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getEntityAccess().getAttributesAttributeParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_6_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEntityRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_6_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:371:4: (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalProvN.g:372:5: otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) )
                    	    {
                    	    otherlv_7=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getEntityAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalProvN.g:376:5: ( (lv_attributes_8_0= ruleAttribute ) )
                    	    // InternalProvN.g:377:6: (lv_attributes_8_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:377:6: (lv_attributes_8_0= ruleAttribute )
                    	    // InternalProvN.g:378:7: lv_attributes_8_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getEntityAccess().getAttributesAttributeParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_8_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEntityRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_8_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getEntityAccess().getRightSquareBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getEntityAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleActivity"
    // InternalProvN.g:409:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
    public final EObject entryRuleActivity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivity = null;


        try {
            // InternalProvN.g:409:49: (iv_ruleActivity= ruleActivity EOF )
            // InternalProvN.g:410:2: iv_ruleActivity= ruleActivity EOF
            {
             newCompositeNode(grammarAccess.getActivityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActivity=ruleActivity();

            state._fsp--;

             current =iv_ruleActivity; 
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
    // $ANTLR end "entryRuleActivity"


    // $ANTLR start "ruleActivity"
    // InternalProvN.g:416:1: ruleActivity returns [EObject current=null] : ( () otherlv_1= 'activity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) ) )? (otherlv_6= ',' ( (lv_endTime_7_0= ruleDateTime ) ) )? (otherlv_8= ',' otherlv_9= '[' ( (lv_attributes_10_0= ruleAttribute ) ) (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )* otherlv_13= ']' )? otherlv_14= ')' ) ;
    public final EObject ruleActivity() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_startTime_5_0 = null;

        EObject lv_endTime_7_0 = null;

        EObject lv_attributes_10_0 = null;

        EObject lv_attributes_12_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:422:2: ( ( () otherlv_1= 'activity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) ) )? (otherlv_6= ',' ( (lv_endTime_7_0= ruleDateTime ) ) )? (otherlv_8= ',' otherlv_9= '[' ( (lv_attributes_10_0= ruleAttribute ) ) (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )* otherlv_13= ']' )? otherlv_14= ')' ) )
            // InternalProvN.g:423:2: ( () otherlv_1= 'activity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) ) )? (otherlv_6= ',' ( (lv_endTime_7_0= ruleDateTime ) ) )? (otherlv_8= ',' otherlv_9= '[' ( (lv_attributes_10_0= ruleAttribute ) ) (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )* otherlv_13= ']' )? otherlv_14= ')' )
            {
            // InternalProvN.g:423:2: ( () otherlv_1= 'activity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) ) )? (otherlv_6= ',' ( (lv_endTime_7_0= ruleDateTime ) ) )? (otherlv_8= ',' otherlv_9= '[' ( (lv_attributes_10_0= ruleAttribute ) ) (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )* otherlv_13= ']' )? otherlv_14= ')' )
            // InternalProvN.g:424:3: () otherlv_1= 'activity' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) ) )? (otherlv_6= ',' ( (lv_endTime_7_0= ruleDateTime ) ) )? (otherlv_8= ',' otherlv_9= '[' ( (lv_attributes_10_0= ruleAttribute ) ) (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )* otherlv_13= ']' )? otherlv_14= ')'
            {
            // InternalProvN.g:424:3: ()
            // InternalProvN.g:425:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActivityAccess().getActivityAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getActivityAccess().getActivityKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getActivityAccess().getLeftParenthesisKeyword_2());
            		
            // InternalProvN.g:439:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalProvN.g:440:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalProvN.g:440:4: (lv_name_3_0= ruleQualifiedName )
            // InternalProvN.g:441:5: lv_name_3_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getActivityAccess().getNameQualifiedNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActivityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.w3.ns.prov.ProvN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:458:3: (otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) ) )?
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalProvN.g:459:4: otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) )
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_4, grammarAccess.getActivityAccess().getCommaKeyword_4_0());
                    			
                    // InternalProvN.g:463:4: ( (lv_startTime_5_0= ruleDateTime ) )
                    // InternalProvN.g:464:5: (lv_startTime_5_0= ruleDateTime )
                    {
                    // InternalProvN.g:464:5: (lv_startTime_5_0= ruleDateTime )
                    // InternalProvN.g:465:6: lv_startTime_5_0= ruleDateTime
                    {

                    						newCompositeNode(grammarAccess.getActivityAccess().getStartTimeDateTimeParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_startTime_5_0=ruleDateTime();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActivityRule());
                    						}
                    						set(
                    							current,
                    							"startTime",
                    							lv_startTime_5_0,
                    							"org.w3.ns.prov.ProvN.DateTime");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalProvN.g:483:3: (otherlv_6= ',' ( (lv_endTime_7_0= ruleDateTime ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalProvN.g:484:4: otherlv_6= ',' ( (lv_endTime_7_0= ruleDateTime ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_6, grammarAccess.getActivityAccess().getCommaKeyword_5_0());
                    			
                    // InternalProvN.g:488:4: ( (lv_endTime_7_0= ruleDateTime ) )
                    // InternalProvN.g:489:5: (lv_endTime_7_0= ruleDateTime )
                    {
                    // InternalProvN.g:489:5: (lv_endTime_7_0= ruleDateTime )
                    // InternalProvN.g:490:6: lv_endTime_7_0= ruleDateTime
                    {

                    						newCompositeNode(grammarAccess.getActivityAccess().getEndTimeDateTimeParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_endTime_7_0=ruleDateTime();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActivityRule());
                    						}
                    						set(
                    							current,
                    							"endTime",
                    							lv_endTime_7_0,
                    							"org.w3.ns.prov.ProvN.DateTime");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalProvN.g:508:3: (otherlv_8= ',' otherlv_9= '[' ( (lv_attributes_10_0= ruleAttribute ) ) (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )* otherlv_13= ']' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalProvN.g:509:4: otherlv_8= ',' otherlv_9= '[' ( (lv_attributes_10_0= ruleAttribute ) ) (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )* otherlv_13= ']'
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getActivityAccess().getCommaKeyword_6_0());
                    			
                    otherlv_9=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getActivityAccess().getLeftSquareBracketKeyword_6_1());
                    			
                    // InternalProvN.g:517:4: ( (lv_attributes_10_0= ruleAttribute ) )
                    // InternalProvN.g:518:5: (lv_attributes_10_0= ruleAttribute )
                    {
                    // InternalProvN.g:518:5: (lv_attributes_10_0= ruleAttribute )
                    // InternalProvN.g:519:6: lv_attributes_10_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getActivityAccess().getAttributesAttributeParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_10_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActivityRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_10_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:536:4: (otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalProvN.g:537:5: otherlv_11= ',' ( (lv_attributes_12_0= ruleAttribute ) )
                    	    {
                    	    otherlv_11=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_11, grammarAccess.getActivityAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalProvN.g:541:5: ( (lv_attributes_12_0= ruleAttribute ) )
                    	    // InternalProvN.g:542:6: (lv_attributes_12_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:542:6: (lv_attributes_12_0= ruleAttribute )
                    	    // InternalProvN.g:543:7: lv_attributes_12_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getActivityAccess().getAttributesAttributeParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_12_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getActivityRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_12_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_13, grammarAccess.getActivityAccess().getRightSquareBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getActivityAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleActivity"


    // $ANTLR start "entryRuleAgent"
    // InternalProvN.g:574:1: entryRuleAgent returns [EObject current=null] : iv_ruleAgent= ruleAgent EOF ;
    public final EObject entryRuleAgent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAgent = null;


        try {
            // InternalProvN.g:574:46: (iv_ruleAgent= ruleAgent EOF )
            // InternalProvN.g:575:2: iv_ruleAgent= ruleAgent EOF
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
    // InternalProvN.g:581:1: ruleAgent returns [EObject current=null] : ( () otherlv_1= 'agent' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' ) ;
    public final EObject ruleAgent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_attributes_8_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:587:2: ( ( () otherlv_1= 'agent' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' ) )
            // InternalProvN.g:588:2: ( () otherlv_1= 'agent' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' )
            {
            // InternalProvN.g:588:2: ( () otherlv_1= 'agent' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')' )
            // InternalProvN.g:589:3: () otherlv_1= 'agent' otherlv_2= '(' ( (lv_name_3_0= ruleQualifiedName ) ) (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )? otherlv_10= ')'
            {
            // InternalProvN.g:589:3: ()
            // InternalProvN.g:590:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAgentAccess().getAgentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getAgentAccess().getAgentKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getAgentAccess().getLeftParenthesisKeyword_2());
            		
            // InternalProvN.g:604:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalProvN.g:605:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalProvN.g:605:4: (lv_name_3_0= ruleQualifiedName )
            // InternalProvN.g:606:5: lv_name_3_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getAgentAccess().getNameQualifiedNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAgentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.w3.ns.prov.ProvN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:623:3: (otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalProvN.g:624:4: otherlv_4= ',' otherlv_5= '[' ( (lv_attributes_6_0= ruleAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )* otherlv_9= ']'
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getAgentAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getAgentAccess().getLeftSquareBracketKeyword_4_1());
                    			
                    // InternalProvN.g:632:4: ( (lv_attributes_6_0= ruleAttribute ) )
                    // InternalProvN.g:633:5: (lv_attributes_6_0= ruleAttribute )
                    {
                    // InternalProvN.g:633:5: (lv_attributes_6_0= ruleAttribute )
                    // InternalProvN.g:634:6: lv_attributes_6_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getAgentAccess().getAttributesAttributeParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_6_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAgentRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_6_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:651:4: (otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==17) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalProvN.g:652:5: otherlv_7= ',' ( (lv_attributes_8_0= ruleAttribute ) )
                    	    {
                    	    otherlv_7=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getAgentAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalProvN.g:656:5: ( (lv_attributes_8_0= ruleAttribute ) )
                    	    // InternalProvN.g:657:6: (lv_attributes_8_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:657:6: (lv_attributes_8_0= ruleAttribute )
                    	    // InternalProvN.g:658:7: lv_attributes_8_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getAgentAccess().getAttributesAttributeParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_8_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAgentRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_8_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getAgentAccess().getRightSquareBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getAgentAccess().getRightParenthesisKeyword_5());
            		

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


    // $ANTLR start "entryRuleRelation"
    // InternalProvN.g:689:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // InternalProvN.g:689:49: (iv_ruleRelation= ruleRelation EOF )
            // InternalProvN.g:690:2: iv_ruleRelation= ruleRelation EOF
            {
             newCompositeNode(grammarAccess.getRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelation=ruleRelation();

            state._fsp--;

             current =iv_ruleRelation; 
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
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // InternalProvN.g:696:1: ruleRelation returns [EObject current=null] : (this_WasDerivedFrom_0= ruleWasDerivedFrom | this_WasGeneratedBy_1= ruleWasGeneratedBy | this_Used_2= ruleUsed | this_WasAssociatedWith_3= ruleWasAssociatedWith | this_WasAttributedTo_4= ruleWasAttributedTo | this_HadMember_5= ruleHadMember ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        EObject this_WasDerivedFrom_0 = null;

        EObject this_WasGeneratedBy_1 = null;

        EObject this_Used_2 = null;

        EObject this_WasAssociatedWith_3 = null;

        EObject this_WasAttributedTo_4 = null;

        EObject this_HadMember_5 = null;



        	enterRule();

        try {
            // InternalProvN.g:702:2: ( (this_WasDerivedFrom_0= ruleWasDerivedFrom | this_WasGeneratedBy_1= ruleWasGeneratedBy | this_Used_2= ruleUsed | this_WasAssociatedWith_3= ruleWasAssociatedWith | this_WasAttributedTo_4= ruleWasAttributedTo | this_HadMember_5= ruleHadMember ) )
            // InternalProvN.g:703:2: (this_WasDerivedFrom_0= ruleWasDerivedFrom | this_WasGeneratedBy_1= ruleWasGeneratedBy | this_Used_2= ruleUsed | this_WasAssociatedWith_3= ruleWasAssociatedWith | this_WasAttributedTo_4= ruleWasAttributedTo | this_HadMember_5= ruleHadMember )
            {
            // InternalProvN.g:703:2: (this_WasDerivedFrom_0= ruleWasDerivedFrom | this_WasGeneratedBy_1= ruleWasGeneratedBy | this_Used_2= ruleUsed | this_WasAssociatedWith_3= ruleWasAssociatedWith | this_WasAttributedTo_4= ruleWasAttributedTo | this_HadMember_5= ruleHadMember )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt12=1;
                }
                break;
            case 24:
                {
                alt12=2;
                }
                break;
            case 25:
                {
                alt12=3;
                }
                break;
            case 26:
                {
                alt12=4;
                }
                break;
            case 27:
                {
                alt12=5;
                }
                break;
            case 28:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalProvN.g:704:3: this_WasDerivedFrom_0= ruleWasDerivedFrom
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getWasDerivedFromParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_WasDerivedFrom_0=ruleWasDerivedFrom();

                    state._fsp--;


                    			current = this_WasDerivedFrom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalProvN.g:713:3: this_WasGeneratedBy_1= ruleWasGeneratedBy
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getWasGeneratedByParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_WasGeneratedBy_1=ruleWasGeneratedBy();

                    state._fsp--;


                    			current = this_WasGeneratedBy_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalProvN.g:722:3: this_Used_2= ruleUsed
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getUsedParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Used_2=ruleUsed();

                    state._fsp--;


                    			current = this_Used_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalProvN.g:731:3: this_WasAssociatedWith_3= ruleWasAssociatedWith
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getWasAssociatedWithParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_WasAssociatedWith_3=ruleWasAssociatedWith();

                    state._fsp--;


                    			current = this_WasAssociatedWith_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalProvN.g:740:3: this_WasAttributedTo_4= ruleWasAttributedTo
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getWasAttributedToParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_WasAttributedTo_4=ruleWasAttributedTo();

                    state._fsp--;


                    			current = this_WasAttributedTo_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalProvN.g:749:3: this_HadMember_5= ruleHadMember
                    {

                    			newCompositeNode(grammarAccess.getRelationAccess().getHadMemberParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_HadMember_5=ruleHadMember();

                    state._fsp--;


                    			current = this_HadMember_5;
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
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleWasDerivedFrom"
    // InternalProvN.g:761:1: entryRuleWasDerivedFrom returns [EObject current=null] : iv_ruleWasDerivedFrom= ruleWasDerivedFrom EOF ;
    public final EObject entryRuleWasDerivedFrom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWasDerivedFrom = null;


        try {
            // InternalProvN.g:761:55: (iv_ruleWasDerivedFrom= ruleWasDerivedFrom EOF )
            // InternalProvN.g:762:2: iv_ruleWasDerivedFrom= ruleWasDerivedFrom EOF
            {
             newCompositeNode(grammarAccess.getWasDerivedFromRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWasDerivedFrom=ruleWasDerivedFrom();

            state._fsp--;

             current =iv_ruleWasDerivedFrom; 
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
    // $ANTLR end "entryRuleWasDerivedFrom"


    // $ANTLR start "ruleWasDerivedFrom"
    // InternalProvN.g:768:1: ruleWasDerivedFrom returns [EObject current=null] : (otherlv_0= 'wasDerivedFrom' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) ;
    public final EObject ruleWasDerivedFrom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_time_6_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_attributes_11_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:774:2: ( (otherlv_0= 'wasDerivedFrom' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) )
            // InternalProvN.g:775:2: (otherlv_0= 'wasDerivedFrom' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            {
            // InternalProvN.g:775:2: (otherlv_0= 'wasDerivedFrom' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            // InternalProvN.g:776:3: otherlv_0= 'wasDerivedFrom' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getWasDerivedFromAccess().getWasDerivedFromKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getWasDerivedFromAccess().getLeftParenthesisKeyword_1());
            		
            // InternalProvN.g:784:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:785:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:785:4: ( ruleQualifiedName )
            // InternalProvN.g:786:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasDerivedFromRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasDerivedFromAccess().getGeneratedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getWasDerivedFromAccess().getCommaKeyword_3());
            		
            // InternalProvN.g:804:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:805:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:805:4: ( ruleQualifiedName )
            // InternalProvN.g:806:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasDerivedFromRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasDerivedFromAccess().getUsedEntityEntityCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:820:3: (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_INT) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // InternalProvN.g:821:4: otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_5, grammarAccess.getWasDerivedFromAccess().getCommaKeyword_5_0());
                    			
                    // InternalProvN.g:825:4: ( (lv_time_6_0= ruleDateTime ) )
                    // InternalProvN.g:826:5: (lv_time_6_0= ruleDateTime )
                    {
                    // InternalProvN.g:826:5: (lv_time_6_0= ruleDateTime )
                    // InternalProvN.g:827:6: lv_time_6_0= ruleDateTime
                    {

                    						newCompositeNode(grammarAccess.getWasDerivedFromAccess().getTimeDateTimeParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_time_6_0=ruleDateTime();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWasDerivedFromRule());
                    						}
                    						set(
                    							current,
                    							"time",
                    							lv_time_6_0,
                    							"org.w3.ns.prov.ProvN.DateTime");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalProvN.g:845:3: (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalProvN.g:846:4: otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getWasDerivedFromAccess().getCommaKeyword_6_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getWasDerivedFromAccess().getLeftSquareBracketKeyword_6_1());
                    			
                    // InternalProvN.g:854:4: ( (lv_attributes_9_0= ruleAttribute ) )
                    // InternalProvN.g:855:5: (lv_attributes_9_0= ruleAttribute )
                    {
                    // InternalProvN.g:855:5: (lv_attributes_9_0= ruleAttribute )
                    // InternalProvN.g:856:6: lv_attributes_9_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getWasDerivedFromAccess().getAttributesAttributeParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_9_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWasDerivedFromRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_9_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:873:4: (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalProvN.g:874:5: otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) )
                    	    {
                    	    otherlv_10=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getWasDerivedFromAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalProvN.g:878:5: ( (lv_attributes_11_0= ruleAttribute ) )
                    	    // InternalProvN.g:879:6: (lv_attributes_11_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:879:6: (lv_attributes_11_0= ruleAttribute )
                    	    // InternalProvN.g:880:7: lv_attributes_11_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getWasDerivedFromAccess().getAttributesAttributeParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_11_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWasDerivedFromRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_11_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getWasDerivedFromAccess().getRightSquareBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getWasDerivedFromAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleWasDerivedFrom"


    // $ANTLR start "entryRuleWasGeneratedBy"
    // InternalProvN.g:911:1: entryRuleWasGeneratedBy returns [EObject current=null] : iv_ruleWasGeneratedBy= ruleWasGeneratedBy EOF ;
    public final EObject entryRuleWasGeneratedBy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWasGeneratedBy = null;


        try {
            // InternalProvN.g:911:55: (iv_ruleWasGeneratedBy= ruleWasGeneratedBy EOF )
            // InternalProvN.g:912:2: iv_ruleWasGeneratedBy= ruleWasGeneratedBy EOF
            {
             newCompositeNode(grammarAccess.getWasGeneratedByRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWasGeneratedBy=ruleWasGeneratedBy();

            state._fsp--;

             current =iv_ruleWasGeneratedBy; 
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
    // $ANTLR end "entryRuleWasGeneratedBy"


    // $ANTLR start "ruleWasGeneratedBy"
    // InternalProvN.g:918:1: ruleWasGeneratedBy returns [EObject current=null] : (otherlv_0= 'wasGeneratedBy' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) ;
    public final EObject ruleWasGeneratedBy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_time_6_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_attributes_11_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:924:2: ( (otherlv_0= 'wasGeneratedBy' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) )
            // InternalProvN.g:925:2: (otherlv_0= 'wasGeneratedBy' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            {
            // InternalProvN.g:925:2: (otherlv_0= 'wasGeneratedBy' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            // InternalProvN.g:926:3: otherlv_0= 'wasGeneratedBy' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getWasGeneratedByAccess().getWasGeneratedByKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getWasGeneratedByAccess().getLeftParenthesisKeyword_1());
            		
            // InternalProvN.g:934:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:935:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:935:4: ( ruleQualifiedName )
            // InternalProvN.g:936:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasGeneratedByRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasGeneratedByAccess().getEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getWasGeneratedByAccess().getCommaKeyword_3());
            		
            // InternalProvN.g:954:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:955:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:955:4: ( ruleQualifiedName )
            // InternalProvN.g:956:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasGeneratedByRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasGeneratedByAccess().getActivityActivityCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:970:3: (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==RULE_INT) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalProvN.g:971:4: otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_5, grammarAccess.getWasGeneratedByAccess().getCommaKeyword_5_0());
                    			
                    // InternalProvN.g:975:4: ( (lv_time_6_0= ruleDateTime ) )
                    // InternalProvN.g:976:5: (lv_time_6_0= ruleDateTime )
                    {
                    // InternalProvN.g:976:5: (lv_time_6_0= ruleDateTime )
                    // InternalProvN.g:977:6: lv_time_6_0= ruleDateTime
                    {

                    						newCompositeNode(grammarAccess.getWasGeneratedByAccess().getTimeDateTimeParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_time_6_0=ruleDateTime();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWasGeneratedByRule());
                    						}
                    						set(
                    							current,
                    							"time",
                    							lv_time_6_0,
                    							"org.w3.ns.prov.ProvN.DateTime");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalProvN.g:995:3: (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalProvN.g:996:4: otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getWasGeneratedByAccess().getCommaKeyword_6_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getWasGeneratedByAccess().getLeftSquareBracketKeyword_6_1());
                    			
                    // InternalProvN.g:1004:4: ( (lv_attributes_9_0= ruleAttribute ) )
                    // InternalProvN.g:1005:5: (lv_attributes_9_0= ruleAttribute )
                    {
                    // InternalProvN.g:1005:5: (lv_attributes_9_0= ruleAttribute )
                    // InternalProvN.g:1006:6: lv_attributes_9_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getWasGeneratedByAccess().getAttributesAttributeParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_9_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWasGeneratedByRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_9_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:1023:4: (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==17) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalProvN.g:1024:5: otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) )
                    	    {
                    	    otherlv_10=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getWasGeneratedByAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalProvN.g:1028:5: ( (lv_attributes_11_0= ruleAttribute ) )
                    	    // InternalProvN.g:1029:6: (lv_attributes_11_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:1029:6: (lv_attributes_11_0= ruleAttribute )
                    	    // InternalProvN.g:1030:7: lv_attributes_11_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getWasGeneratedByAccess().getAttributesAttributeParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_11_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWasGeneratedByRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_11_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getWasGeneratedByAccess().getRightSquareBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getWasGeneratedByAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleWasGeneratedBy"


    // $ANTLR start "entryRuleUsed"
    // InternalProvN.g:1061:1: entryRuleUsed returns [EObject current=null] : iv_ruleUsed= ruleUsed EOF ;
    public final EObject entryRuleUsed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUsed = null;


        try {
            // InternalProvN.g:1061:45: (iv_ruleUsed= ruleUsed EOF )
            // InternalProvN.g:1062:2: iv_ruleUsed= ruleUsed EOF
            {
             newCompositeNode(grammarAccess.getUsedRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUsed=ruleUsed();

            state._fsp--;

             current =iv_ruleUsed; 
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
    // $ANTLR end "entryRuleUsed"


    // $ANTLR start "ruleUsed"
    // InternalProvN.g:1068:1: ruleUsed returns [EObject current=null] : (otherlv_0= 'used' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) ;
    public final EObject ruleUsed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_time_6_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_attributes_11_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:1074:2: ( (otherlv_0= 'used' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) )
            // InternalProvN.g:1075:2: (otherlv_0= 'used' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            {
            // InternalProvN.g:1075:2: (otherlv_0= 'used' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            // InternalProvN.g:1076:3: otherlv_0= 'used' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getUsedAccess().getUsedKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getUsedAccess().getLeftParenthesisKeyword_1());
            		
            // InternalProvN.g:1084:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1085:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1085:4: ( ruleQualifiedName )
            // InternalProvN.g:1086:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUsedRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUsedAccess().getActivityActivityCrossReference_2_0());
            				
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getUsedAccess().getCommaKeyword_3());
            		
            // InternalProvN.g:1104:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1105:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1105:4: ( ruleQualifiedName )
            // InternalProvN.g:1106:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUsedRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUsedAccess().getEntityEntityCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:1120:3: (otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==RULE_INT) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // InternalProvN.g:1121:4: otherlv_5= ',' ( (lv_time_6_0= ruleDateTime ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_5, grammarAccess.getUsedAccess().getCommaKeyword_5_0());
                    			
                    // InternalProvN.g:1125:4: ( (lv_time_6_0= ruleDateTime ) )
                    // InternalProvN.g:1126:5: (lv_time_6_0= ruleDateTime )
                    {
                    // InternalProvN.g:1126:5: (lv_time_6_0= ruleDateTime )
                    // InternalProvN.g:1127:6: lv_time_6_0= ruleDateTime
                    {

                    						newCompositeNode(grammarAccess.getUsedAccess().getTimeDateTimeParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_time_6_0=ruleDateTime();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUsedRule());
                    						}
                    						set(
                    							current,
                    							"time",
                    							lv_time_6_0,
                    							"org.w3.ns.prov.ProvN.DateTime");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalProvN.g:1145:3: (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalProvN.g:1146:4: otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getUsedAccess().getCommaKeyword_6_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getUsedAccess().getLeftSquareBracketKeyword_6_1());
                    			
                    // InternalProvN.g:1154:4: ( (lv_attributes_9_0= ruleAttribute ) )
                    // InternalProvN.g:1155:5: (lv_attributes_9_0= ruleAttribute )
                    {
                    // InternalProvN.g:1155:5: (lv_attributes_9_0= ruleAttribute )
                    // InternalProvN.g:1156:6: lv_attributes_9_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getUsedAccess().getAttributesAttributeParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_9_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUsedRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_9_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:1173:4: (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==17) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalProvN.g:1174:5: otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) )
                    	    {
                    	    otherlv_10=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getUsedAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalProvN.g:1178:5: ( (lv_attributes_11_0= ruleAttribute ) )
                    	    // InternalProvN.g:1179:6: (lv_attributes_11_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:1179:6: (lv_attributes_11_0= ruleAttribute )
                    	    // InternalProvN.g:1180:7: lv_attributes_11_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getUsedAccess().getAttributesAttributeParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_11_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getUsedRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_11_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getUsedAccess().getRightSquareBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getUsedAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleUsed"


    // $ANTLR start "entryRuleWasAssociatedWith"
    // InternalProvN.g:1211:1: entryRuleWasAssociatedWith returns [EObject current=null] : iv_ruleWasAssociatedWith= ruleWasAssociatedWith EOF ;
    public final EObject entryRuleWasAssociatedWith() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWasAssociatedWith = null;


        try {
            // InternalProvN.g:1211:58: (iv_ruleWasAssociatedWith= ruleWasAssociatedWith EOF )
            // InternalProvN.g:1212:2: iv_ruleWasAssociatedWith= ruleWasAssociatedWith EOF
            {
             newCompositeNode(grammarAccess.getWasAssociatedWithRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWasAssociatedWith=ruleWasAssociatedWith();

            state._fsp--;

             current =iv_ruleWasAssociatedWith; 
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
    // $ANTLR end "entryRuleWasAssociatedWith"


    // $ANTLR start "ruleWasAssociatedWith"
    // InternalProvN.g:1218:1: ruleWasAssociatedWith returns [EObject current=null] : (otherlv_0= 'wasAssociatedWith' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) ;
    public final EObject ruleWasAssociatedWith() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_attributes_9_0 = null;

        EObject lv_attributes_11_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:1224:2: ( (otherlv_0= 'wasAssociatedWith' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' ) )
            // InternalProvN.g:1225:2: (otherlv_0= 'wasAssociatedWith' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            {
            // InternalProvN.g:1225:2: (otherlv_0= 'wasAssociatedWith' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')' )
            // InternalProvN.g:1226:3: otherlv_0= 'wasAssociatedWith' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )? otherlv_13= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getWasAssociatedWithAccess().getWasAssociatedWithKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getWasAssociatedWithAccess().getLeftParenthesisKeyword_1());
            		
            // InternalProvN.g:1234:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1235:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1235:4: ( ruleQualifiedName )
            // InternalProvN.g:1236:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasAssociatedWithRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasAssociatedWithAccess().getActivityActivityCrossReference_2_0());
            				
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getWasAssociatedWithAccess().getCommaKeyword_3());
            		
            // InternalProvN.g:1254:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1255:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1255:4: ( ruleQualifiedName )
            // InternalProvN.g:1256:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasAssociatedWithRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasAssociatedWithAccess().getAgentAgentCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:1270:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_ID) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalProvN.g:1271:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getWasAssociatedWithAccess().getCommaKeyword_5_0());
                    			
                    // InternalProvN.g:1275:4: ( (otherlv_6= RULE_ID ) )
                    // InternalProvN.g:1276:5: (otherlv_6= RULE_ID )
                    {
                    // InternalProvN.g:1276:5: (otherlv_6= RULE_ID )
                    // InternalProvN.g:1277:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getWasAssociatedWithRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_6, grammarAccess.getWasAssociatedWithAccess().getPlanEntityCrossReference_5_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalProvN.g:1289:3: (otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==17) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalProvN.g:1290:4: otherlv_7= ',' otherlv_8= '[' ( (lv_attributes_9_0= ruleAttribute ) ) (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )* otherlv_12= ']'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getWasAssociatedWithAccess().getCommaKeyword_6_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getWasAssociatedWithAccess().getLeftSquareBracketKeyword_6_1());
                    			
                    // InternalProvN.g:1298:4: ( (lv_attributes_9_0= ruleAttribute ) )
                    // InternalProvN.g:1299:5: (lv_attributes_9_0= ruleAttribute )
                    {
                    // InternalProvN.g:1299:5: (lv_attributes_9_0= ruleAttribute )
                    // InternalProvN.g:1300:6: lv_attributes_9_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getWasAssociatedWithAccess().getAttributesAttributeParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_9_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWasAssociatedWithRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_9_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:1317:4: (otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==17) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalProvN.g:1318:5: otherlv_10= ',' ( (lv_attributes_11_0= ruleAttribute ) )
                    	    {
                    	    otherlv_10=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getWasAssociatedWithAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalProvN.g:1322:5: ( (lv_attributes_11_0= ruleAttribute ) )
                    	    // InternalProvN.g:1323:6: (lv_attributes_11_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:1323:6: (lv_attributes_11_0= ruleAttribute )
                    	    // InternalProvN.g:1324:7: lv_attributes_11_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getWasAssociatedWithAccess().getAttributesAttributeParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_11_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWasAssociatedWithRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_11_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getWasAssociatedWithAccess().getRightSquareBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getWasAssociatedWithAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleWasAssociatedWith"


    // $ANTLR start "entryRuleWasAttributedTo"
    // InternalProvN.g:1355:1: entryRuleWasAttributedTo returns [EObject current=null] : iv_ruleWasAttributedTo= ruleWasAttributedTo EOF ;
    public final EObject entryRuleWasAttributedTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWasAttributedTo = null;


        try {
            // InternalProvN.g:1355:56: (iv_ruleWasAttributedTo= ruleWasAttributedTo EOF )
            // InternalProvN.g:1356:2: iv_ruleWasAttributedTo= ruleWasAttributedTo EOF
            {
             newCompositeNode(grammarAccess.getWasAttributedToRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWasAttributedTo=ruleWasAttributedTo();

            state._fsp--;

             current =iv_ruleWasAttributedTo; 
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
    // $ANTLR end "entryRuleWasAttributedTo"


    // $ANTLR start "ruleWasAttributedTo"
    // InternalProvN.g:1362:1: ruleWasAttributedTo returns [EObject current=null] : (otherlv_0= 'wasAttributedTo' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= '[' ( (lv_attributes_7_0= ruleAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )* otherlv_10= ']' )? otherlv_11= ')' ) ;
    public final EObject ruleWasAttributedTo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_attributes_7_0 = null;

        EObject lv_attributes_9_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:1368:2: ( (otherlv_0= 'wasAttributedTo' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= '[' ( (lv_attributes_7_0= ruleAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )* otherlv_10= ']' )? otherlv_11= ')' ) )
            // InternalProvN.g:1369:2: (otherlv_0= 'wasAttributedTo' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= '[' ( (lv_attributes_7_0= ruleAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )* otherlv_10= ']' )? otherlv_11= ')' )
            {
            // InternalProvN.g:1369:2: (otherlv_0= 'wasAttributedTo' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= '[' ( (lv_attributes_7_0= ruleAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )* otherlv_10= ']' )? otherlv_11= ')' )
            // InternalProvN.g:1370:3: otherlv_0= 'wasAttributedTo' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= '[' ( (lv_attributes_7_0= ruleAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )* otherlv_10= ']' )? otherlv_11= ')'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getWasAttributedToAccess().getWasAttributedToKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getWasAttributedToAccess().getLeftParenthesisKeyword_1());
            		
            // InternalProvN.g:1378:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1379:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1379:4: ( ruleQualifiedName )
            // InternalProvN.g:1380:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasAttributedToRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasAttributedToAccess().getEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getWasAttributedToAccess().getCommaKeyword_3());
            		
            // InternalProvN.g:1398:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1399:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1399:4: ( ruleQualifiedName )
            // InternalProvN.g:1400:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWasAttributedToRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWasAttributedToAccess().getAgentAgentCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalProvN.g:1414:3: (otherlv_5= ',' otherlv_6= '[' ( (lv_attributes_7_0= ruleAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )* otherlv_10= ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==17) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalProvN.g:1415:4: otherlv_5= ',' otherlv_6= '[' ( (lv_attributes_7_0= ruleAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )* otherlv_10= ']'
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getWasAttributedToAccess().getCommaKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getWasAttributedToAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalProvN.g:1423:4: ( (lv_attributes_7_0= ruleAttribute ) )
                    // InternalProvN.g:1424:5: (lv_attributes_7_0= ruleAttribute )
                    {
                    // InternalProvN.g:1424:5: (lv_attributes_7_0= ruleAttribute )
                    // InternalProvN.g:1425:6: lv_attributes_7_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getWasAttributedToAccess().getAttributesAttributeParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_attributes_7_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWasAttributedToRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_7_0,
                    							"org.w3.ns.prov.ProvN.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalProvN.g:1442:4: (otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==17) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalProvN.g:1443:5: otherlv_8= ',' ( (lv_attributes_9_0= ruleAttribute ) )
                    	    {
                    	    otherlv_8=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getWasAttributedToAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalProvN.g:1447:5: ( (lv_attributes_9_0= ruleAttribute ) )
                    	    // InternalProvN.g:1448:6: (lv_attributes_9_0= ruleAttribute )
                    	    {
                    	    // InternalProvN.g:1448:6: (lv_attributes_9_0= ruleAttribute )
                    	    // InternalProvN.g:1449:7: lv_attributes_9_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getWasAttributedToAccess().getAttributesAttributeParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_attributes_9_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWasAttributedToRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_9_0,
                    	    								"org.w3.ns.prov.ProvN.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_10, grammarAccess.getWasAttributedToAccess().getRightSquareBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getWasAttributedToAccess().getRightParenthesisKeyword_6());
            		

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
    // $ANTLR end "ruleWasAttributedTo"


    // $ANTLR start "entryRuleHadMember"
    // InternalProvN.g:1480:1: entryRuleHadMember returns [EObject current=null] : iv_ruleHadMember= ruleHadMember EOF ;
    public final EObject entryRuleHadMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHadMember = null;


        try {
            // InternalProvN.g:1480:50: (iv_ruleHadMember= ruleHadMember EOF )
            // InternalProvN.g:1481:2: iv_ruleHadMember= ruleHadMember EOF
            {
             newCompositeNode(grammarAccess.getHadMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHadMember=ruleHadMember();

            state._fsp--;

             current =iv_ruleHadMember; 
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
    // $ANTLR end "entryRuleHadMember"


    // $ANTLR start "ruleHadMember"
    // InternalProvN.g:1487:1: ruleHadMember returns [EObject current=null] : (otherlv_0= 'hadMember' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) otherlv_5= ')' ) ;
    public final EObject ruleHadMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalProvN.g:1493:2: ( (otherlv_0= 'hadMember' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) otherlv_5= ')' ) )
            // InternalProvN.g:1494:2: (otherlv_0= 'hadMember' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) otherlv_5= ')' )
            {
            // InternalProvN.g:1494:2: (otherlv_0= 'hadMember' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) otherlv_5= ')' )
            // InternalProvN.g:1495:3: otherlv_0= 'hadMember' otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ',' ( ( ruleQualifiedName ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getHadMemberAccess().getHadMemberKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getHadMemberAccess().getLeftParenthesisKeyword_1());
            		
            // InternalProvN.g:1503:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1504:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1504:4: ( ruleQualifiedName )
            // InternalProvN.g:1505:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHadMemberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHadMemberAccess().getCollectionEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getHadMemberAccess().getCommaKeyword_3());
            		
            // InternalProvN.g:1523:3: ( ( ruleQualifiedName ) )
            // InternalProvN.g:1524:4: ( ruleQualifiedName )
            {
            // InternalProvN.g:1524:4: ( ruleQualifiedName )
            // InternalProvN.g:1525:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHadMemberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHadMemberAccess().getMemberEntityCrossReference_4_0());
            				
            pushFollow(FOLLOW_13);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getHadMemberAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleHadMember"


    // $ANTLR start "entryRuleAttribute"
    // InternalProvN.g:1547:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalProvN.g:1547:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalProvN.g:1548:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalProvN.g:1554:1: ruleAttribute returns [EObject current=null] : ( ( (lv_label_0_0= ruleQualifiedName ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_label_0_0 = null;



        	enterRule();

        try {
            // InternalProvN.g:1560:2: ( ( ( (lv_label_0_0= ruleQualifiedName ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalProvN.g:1561:2: ( ( (lv_label_0_0= ruleQualifiedName ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalProvN.g:1561:2: ( ( (lv_label_0_0= ruleQualifiedName ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalProvN.g:1562:3: ( (lv_label_0_0= ruleQualifiedName ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalProvN.g:1562:3: ( (lv_label_0_0= ruleQualifiedName ) )
            // InternalProvN.g:1563:4: (lv_label_0_0= ruleQualifiedName )
            {
            // InternalProvN.g:1563:4: (lv_label_0_0= ruleQualifiedName )
            // InternalProvN.g:1564:5: lv_label_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getLabelQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
            lv_label_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"label",
            						lv_label_0_0,
            						"org.w3.ns.prov.ProvN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1());
            		
            // InternalProvN.g:1585:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalProvN.g:1586:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalProvN.g:1586:4: (lv_value_2_0= RULE_STRING )
            // InternalProvN.g:1587:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalProvN.g:1607:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalProvN.g:1607:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalProvN.g:1608:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalProvN.g:1614:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ':' )? this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalProvN.g:1620:2: ( ( (this_ID_0= RULE_ID kw= ':' )? this_ID_2= RULE_ID ) )
            // InternalProvN.g:1621:2: ( (this_ID_0= RULE_ID kw= ':' )? this_ID_2= RULE_ID )
            {
            // InternalProvN.g:1621:2: ( (this_ID_0= RULE_ID kw= ':' )? this_ID_2= RULE_ID )
            // InternalProvN.g:1622:3: (this_ID_0= RULE_ID kw= ':' )? this_ID_2= RULE_ID
            {
            // InternalProvN.g:1622:3: (this_ID_0= RULE_ID kw= ':' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==30) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalProvN.g:1623:4: this_ID_0= RULE_ID kw= ':'
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_18); 

                    				current.merge(this_ID_0);
                    			

                    				newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0_0());
                    			
                    kw=(Token)match(input,30,FOLLOW_7); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonKeyword_0_1());
                    			

                    }
                    break;

            }

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            			current.merge(this_ID_2);
            		

            			newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleDateTime"
    // InternalProvN.g:1647:1: entryRuleDateTime returns [EObject current=null] : iv_ruleDateTime= ruleDateTime EOF ;
    public final EObject entryRuleDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTime = null;


        try {
            // InternalProvN.g:1647:49: (iv_ruleDateTime= ruleDateTime EOF )
            // InternalProvN.g:1648:2: iv_ruleDateTime= ruleDateTime EOF
            {
             newCompositeNode(grammarAccess.getDateTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateTime=ruleDateTime();

            state._fsp--;

             current =iv_ruleDateTime; 
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
    // $ANTLR end "entryRuleDateTime"


    // $ANTLR start "ruleDateTime"
    // InternalProvN.g:1654:1: ruleDateTime returns [EObject current=null] : ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '-' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= 'T' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_minute_8_0= RULE_INT ) ) otherlv_9= ':' ( (lv_second_10_0= RULE_INT ) ) otherlv_11= 'Z' ) ;
    public final EObject ruleDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_year_0_0=null;
        Token otherlv_1=null;
        Token lv_month_2_0=null;
        Token otherlv_3=null;
        Token lv_day_4_0=null;
        Token otherlv_5=null;
        Token lv_hour_6_0=null;
        Token otherlv_7=null;
        Token lv_minute_8_0=null;
        Token otherlv_9=null;
        Token lv_second_10_0=null;
        Token otherlv_11=null;


        	enterRule();

        try {
            // InternalProvN.g:1660:2: ( ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '-' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= 'T' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_minute_8_0= RULE_INT ) ) otherlv_9= ':' ( (lv_second_10_0= RULE_INT ) ) otherlv_11= 'Z' ) )
            // InternalProvN.g:1661:2: ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '-' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= 'T' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_minute_8_0= RULE_INT ) ) otherlv_9= ':' ( (lv_second_10_0= RULE_INT ) ) otherlv_11= 'Z' )
            {
            // InternalProvN.g:1661:2: ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '-' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= 'T' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_minute_8_0= RULE_INT ) ) otherlv_9= ':' ( (lv_second_10_0= RULE_INT ) ) otherlv_11= 'Z' )
            // InternalProvN.g:1662:3: ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '-' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '-' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= 'T' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_minute_8_0= RULE_INT ) ) otherlv_9= ':' ( (lv_second_10_0= RULE_INT ) ) otherlv_11= 'Z'
            {
            // InternalProvN.g:1662:3: ( (lv_year_0_0= RULE_INT ) )
            // InternalProvN.g:1663:4: (lv_year_0_0= RULE_INT )
            {
            // InternalProvN.g:1663:4: (lv_year_0_0= RULE_INT )
            // InternalProvN.g:1664:5: lv_year_0_0= RULE_INT
            {
            lv_year_0_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_year_0_0, grammarAccess.getDateTimeAccess().getYearINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"year",
            						lv_year_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getDateTimeAccess().getHyphenMinusKeyword_1());
            		
            // InternalProvN.g:1684:3: ( (lv_month_2_0= RULE_INT ) )
            // InternalProvN.g:1685:4: (lv_month_2_0= RULE_INT )
            {
            // InternalProvN.g:1685:4: (lv_month_2_0= RULE_INT )
            // InternalProvN.g:1686:5: lv_month_2_0= RULE_INT
            {
            lv_month_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_month_2_0, grammarAccess.getDateTimeAccess().getMonthINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"month",
            						lv_month_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getDateTimeAccess().getHyphenMinusKeyword_3());
            		
            // InternalProvN.g:1706:3: ( (lv_day_4_0= RULE_INT ) )
            // InternalProvN.g:1707:4: (lv_day_4_0= RULE_INT )
            {
            // InternalProvN.g:1707:4: (lv_day_4_0= RULE_INT )
            // InternalProvN.g:1708:5: lv_day_4_0= RULE_INT
            {
            lv_day_4_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            					newLeafNode(lv_day_4_0, grammarAccess.getDateTimeAccess().getDayINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"day",
            						lv_day_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,32,FOLLOW_14); 

            			newLeafNode(otherlv_5, grammarAccess.getDateTimeAccess().getTKeyword_5());
            		
            // InternalProvN.g:1728:3: ( (lv_hour_6_0= RULE_INT ) )
            // InternalProvN.g:1729:4: (lv_hour_6_0= RULE_INT )
            {
            // InternalProvN.g:1729:4: (lv_hour_6_0= RULE_INT )
            // InternalProvN.g:1730:5: lv_hour_6_0= RULE_INT
            {
            lv_hour_6_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_hour_6_0, grammarAccess.getDateTimeAccess().getHourINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"hour",
            						lv_hour_6_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_7=(Token)match(input,30,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getDateTimeAccess().getColonKeyword_7());
            		
            // InternalProvN.g:1750:3: ( (lv_minute_8_0= RULE_INT ) )
            // InternalProvN.g:1751:4: (lv_minute_8_0= RULE_INT )
            {
            // InternalProvN.g:1751:4: (lv_minute_8_0= RULE_INT )
            // InternalProvN.g:1752:5: lv_minute_8_0= RULE_INT
            {
            lv_minute_8_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_minute_8_0, grammarAccess.getDateTimeAccess().getMinuteINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"minute",
            						lv_minute_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_9=(Token)match(input,30,FOLLOW_14); 

            			newLeafNode(otherlv_9, grammarAccess.getDateTimeAccess().getColonKeyword_9());
            		
            // InternalProvN.g:1772:3: ( (lv_second_10_0= RULE_INT ) )
            // InternalProvN.g:1773:4: (lv_second_10_0= RULE_INT )
            {
            // InternalProvN.g:1773:4: (lv_second_10_0= RULE_INT )
            // InternalProvN.g:1774:5: lv_second_10_0= RULE_INT
            {
            lv_second_10_0=(Token)match(input,RULE_INT,FOLLOW_21); 

            					newLeafNode(lv_second_10_0, grammarAccess.getDateTimeAccess().getSecondINTTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"second",
            						lv_second_10_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_11=(Token)match(input,33,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDateTimeAccess().getZKeyword_11());
            		

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
    // $ANTLR end "ruleDateTime"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\1\21\1\7\1\uffff\1\37\1\7\1\37\1\7\1\40\1\7\1\36\1\7\1\36\1\7\1\41\1\uffff";
    static final String dfa_3s = "\1\24\1\22\1\uffff\1\37\1\7\1\37\1\7\1\40\1\7\1\36\1\7\1\36\1\7\1\41\1\uffff";
    static final String dfa_4s = "\2\uffff\1\2\13\uffff\1\1";
    static final String dfa_5s = "\17\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\2\uffff\1\2",
            "\1\3\12\uffff\1\2",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "458:3: (otherlv_4= ',' ( (lv_startTime_5_0= ruleDateTime ) ) )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000001FE0E000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000001FE0C002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000001FE08002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000200000000L});

}