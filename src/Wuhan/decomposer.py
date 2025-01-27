import os
import re
import json
from typing import Dict, List

def read_emodl(file_path: str) -> str:
    with open(file_path, 'r') as file:
        return file.read()

def read_clusters(file_path: str) -> Dict[str, list]:
    with open(file_path, 'r') as file:
        return json.load(file)

def write_emodl(cluster_name: str, content: str, output_dir: str):
    os.makedirs(output_dir, exist_ok=True)
    output_path = os.path.join(output_dir, f"{cluster_name}.emodl")
    header = "(import (rnrs) (emodl cmslib))\n\n(start-model \"{cluster_name}\")\n\n".replace("{cluster_name}", cluster_name)
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

    # Split content into blocks
    lines = emodl_content.splitlines()

    # Separate sections of emodl
    params = [line for line in lines if line.startswith("(param")]
    species = [line for line in lines if line.startswith("(species")]
    reactions = [line for line in lines if line.startswith("(reaction")]
    observes = [line for line in lines if line.startswith("(observe")]

    # Initialize content holders for each cluster
    cluster_content = {key: "" for key in clusters.keys()}

    for cluster_name, keywords in clusters.items():
        # Extract relevant params
        cluster_params = extract_related_lines(params, keywords)

        # Extract relevant reactions
        cluster_reactions = extract_related_lines(reactions, keywords)

        # Extract relevant species from reactions
        reaction_species = get_species_in_reactions(cluster_reactions)
        cluster_species = [line for line in species if any(spec in line for spec in reaction_species)]

        # Extract relevant observes
        cluster_observes = [line for line in observes if any(spec in line for spec in reaction_species)]

        # Combine content for this cluster
        cluster_content[cluster_name] = "\n".join(
            cluster_params + cluster_species + cluster_reactions + cluster_observes
        )

    # Write separate files for each cluster
    for cluster_name, content in cluster_content.items():
        if content.strip():  # Avoid writing empty files
            write_emodl(cluster_name, content, output_dir)

if __name__ == "__main__":
    input_file = "ontario.emodl"  # Replace with the path to your .emodl file
    cluster_file = "clusters.json"  # Replace with the path to your clusters file
    output_directory = "output_clusters"  # Directory to save the split .emodl files

    split_emodl(input_file, cluster_file, output_directory)
    print(f"Clusters written to {output_directory}")
