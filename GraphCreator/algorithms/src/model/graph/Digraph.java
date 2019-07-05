package model.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Digraph {
    private int vertexCount;
    private List<Set<DirectedEdge>> edges = new ArrayList<>();

    public Digraph(int vertexCount) {
        this.vertexCount = vertexCount;
        for (int vertexNumber = 0; vertexNumber < vertexCount; vertexNumber++) {
            this.edges.add(new LinkedHashSet<>());
        }
    }
}
