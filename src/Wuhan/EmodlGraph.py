from pyvis.network import Network
import networkx as nx
import re
import random

def parse_emodl(file_path):
    species = set()
    reactions = []

    with open(file_path, 'r') as file:
        lines = file.readlines()

    for line in lines:
        line = line.strip()
        if line.startswith("(species"):
            match = re.match(r"\(species\s+(\w+)", line)
            if match:
                species.add(match.group(1))
        elif line.startswith("(reaction"):
            match = re.match(r"\(reaction\s+(\w+)\s+(\w+)\s+->\s+(\w+)\s+\((.*)\)", line)
            if match:
                reaction_name = match.group(1)
                source = match.group(2)
                target = match.group(3)
                parameters = match.group(4)
                reactions.append((source, target, parameters.strip()))

    return species, reactions

def build_graph(species, reactions):
    """
    Build a directed graph from species and reactions.
    """
    G = nx.DiGraph()

    # Add nodes (compartments)
    for compartment in species:
        G.add_node(compartment)

    # Add edges (flows)
    for source, target, parameters in reactions:
        G.add_edge(source, target, label=parameters)

    return G

def generate_random_color():
    return f"#{random.randint(0, 255):02x}{random.randint(0, 255):02x}{random.randint(0, 255):02x}"

def visualize_graph_pyvis(G, output_file="graph.html"):
    net = Network(notebook=True, directed=True, height="800px", width="1000px", bgcolor="#222222", font_color="white")

    # Transfer nodes and edges from NetworkX graph to Pyvis Network
    net.from_nx(G)

    # Customize node properties
    for node in net.nodes:
        node["title"] = f"Compartment: {node['id']}"  # Hover tooltip
        node["label"] = node["id"]
        node["color"] = generate_random_color()  # Assign a random color
        node["size"] = 15  # Node size

    # Customize edge properties
    for edge in net.edges:
        edge["title"] = f"Parameter: {edge['label']}"  # Hover tooltip
        edge["color"] = "yellow"  # Edge color
        edge["width"] = 2  # Edge width

    # Generate and save the interactive visualization
    net.show_buttons(filter_=["physics"])  # Add control buttons for better interactivity
    net.show(output_file)

if __name__ == "__main__":
    emodl_file = "output_clusters/cluster_1.emodl"

    species, reactions = parse_emodl(emodl_file)

    graph = build_graph(species, reactions)

    visualize_graph_pyvis(graph, output_file="graph1.html")

    print("Interactive graph saved as graph.html")
