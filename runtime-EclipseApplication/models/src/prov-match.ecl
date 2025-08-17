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