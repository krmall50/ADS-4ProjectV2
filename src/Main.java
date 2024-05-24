//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addVertex(new Vertex(100));
        graph.addVertex(new Vertex(208));
        graph.addVertex(new Vertex(803));
        graph.addVertex(new Vertex(401));
        System.out.println(graph.getVertex(803));
        System.out.println(graph.getAllVertices());

    }
}