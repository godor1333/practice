package graph.data_structures;

import java.util.*;

public class Digraph {
    private int vertexCount;
    private List<Set<DirectedEdge>> edges = new ArrayList<>();

    public Digraph(int vertexCount) {
        this.vertexCount = vertexCount;
        for (int vertexNumber = 0; vertexNumber < vertexCount; vertexNumber++) {
            this.edges.add(new LinkedHashSet<>());
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void addEdge(DirectedEdge edge) {
        edges.get(edge.getFrom()).add(edge);
    }

    public Iterable<DirectedEdge> getEdgesForVertex(int vertex) {
        return edges.get(vertex);
    }
}
