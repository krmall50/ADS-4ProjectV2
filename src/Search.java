import java.util.List;

public interface Search {
    void search(WeightedGraph graph, int source, int destination);
    List<Integer> getPath();
}
