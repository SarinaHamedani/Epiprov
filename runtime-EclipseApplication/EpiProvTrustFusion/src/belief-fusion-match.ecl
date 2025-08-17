// Match UncertainElements based on their name
rule MatchUncertainElements
match l : Left!UncertainElement 
with r : Right!UncertainElement {
    compare : l.name.equalsIgnoreCase(r.name)
    do {
        System.out.println("Matched UncertainElement: " + l.name + " and " + r.name);
    }
}

// Match Agents by their name
rule MatchAgents
match l : Left!Agent
with r : Right!Agent {
    compare : l.name.equalsIgnoreCase(r.name)
    do {
        System.out.println("Matched Agent: " + l.name + " and " + r.name);
    }
}

// Match Beliefs based on their name and associated agent
rule MatchBeliefs
match l : Left!Belief 
with r : Right!Belief {
    compare : l.name.equalsIgnoreCase(r.name) and l.agent.name.equalsIgnoreCase(r.agent.name)
    do {
        System.out.println("Matched Belief: " + l.name + " (Agent: " + l.agent.name + ")");
    }
}


rule MatchTrustModels
match l : Left!TrustModel
with r : Right!TrustModel {
    compare : true
}