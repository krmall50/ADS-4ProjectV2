import java.util.*;
public class Vertex<V> {
    private V data;
    private Map<Integer, Double> adjVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void addAdjVertex(Integer destination, double weight) {
        adjVertices.put(destination, weight);
    }

    public Map<Integer, Double> getAdjVertices() {
        return adjVertices;
    }
}