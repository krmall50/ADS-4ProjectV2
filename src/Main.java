//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addVertex(new Vertex(100));
        graph.addVertex(new Vertex(208));
        graph.addVertex(new Vertex(803));
        graph.addVertex(new Vertex(401));
        graph.addEdge(5, 2, 1);
        graph.addEdge(2, 6, 2);
        graph.addEdge(2, 8, 3);
        graph.addEdge(8, 1, 1);
        graph.addEdge(6, 8, 4);
        Search BFS = new BreadthFirstSearch();
        BFS.search(graph, 5, 8);
        System.out.println(BFS.getPath());

    }
}