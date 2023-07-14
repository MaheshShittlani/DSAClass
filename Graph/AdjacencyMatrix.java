import java.util.Arrays;

public class AdjacencyMatrix {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest) {
        // For an undirected graph, set both positions as 1
        adjacencyMatrix[src][dest] = 1;
        adjacencyMatrix[dest][src] = 1;
    }

    public void displayMatrix() {
        for (int[] row : adjacencyMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices
        int numVertices = 5;
        AdjacencyMatrix graph = new AdjacencyMatrix(numVertices);

        // Add edges to the graph
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);


        // Display the adjacency matrix
        graph.displayMatrix();
    }
}
