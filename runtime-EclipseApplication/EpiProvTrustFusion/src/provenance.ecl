// Match the top-level Document (assumes document name is used as identifier)
rule MatchDocuments
match l : Left!Document with r : Right!Document {
    compare : true
    do {
        System.out.println("Matched Document: " + l.compartmentalModel);
    }
}

// Match the Model contained in a Document
rule MatchModels
match l : Left!Model with r : Right!Model {
    compare : true
    do {
        System.out.println("Matched Model");
    }
}

// Match Namespace elements by comparing both the name and the URI
rule MatchNamespaces
match l : Left!Namespace with r : Right!Namespace {
    compare : l.name.equals(r.name) and l.uri.equals(r.uri)
    do {
        System.out.println("Matched Namespace: " + l.name);
    }
}

// Match Entities by their qualified name
rule MatchEntity
match l : Left!Statement with r : Right!Statement {
    compare : l.name.equals(r.name)
    do {
        System.out.println("Matched Entity: " + l.name);
    }
}
//
//// Match Activities by their qualified name
//rule MatchActivity
//match l : Left!Activity with r : Right!Activity {
//    compare : l.name.equals(r.name)
//    do {
//        System.out.println("Matched Activity: " + l.name);
//    }
//}
//
//// Match Agents by their qualified name
//rule MatchAgent
//match l : Left!Agent with r : Right!Agent {
//    compare : l.name.equals(r.name)
//    do {
//        System.out.println("Matched Agent: " + l.name);
//    }
//}
//
//// Match WasDerivedFrom relations by comparing the generated and used entities 
//rule MatchWasDerivedFrom
//match l : Left!WasDerivedFrom with r : Right!WasDerivedFrom {
//    compare : l.generatedEntity.equals(r.generatedEntity) and l.usedEntity.equals(r.usedEntity)
//    do {
//        System.out.println("Matched WasDerivedFrom relation");
//    }
//}
//
//// Match WasGeneratedBy relations by comparing the entity and the activity
//rule MatchWasGeneratedBy
//match l : Left!WasGeneratedBy with r : Right!WasGeneratedBy {
//    compare : l.entity.equals(r.entity) and l.activity.equals(r.activity)
//    do {
//        System.out.println("Matched WasGeneratedBy relation");
//    }
//}
//
//// Match Used relations by comparing the activity and entity
//rule MatchUsed
//match l : Left!Used with r : Right!Used {
//    compare : l.activity.equals(r.activity) and l.entity.equals(r.entity)
//    do {
//        System.out.println("Matched Used relation");
//    }
//}
//
//// Match WasAssociatedWith relations by comparing the activity and agent (and optionally plan if provided)
//rule MatchWasAssociatedWith
//match l : Left!WasAssociatedWith with r : Right!WasAssociatedWith {
//    compare : l.activity.equals(r.activity) and l.agent.equals(r.agent)
//    do {
//        System.out.println("Matched WasAssociatedWith relation");
//    }
//}
//
//// Match WasAttributedTo relations by comparing the entity and agent
//rule MatchWasAttributedTo
//match l : Left!WasAttributedTo with r : Right!WasAttributedTo {
//    compare : l.entity.equals(r.entity) and l.agent.equals(r.agent)
//    do {
//        System.out.println("Matched WasAttributedTo relation");
//    }
//}
//
//// Match HadMember relations by comparing the collection and member
//rule MatchHadMember
//match l : Left!HadMember with r : Right!HadMember {
//    compare : l.collection.equals(r.collection) and l.member.equals(r.member)
//    do {
//        System.out.println("Matched HadMember relation");
//    }
//}
//
//// Match Attributes by comparing both the label and value
//rule MatchAttribute
//match l : Left!Attribute with r : Right!Attribute {
//    compare : l.label.equals(r.label) and l.value.equals(r.value)
//    do {
//        System.out.println("Matched Attribute: " + l.label);
//    }
//}
