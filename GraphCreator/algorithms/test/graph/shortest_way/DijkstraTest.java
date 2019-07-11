package graph.shortest_way;

import graph.data_structures.Digraph;
import graph.data_structures.DirectedEdge;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DijkstraTest {

    @org.junit.Test
    public void testThatPathHasToIsTrueIfPathReallyExistOnDirectWay() {
        Digraph digraph = new Digraph(2);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,1,10));
        dijkstra.buildWay(digraph, 0, 1);
        final boolean hasPathTo = dijkstra.hasPathTo(1);
        assertThat(hasPathTo, is(true));
    }

    @org.junit.Test
    public void testThatPathIsCorrectOnDirectWay() {
        Digraph digraph = new Digraph(2);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,1,10));
        dijkstra.buildWay(digraph, 0, 1);
        int size = 0;
        for (DirectedEdge ignored : dijkstra.pathTo(1)) {
            ++size;
        }
        assertThat(size, is(1));
    }

    @org.junit.Test
    public void testThatPathToIsEmptyIfPathDoesNotExist() {
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,1,1));
        dijkstra.buildWay(digraph, 0, 2);
        assertNull( dijkstra.pathTo(2));
    }

    @org.junit.Test
    public void testThatPathHasToIsFalseIfPathDoesNotExistOnDirectWay() {
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,1,10));
        dijkstra.buildWay(digraph, 0, 1);
        final boolean hasPathTo = dijkstra.hasPathTo(2);
        assertThat(hasPathTo, is(false));
    }

    @org.junit.Test
    public void testThatPathHasToIsTrueIfPathReallyExistOnComplexWay() {
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,1,10));
        digraph.addEdge(new DirectedEdge(1,2,10));
        dijkstra.buildWay(digraph, 0, 2);
        final boolean hasPathTo = dijkstra.hasPathTo(2);
        assertThat(hasPathTo, is(true));
    }

    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThatPathHasToIsThrowExceptionIfVertexDoesNotExist() {
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,1,10));
        digraph.addEdge(new DirectedEdge(1,2,10));
        dijkstra.buildWay(digraph, 0, 2);
        dijkstra.hasPathTo(3);
    }

    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThatWeTryToFindPathOnEmptyGraph() {
        Digraph digraph = new Digraph(0);
        final Dijkstra dijkstra = new Dijkstra();
        dijkstra.buildWay(digraph, 0, 0);
    }

    @org.junit.Test
    public void testThatWeTryToFindPathOnGraphWithAloneVertex() {
        final String expectedLastStep = "MementoShortestWay{currentVertex=-1, processedVertices=[true], currentWays=[null], inQueueVertices=[], log=[Обаботка вершины %s была закончена, 0]}";
        Digraph digraph = new Digraph(1);
        final Dijkstra dijkstra = new Dijkstra();
        final List<MementoShortestWay> mementoShortestWays = dijkstra.buildWay(digraph, 0, 0);
        final boolean hasPathTo = dijkstra.hasPathTo(0);
        assertThat(hasPathTo, is(true));
        int size = 0;
        for (DirectedEdge ignored : dijkstra.pathTo(0)) {
            ++size;
        }
        assertThat(size, is(0));
        assertThat(mementoShortestWays.size(), is(3));
        assertThat(mementoShortestWays.get(2).toString(), is(expectedLastStep));
    }

    @org.junit.Test
    public void testThatWeTryToFindPathOnSimpleGraphWithDirectWay() {
        final String expectedLastStep = "MementoShortestWay{currentVertex=-1, processedVertices=[true, true], currentWays=[null, DirectedEdge{source=0, target=1, weight=1.0}], inQueueVertices=[], log=[Обаботка вершины %s была закончена, 1]}";
        Digraph digraph = new Digraph(2);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,1,1));
        final List<MementoShortestWay> mementoShortestWays = dijkstra.buildWay(digraph, 0, 1);
        final boolean hasPathTo = dijkstra.hasPathTo(1);
        assertThat(hasPathTo, is(true));
        int size = 0;
        for (DirectedEdge ignored : dijkstra.pathTo(1)) {
            ++size;
        }
        assertThat(size, is(1));
        assertThat(mementoShortestWays.size(), is(6));
        assertThat(mementoShortestWays.get(5).toString(), is(expectedLastStep));
    }

    @org.junit.Test
    public void testThatWeTryToFindPathOnSimpleGraph() {
        final String expectedLastStep = "MementoShortestWay{currentVertex=-1, processedVertices=[true, true, true], currentWays=[null, DirectedEdge{source=0, target=1, weight=1.0}, DirectedEdge{source=1, target=2, weight=1.0}], inQueueVertices=[], log=[Обаботка вершины %s была закончена, 2]}";
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,2,10));
        digraph.addEdge(new DirectedEdge(0,1,1));
        digraph.addEdge(new DirectedEdge(1,2,1));
        final List<MementoShortestWay> mementoShortestWays = dijkstra.buildWay(digraph, 0, 2);
        final boolean hasPathTo = dijkstra.hasPathTo(2);
        assertThat(hasPathTo, is(true));
        int size = 0;
        for (DirectedEdge ignored : dijkstra.pathTo(2)) {
            ++size;
        }
        assertThat(size, is(2));
        assertThat(mementoShortestWays.size(), is(10));
        assertThat(mementoShortestWays.get(9).toString(), is(expectedLastStep));
    }

    @org.junit.Test
    public void testThatWeTryToFindPathOnSimpleGraphWithDirectWayButWhenExistMoreComplexWay() {
        final String expectedLastStep = "MementoShortestWay{currentVertex=-1, processedVertices=[true, true, true], currentWays=[null, DirectedEdge{source=0, target=1, weight=2.0}, DirectedEdge{source=0, target=2, weight=1.0}], inQueueVertices=[], log=[Обаботка вершины %s была закончена, 1]}";
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,2,1));
        digraph.addEdge(new DirectedEdge(0,1,2));
        digraph.addEdge(new DirectedEdge(1,2,3));
        final List<MementoShortestWay> mementoShortestWays = dijkstra.buildWay(digraph, 0, 2);
        final boolean hasPathTo = dijkstra.hasPathTo(2);
        assertThat(hasPathTo, is(true));
        int size = 0;
        for (DirectedEdge ignored : dijkstra.pathTo(2)) {
            ++size;
        }
        assertThat(size, is(1));
        assertThat(mementoShortestWays.size(), is(9));
        assertThat(mementoShortestWays.get(8).toString(), is(expectedLastStep));
    }

    @org.junit.Test
    public void testThatWeTryToFindWayButItDoesNotExist() {
        final String expectedLastStep = "MementoShortestWay{currentVertex=-1, processedVertices=[true, false, false], currentWays=[null, null, null], inQueueVertices=[], log=[Обаботка вершины %s была закончена, 0]}";
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        final List<MementoShortestWay> mementoShortestWays = dijkstra.buildWay(digraph, 0, 2);
        final boolean hasPathTo = dijkstra.hasPathTo(2);
        assertThat(hasPathTo, is(false));
        assertNull(dijkstra.pathTo(2));
        assertThat(mementoShortestWays.size(), is(3));
        assertThat(mementoShortestWays.get(2).toString(), is(expectedLastStep));
    }

    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThatWeTryToFindWayToVertexWhichDoesNotExist() {
        Digraph digraph = new Digraph(3);
        final Dijkstra dijkstra = new Dijkstra();
        digraph.addEdge(new DirectedEdge(0,2,1));
        digraph.addEdge(new DirectedEdge(0,1,2));
        digraph.addEdge(new DirectedEdge(1,2,3));
        dijkstra.buildWay(digraph, 0, 5);
        dijkstra.hasPathTo(5);
    }

    @org.junit.Test
    public void testThatWeTryToFindWayOnMoreComplexGraph() {
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
        dijkstra.hasPathTo(5);
        int size = 0;
        for (DirectedEdge ignored : dijkstra.pathTo(5)) {
            ++size;
        }
        assertThat(size, is(3));

        assertEquals(expectedFirstStep, steps.get(0).toString());
        assertEquals(expectedLastStep, steps.get(steps.size() - 1).toString());
    }
}