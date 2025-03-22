import os
import re
import json
from typing import Dict, List, Set
import argparse

def read_emodl(file_path: str) -> str:
    with open(file_path, 'r') as file:
        return file.read()

def read_clusters(file_path: str) -> Dict[str, list]:
    with open(file_path, 'r') as file:
        return json.load(file)
    
def read_provn(file_path: str) -> List[str]:
    with open(file_path, 'r') as file:
        return file.readlines()

def find_collection_name(lines: List[str]):
    collection = None
    for line in lines: 
        match = re.search(r'hadMember\([^:]+:([^,\)]+),', line)
        if match:
            collection = match.group(1)
            return collection

def write_provn(cluster_name: str, lines: List[str], output_dir: str, parameters):
    os.makedirs(output_dir, exist_ok=True)
    output_path = os.path.join(output_dir, f"{cluster_name}.provn")
    header = "document\n\nprefix epi <http://www.cs.rpi.edu/~hendler/>\nprefix prov <http://www.prov.org>\n\n"
    footer = "\nendDocument"
    original_collection = find_collection_name(lines)
    
        
    with open(output_path, 'w') as file:
        file.write(header)
        
        file.write(f'entity(prov:{cluster_name}, [prov:type = "prov:Collection", prov:label = "Fragment {cluster_name}"])\n')
        file.write('agent(prov:GEODES_Epimodel, [prov:label = "GEODES Epimodel" %% xsd:string])\n')
        file.write('activity(prov:Slicing)\n')
        file.write(f'used(prov:Slicing, prov:{original_collection}, 2025-02-07T11:00:00)\n')
        file.write(f'wasGeneratedBy(prov:{cluster_name}, prov:Slicing, -)\n')
        file.write(f'wasAssociatedWith(prov:Slicing, prov:GEODES_Epimodel, -)\n')
        for param in parameters:
            file.write(f'hadMember(prov:{cluster_name}, prov:{param})\n')
    
        file.writelines(lines)
        file.write(footer)

def write_emodl(cluster_name: str, content: str, output_dir: str):
    os.makedirs(output_dir, exist_ok=True)
    output_path = os.path.join(output_dir, f"{cluster_name}.emodl")
    header = f"(import (rnrs) (emodl cmslib))\n\n(start-model \"{cluster_name}\")\n\n"
    footer = "\n\n(end-model)"
    with open(output_path, 'w') as file:
        file.write(header + content + footer)

def extract_related_lines(lines: List[str], cluster_keywords: List[str]) -> List[str]:
    return [line for line in lines if any(keyword in line for keyword in cluster_keywords)]

def get_species_in_reactions(reactions: List[str]) -> List[str]:
    species = set()
    for reaction in reactions:
        matches = re.findall(r"\b(?:species|->|\w+)\b", reaction)
        species.update(matches)
    return list(species)

def split_emodl(file_path: str, cluster_file: str, output_dir: str):
    emodl_content = read_emodl(file_path)
    clusters = read_clusters(cluster_file)

    lines = emodl_content.splitlines()

    params = [line for line in lines if line.startswith("(param")]
    species = [line for line in lines if line.startswith("(species")]
    reactions = [line for line in lines if line.startswith("(reaction")]
    observes = [line for line in lines if line.startswith("(observe")]

    cluster_content = {key: "" for key in clusters.keys()}

    for cluster_name, keywords in clusters.items():
        cluster_params = extract_related_lines(params, keywords)
        cluster_reactions = extract_related_lines(reactions, keywords)
        reaction_species = get_species_in_reactions(cluster_reactions)
        cluster_species = [line for line in species if any(spec in line for spec in reaction_species)]
        cluster_observes = [line for line in observes if any(spec in line for spec in reaction_species)]
        cluster_content[cluster_name] = "\n".join(
            cluster_params + cluster_species + cluster_reactions + cluster_observes
        )

    for cluster_name, content in cluster_content.items():
        if content.strip():
            write_emodl(cluster_name, content, output_dir)

def strip_namespace(name: str) -> str:
    return name.split(":")[-1]  # Remove namespace prefix
    
def find_entity_definition(entity_name: str, provn_lines: List[str]) -> List[str]:
    entity_definitions = []
    associated_agent = None
    
    for line in provn_lines:
        if re.search(rf'\bentity\([^:]+:{re.escape(entity_name)}', line):
            entity_definitions.append(line)
        elif re.search(rf'\bwasAttributedTo\([^:]+:{re.escape(entity_name)},\s*([^,\)]+)', line):
            entity_definitions.append(line)
            match = re.search(rf'\bwasAttributedTo\([^:]+:{re.escape(entity_name)},\s*([^,\)]+)', line)
            if match:
                associated_agent = strip_namespace(match.group(1))
    
    if associated_agent:
        for line in provn_lines:
            if re.search(rf'\bagent\([^:]+:{re.escape(associated_agent)}', line):
                entity_definitions.append(line)
                break
    
    return entity_definitions


def extract_related_lines_provn(provn_lines: List[str], entity_names: Set[str]) -> List[str]:
    related_lines = []
    queue = list(entity_names)  # Entities to process
    seen = set()  # Track already processed entities
    
    while queue:
        current_entity = strip_namespace(queue.pop(0))
        
        if current_entity in seen:
            continue
        seen.add(current_entity)
        
        for line in provn_lines:
            if re.search(rf'\b{re.escape(current_entity)}\b', line):
                if line not in related_lines:
                    related_lines.append(line)
                    derivation_match = re.search(r'wasDerivedFrom\([^:]+:([^,\)]+),\s*[^:]+:([^,\)]+)\)', line)

                    if derivation_match:
                        entity1, entity2 = derivation_match.groups()
                        if entity2 not in seen:
                            queue.append(entity2)
                    
                    attribution_match = re.search(r'wasAttributedTo\([^:]+:([^,\)]+),\s*[^:]+:([^,\)]+)\)', line)

                    if attribution_match:
                        entity1, entity2 = attribution_match.groups()
                        queue.append(entity2)
                    
                    specialization_match = re.search(r'specializationOf\([^,]+,\s*[^:]+:([^,\)]+)\)', line)

                    if specialization_match:
                        entity = specialization_match.group(1)
                        if entity not in seen:
                            queue.append(entity)
                    
                    had_member_matches = re.findall(r'\bhadMember\([^:]+:([^,\)]+)', line)
                    for member in had_member_matches:
                        stripped_member = strip_namespace(member)
                        
                        # Find and add the entity definition for the matched hadMember
                        entity_definitions = find_entity_definition(stripped_member, provn_lines)
                        for entity_def in entity_definitions:
                            if entity_def not in related_lines:
                                related_lines.append(entity_def)
                        
                    matches = re.findall(r'\bentity\([^:]+:([^,\[\)]+)', line) + \
                              re.findall(r'\bagent\(([^,\)]+)', line) + \
                              re.findall(r'\bactivity\(([^,\)]+)', line) + \
                              re.findall(r'\bspecializationOf\(([^,\)]+)', line)
                                    
                    for match in matches:
                        if isinstance(match, tuple):
                            derived_entity, origin_entity = match
                            for entity in (derived_entity, origin_entity):
                                stripped_entity = strip_namespace(entity)
                                if stripped_entity not in seen:
                                    queue.append(stripped_entity)
                        else:
                            stripped_entity = strip_namespace(match)
                            if stripped_entity not in seen:
                                queue.append(stripped_entity)
    
    return related_lines



def split_provn(file_path: str, cluster_file: str, output_dir: str):
    provn_lines = read_provn(file_path)
    clusters = read_clusters(cluster_file)

    for cluster_name, entity_names in clusters.items():
        cluster_lines = extract_related_lines_provn(provn_lines, entity_names)
        if cluster_lines:
            write_provn(cluster_name, cluster_lines, output_dir, entity_names)
            print(f"Cluster '{cluster_name}' written to {output_dir}")
    
if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Decompose EMODL and PROV-N files into clusters.")
    parser.add_argument("--emodl_file", required=True, help="Path to the input EMODL file")
    parser.add_argument("--provn_file", required=True, help="Path to the input PROV-N file")
    parser.add_argument("--cluster_file", required=True, help="Path to the cluster definition JSON file")
    args = parser.parse_args()

    input_emodl_file = args.emodl_file
    input_provn_file = args.provn_file
    cluster_file = args.cluster_file
    base_directory = os.path.dirname(input_emodl_file)

    output_directory_emodl = os.path.join(base_directory, "output_clusters")
    output_directory_provn = os.path.join(base_directory, "output_provn")
    os.makedirs(output_directory_emodl, exist_ok=True)
    os.makedirs(output_directory_provn, exist_ok=True)

    split_emodl(input_emodl_file, cluster_file, output_directory_emodl)
    split_provn(input_provn_file, cluster_file, output_directory_provn)
    print(f"Clusters written to {output_directory_emodl} and {output_directory_provn}")