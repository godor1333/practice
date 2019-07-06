package model.graph;

public class DirectedEdge {
    private final int source;
    private final int target;
    private final double weight;

    public DirectedEdge(int source, int target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public int getTo() {
        return target;
    }

    public int getFrom() {
        return source;
    }

    public double getWeight() {
        return weight;
    }
}
