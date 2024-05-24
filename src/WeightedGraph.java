import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph {
    private Map<Integer, Vertex> vertices;
    public WeightedGraph(){
        this.vertices = new HashMap<>();
    }
    public void addVertex(Vertex vertex){
        vertices.put(vertex.getData().hashCode(), vertex);
    }
    public void addEdge(int source, int destination, double weight){
        if (!vertices.containsKey(source)) {
            addVertex(new Vertex(source));
        }
        if (!vertices.containsKey(destination)) {
            addVertex(new Vertex(destination));
        }
        vertices.get(source).addAdjVertex(destination, weight);
    }
    public Vertex getVertex(Integer key) {
        return vertices.get(key);
    }

    public Set<Integer> getAllVertices() {
        return vertices.keySet();
    }
}
