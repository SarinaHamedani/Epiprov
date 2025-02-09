import os
import re
from typing import List

def read_file(file_path: str) -> str:
    with open(file_path, 'r') as file:
        return file.read()

def write_file(file_path: str, content: str):
    with open(file_path, 'w') as file:
        file.write(content)

def combine_emodl_fragments(fragment_paths: List[str], output_file: str):
    species_set = set()
    params_set = set()
    reactions_set = set()
    observes_set = set()

    # Add header to the combined file
    combined_content = "(import (rnrs) (emodl cmslib))\n\n(start-model \"Combined_Model\")\n\n"

    for fragment_path in fragment_paths:
        fragment_content = read_file(fragment_path)
        lines = fragment_content.splitlines()

        for line in lines:
            # Categorize lines into species, params, reactions, and observes
            if line.startswith("(species"):
                species_set.add(line.strip())
            elif line.startswith("(param"):
                params_set.add(line.strip())
            elif line.startswith("(reaction"):
                reactions_set.add(line.strip())
            elif line.startswith("(observe"):
                observes_set.add(line.strip())

    # Add sections to the combined content
    combined_content += "\n".join(sorted(species_set)) + "\n\n"
    combined_content += "\n".join(sorted(params_set)) + "\n\n"
    combined_content += "\n".join(sorted(reactions_set)) + "\n\n"
    combined_content += "\n".join(sorted(observes_set)) + "\n\n"

    # Add footer to the combined file
    combined_content += "(end-model)"

    # Write the combined content to the output file
    write_file(output_file, combined_content)

def get_emodl_files(directory):
    return [os.path.join(directory, f) for f in os.listdir(directory) if f.endswith(".emodl")]

def get_provn_files(directory):
    return [os.path.join(directory, f) for f in os.listdir(directory) if f.endswith(".provn")]

def extract_collection_names(fragment_paths: List[str]) -> List[str]:
    collection_names = []
    pattern = re.compile(r'entity\(provbook:([^,]+),\s*\[prov:type = "prov:Collection",\s*prov:label = "Fragment ([^\]]+)"')
    
    for fragment_path in fragment_paths:
        fragment_content = read_file(fragment_path)
        matches = pattern.findall(fragment_content)
        for match in matches:
            collection_names.append(match[0])  # Extract the collection name
    
    return collection_names

def combine_provn_fragments(fragment_paths: List[str], output_file: str):
    unique_lines = set()
    header_lines = set()
    footer_lines = set()
    header_keywords = {"document", "prefix epi", "prefix provbook"}
    footer_keywords = {"endDocument"}
    fragment_names = extract_collection_names(fragment_paths)
    
    for fragment_path in fragment_paths:
        fragment_content = read_file(fragment_path)
        lines = fragment_content.splitlines()
        for line in lines:
            stripped_line = line.strip()
            if any(stripped_line.startswith(keyword) for keyword in header_keywords):
                header_lines.add(stripped_line)
            elif any(stripped_line.startswith(keyword) for keyword in footer_keywords):
                footer_lines.add(stripped_line)
            else:
                unique_lines.add(stripped_line)
                
    sorted_header = sorted(header_lines, key=lambda x: ("document" not in x, x))
    combined_content = "\n".join(sorted_header) + "\n\n"
    
    combined_content += "\n\nentity(provbook:combined_model, [prov:type = \"prov:Entity\", prov:label = \"Combined Model\"])\n"
    combined_content += "activity(provbook:Merge)\n"
    combined_content += "agent(provbook:GEODES_Epimodel)\n"
    combined_content += "wasGeneratedBy(provbook:combined_model, provbook:Merge, -)\n"
    combined_content += "wasAssociatedWith(provbook:Merge, provbook:GEODES_Epimodel, -)\n"
    
    for fragment in fragment_names:
        combined_content += f"used(provbook:Merge, provbook:{fragment}, -)\n"
    
    combined_content += "\n\n" + "\n".join(sorted(unique_lines)) + "\n\n" + "\n".join(footer_lines)
    write_file(output_file, combined_content)

if __name__ == "__main__":
    input_emodl_directory = "output_clusters"
    input_provn_directory = "output_provn"
    output_directory = "combined_output"
    os.makedirs(output_directory, exist_ok=True)

    fragment_emodl_files = get_emodl_files(input_emodl_directory)
    output_emodl_file_path = os.path.join(output_directory, "combined_model.emodl")
    combine_emodl_fragments(fragment_emodl_files, output_emodl_file_path)
    print(f"Combined EMODL model written to {output_emodl_file_path}")

    fragment_provn_files = get_provn_files(input_provn_directory)
    output_provn_file_path = os.path.join(output_directory, "combined_provn.provn")
    combine_provn_fragments(fragment_provn_files, output_provn_file_path)
    print(f"Combined PROV-N model written to {output_provn_file_path}")
