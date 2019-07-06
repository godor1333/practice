package shortest.way;

import model.graph.DirectedEdge;

public interface ShortestWayAlgorithm {
    boolean hasPathTo(int v);

    Iterable<DirectedEdge> pathTo(int v);
}
