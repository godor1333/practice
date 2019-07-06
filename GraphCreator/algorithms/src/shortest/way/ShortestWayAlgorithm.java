package shortest.way;

import model.graph.Digraph;
import model.graph.DirectedEdge;

import java.util.List;

public interface ShortestWayAlgorithm {
    boolean hasPathTo(int v);

    Iterable<DirectedEdge> pathTo(int v);

    List<MementoShortestWay> buildWay(Digraph G, int source, int target);
}
