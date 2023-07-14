import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    private List<List<Integer>> adjacencyList;
    private int numVertices;

    public AdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src); // For an undirected graph
    }

    public void displayList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices
        int numVertices = 5;
        AdjacencyList graph = new AdjacencyList(numVertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        // Display the adjacency list
        graph.displayList();
    }
}