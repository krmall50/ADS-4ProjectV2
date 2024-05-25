import java.util.*;

public class BreadthFirstSearch implements Search {
    private List<Integer> path;
    private Queue<Integer> queue;
    private Set<Integer> visited;
    private Map<Integer, Integer> parent;

    @Override
    public void search(WeightedGraph graph, int source, int destination) {
        path = new ArrayList<>();
        queue = new LinkedList<>();
        visited = new HashSet<>();
        parent = new HashMap<>();

        queue.offer(source);
        visited.add(source);
        parent.put(source, null); // null because source dont have parent

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (current.equals(destination)) {
                reconstructPath(destination);
                return;
            }

            for (Object neighbor : graph.getVertex(current).getAdjVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add((Integer) neighbor);
                    queue.offer((Integer) neighbor);
                    parent.put((Integer) neighbor, current);
                }
            }
        }
    }

    private void reconstructPath(int destination) {
        Integer step = destination;
        while (step != null) {
            path.add(0, step); // add to the start of the path
            step = parent.get(step);
        }
    }

    @Override
    public List<Integer> getPath() {
        return path;
    }
}
