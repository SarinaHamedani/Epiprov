import os
from typing import List

def read_emodl(file_path: str) -> str:
    with open(file_path, 'r') as file:
        return file.read()

def write_emodl(file_path: str, content: str):
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
        fragment_content = read_emodl(fragment_path)
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
    write_emodl(output_file, combined_content)


def get_emodl_files(directory):
    return [os.path.join(directory, f) for f in os.listdir(directory) if f.endswith(".emodl")]

if __name__ == "__main__":
    input_directory = "output_clusters"
    fragment_files = get_emodl_files(input_directory)
    output_file_path = "combined_model.emodl"

    combine_emodl_fragments(fragment_files, output_file_path)

    print(f"Combined model written to {output_file_path}")
