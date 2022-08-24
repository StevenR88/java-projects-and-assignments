package ca.bcit.comp3760.lab07;

public class Lab07 {

    /**
     * Creates a 5x5 ascendancy matrix for Graph 1.
     * @param newGraph as a Graph object
     */
    private static void create5x5Graph1(final Graph newGraph) {
        newGraph.addEdge(0, 1);
        newGraph.addEdge(0, 3);
        newGraph.addEdge(0, 4);
        newGraph.addEdge(1, 2);
        newGraph.addEdge(1, 4);
        newGraph.addEdge(2, 3);
        newGraph.addEdge(3, 4);
    }

    /**
     * Creates a 4x4 ascendancy matrix for Graph 2.
     * @param newGraph as a Graph object
     */
    private static void create4x4Graph2(final Graph newGraph) {
        newGraph.addEdge(0, 1);
        newGraph.addEdge(1, 2);
        newGraph.addEdge(2, 3);
    }

    /**
     * Creates a 6x6 ascendancy matrix for Graph 3.
     * @param newGraph as a Graph object
     */
    private static void create6x6Graph3(final Graph newGraph) {
        newGraph.addEdge(0, 2);
        newGraph.addEdge(0, 4);
        newGraph.addEdge(1, 3);
        newGraph.addEdge(1, 5);
        newGraph.addEdge(2, 4);
        newGraph.addEdge(3, 5);
    }

    /**
     * Creates a 5x5 ascendancy matrix for Graph 4.
     * @param newGraph as a Graph object
     */
    private static void create5x5Graph4(final Graph newGraph) {
        newGraph.addEdge(0, 0);
        newGraph.addEdge(0, 4);
        newGraph.addEdge(1, 2);
        newGraph.addEdge(1, 4);
        newGraph.addEdge(2, 0);
        newGraph.addEdge(2, 3);
        newGraph.addEdge(3, 1);
        newGraph.addEdge(3, 2);
        newGraph.addEdge(4, 3);
    }

    /**
     * Creates a 8x8 ascendancy matrix for Graph 5.
     * @param newGraph as a Graph object
     */
    private static void create8x8Graph5(final Graph newGraph) {
        newGraph.addEdge(0, 1);
        newGraph.addEdge(0, 2);
        newGraph.addEdge(0, 4);
        newGraph.addEdge(1, 3);
        newGraph.addEdge(1, 5);
        newGraph.addEdge(2, 3);
        newGraph.addEdge(2, 6);
        newGraph.addEdge(3, 7);
        newGraph.addEdge(4, 0);
        newGraph.addEdge(4, 5);
        newGraph.addEdge(4, 6);
        newGraph.addEdge(5, 7);
        newGraph.addEdge(6, 7);
    }

    /**
     * Main method.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        System.out.println("------------ Part 2 ------------");

        Graph graph1 = new Graph(5);
        create5x5Graph1(graph1);
        System.out.println("Adjacency Matrix for Graph 1");
        System.out.println(graph1);

        Graph graph2 = new Graph(4);
        create4x4Graph2(graph2);
        System.out.println("Adjacency Matrix for Graph 2");
        System.out.println(graph2);

        Graph graph3 = new Graph(6);
        create6x6Graph3(graph3);
        System.out.println("Adjacency Matrix for Graph 3");
        System.out.println(graph3);

        System.out.println("------------ Part 3 ------------");

        System.out.println("Graph 1 --> Degree of vertex 0 = "
                + graph1.degree(0));
        System.out.println("Graph 1 --> Degree of vertex 4 = "
                + graph1.degree(4) + "\n");
        System.out.println("Graph 2 --> Degree of vertex 0 = "
                + graph2.degree(0));
        System.out.println("Graph 2 --> Degree of vertex 3 = "
                + graph2.degree(3) + "\n");
        System.out.println("Graph 3 --> Degree of vertex 0 = "
                + graph3.degree(0));
        System.out.println("Graph 3 --> Degree of vertex 5 = "
                + graph3.degree(5) + "\n");

        System.out.println("------------ Part 4 ------------");

        Graph graph4 = new Graph(5);
        graph4.setDirected(true);
        create5x5Graph4(graph4);
        System.out.println(graph4);
        System.out.println("In Degree of vertex 0 = " + graph4.inDegree(0));
        System.out.println("Out Degree of vertex 4 = " + graph4.outDegree(4));
        System.out.println();
        System.out.println("Invalid Degree Calls:");
        System.out.println("Graph 4 --> Degree of vertex 1 = "
                + graph4.degree(1));
        System.out.println("Graph 1 --> In Degree of vertex 2 = "
                + graph1.outDegree(2));
        System.out.println("Graph 2 --> Out Degree of vertex 3 = "
                + graph2.outDegree(3));
        System.out.println();

        System.out.println("------------ Part 5 ------------");

        Graph graph5 = new Graph(8);
        create8x8Graph5(graph5);
        System.out.println("Adjacency Matrix for Graph 5");
        System.out.println(graph5);
        System.out.println("Results of DFS Traversal:");
        graph5.dfs();
        System.out.println();

        System.out.println("------------ Part 6 ------------");

        System.out.println("Results of BFS Traversal:");
        graph5.bfs();
    }
}
