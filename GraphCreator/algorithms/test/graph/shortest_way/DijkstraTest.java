package graph.shortest_way;

import graph.data_structures.Digraph;
import graph.data_structures.DirectedEdge;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.*;

public class DijkstraTest {

    @org.junit.Test
    public void buildWay() {
        String expectedFirstStep = "MementoShortestWay{currentVertex=-1, processedVertices=[false, false, false, false, false, false], currentWays=[null, null, null, null, null, null], inQueueVertices=[Entry{key=0.0, value=0}], log=[Начальное состояние алгоритма. В очереди только одна вершина: %s, 0]}";
        String expectedLastStep = "MementoShortestWay{currentVertex=-1, processedVertices=[true, true, true, true, true, true], currentWays=[null, DirectedEdge{source=0, target=1, weight=1.0}, DirectedEdge{source=0, target=2, weight=7.0}, DirectedEdge{source=1, target=3, weight=9.0}, DirectedEdge{source=2, target=4, weight=4.0}, DirectedEdge{source=4, target=5, weight=3.0}], inQueueVertices=[], log=[Обаботка вершины %s была закончена, 5]}";
        Digraph digraph = new Digraph(6);
        digraph.addEdge(new DirectedEdge(0,1,1));
        digraph.addEdge(new DirectedEdge(0,2,7));
        digraph.addEdge(new DirectedEdge(1,3,9));
        digraph.addEdge(new DirectedEdge(1,5,15));
        digraph.addEdge(new DirectedEdge(2,4,4));
        digraph.addEdge(new DirectedEdge(3,4,10));
        digraph.addEdge(new DirectedEdge(3,5,5));
        digraph.addEdge(new DirectedEdge(4,5,3));
        Dijkstra dijkstra =new Dijkstra();
        List<MementoShortestWay> steps = dijkstra.buildWay(digraph,0,5);


        assertEquals(expectedFirstStep, steps.get(0).toString());
        assertEquals(expectedLastStep, steps.get(steps.size() - 1).toString());
    }
}