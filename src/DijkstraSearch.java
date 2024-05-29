import java.util.*;

public class DijkstraSearch implements Search {
    private List<Integer> path;
    private Map<Integer, Double> distances;
    private Map<Integer, Integer> predecessors;
    private PriorityQueue<Integer> priorityQ;
    private Set<Integer> visited;

    @Override
    public void search(WeightedGraph graph, int source, int destination) {
        path = new ArrayList<>();
        distances = new HashMap<>();
        predecessors = new HashMap<>();
        visited = new HashSet<>();

        for (Integer vertex : graph.getAllVertices()) { // Initializing distances and predecessors
            distances.put(vertex, Double.POSITIVE_INFINITY);
            predecessors.put(vertex, null);
        }

        distances.put(source, 0.0);// distance of source node

        priorityQ = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        priorityQ.offer(source);

        while (!priorityQ.isEmpty()) {
            Integer current = priorityQ.poll();

            if (visited.contains(current)) {// Skip if the node is visited
                continue;
            }

            visited.add(current);

            if (current.equals(destination)) {
                buildPath(destination);
                return;
            }

            for (Map.Entry<Integer, Double> neighbor : graph.getVertex(current).getAdjVertices().entrySet()) {
                Integer neighborKey = neighbor.getKey();
                Double edgeWeight = neighbor.getValue();

                if (visited.contains(neighborKey)) {
                    continue;
                }

                Double tentativeDistance = distances.get(current) + edgeWeight;

                if (tentativeDistance < distances.get(neighborKey)) {
                    distances.put(neighborKey, tentativeDistance);
                    predecessors.put(neighborKey, current);
                    priorityQ.remove(neighborKey);
                    priorityQ.offer(neighborKey);
                }
            }
        }
    }

    private void buildPath(Integer destination) {
        Integer current = destination;
        while (current != null) {
            path.add(0, current);
            current = predecessors.get(current);
        }
    }

    @Override
    public List<Integer> getPath() {
        return path;
    }
}
