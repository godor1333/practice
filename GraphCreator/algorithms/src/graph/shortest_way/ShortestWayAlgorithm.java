package graph.shortest_way;

import graph.data_structures.Digraph;
import graph.data_structures.DirectedEdge;

import java.util.List;

public interface ShortestWayAlgorithm {
    List<MementoShortestWay> buildWay(Digraph G, int source, int target);

    boolean hasPathTo(int v);

    Iterable<DirectedEdge> pathTo(int v);
}
