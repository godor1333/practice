import graph.data_structures.Digraph;
import graph.data_structures.DirectedEdge;
import graph.shortest_way.Dijkstra;
import graph.shortest_way.MementoShortestWay;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        for(MementoShortestWay step:steps){
            System.out.println(step);
        }
    }
}
