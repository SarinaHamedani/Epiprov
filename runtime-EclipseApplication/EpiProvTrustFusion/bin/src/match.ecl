rule MatchModels
match l : Left!EModel with r : Right!EModel {
    compare : true
}


rule MatchImports
match l : Left!Import with r : Right!Import {
    compare : l.groups.equals(r.groups)
    do {
        System.out.println('Matched imports: ' + l.name + ' and ' + r.name);
    }
}

rule MatchSpecies
match l : Left!Species with r : Right!Species {
    compare : l.name.equals(r.name)
    do {
        System.out.println('Matched species: ' + l.name + ' and ' + r.name);
    }
}

rule MatchElements
match l : Left!Element with r : Right!Element {
    compare : l.name.equals(r.name)
    do {
        System.out.println('Matched elements: ' + l.name + ' and ' + r.name);
    }
}
