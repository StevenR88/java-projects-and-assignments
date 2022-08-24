package ca.bcit.comp3760.lab07;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private final int[][] adjacencyMatrix;
    private boolean directed;

    /**
     * Instantiates a new Graph.
     *
     * @param V as an int
     */
    public Graph(int V) {
        adjacencyMatrix = new int[V][V];
        directed = false;
    }

    /**
     * Add edge to graph.
     *
     * @param u as an int
     * @param v as an int
     */
    public void addEdge(int u, int v) {
        if (this.directed) {
            adjacencyMatrix[u][v] = 1;
        } else {
            adjacencyMatrix[u][v] = 1;
            adjacencyMatrix[v][u] = 1;
        }
    }

    /**
     * Finds degree of a vertex in a non-directed adjacency matrix.
     *
     * @param v as an int
     * @return degreeOfVertex as an int
     */
    public int degree(int v) {
        int degreeOfVertex = 0;
        if (directed) {
            return -1;
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[v][i] == 1
                    && adjacencyMatrix[i][v] == 1) {
                degreeOfVertex++;
            }
        }
        return degreeOfVertex;
    }

    /**
     * Finds degree of connections coming in for a vertex
     * in an adjacency matrix (directed graph).
     *
     * @param v as an int
     * @return degreesOfVertex as an int
     */
    public int inDegree(int v) {
        int degreeOfVertex = 0;
        if (!directed) {
            return -1;
        }
        for (int[] newAdjacencyMatrix : adjacencyMatrix) {
            if (newAdjacencyMatrix[v] == 1) {
                degreeOfVertex++;
            }
        }
        return degreeOfVertex;
    }

    /**
     * Finds degree of connections going out for a vertex
     * in an adjacency matrix (directed graph).
     *
     * @param v as an int
     * @return degreesOfVertex as an int
     */
    public int outDegree(int v) {
        int degreeOfVertex = 0;
        if (!directed) {
            return -1;
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[i][v] == 1) {
                degreeOfVertex++;
            }
        }
        return degreeOfVertex;
    }

    /**
     * Sets directed instance variable.
     *
     * @param newDirected the new directed value
     */
    public void setDirected(boolean newDirected) {
        this.directed = newDirected;
    }

    /**
     * Retrieves current value of directed instance variable.
     *
     * @return boolean value of directed variable
     */
    public boolean isDirected() {
        return this.directed;
    }

    /**
     * Depth-first-search(Dfs) helper function.
     *
     * @param v as an int
     * @param isVisited as a boolean[] array
     */
    void dfsHelper(int v, final boolean[] isVisited) {
        isVisited[v] = true;
        System.out.println("visiting vertex" + v);
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[v][i] == 1 && !isVisited[i]) {
                dfsHelper(i, isVisited);
            }
        }
    }

    /**
     * Depth-first-search(Dfs) main algorithm.
     */
    void dfs() {
        boolean[] isVisited = new boolean[this.adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (!isVisited[i]) {
                dfsHelper(i, isVisited);
            }
        }
    }

    /**
     * Breadth-first-search(bfs) helper function.
     *
     * @param v as an int
     * @param isVisited as a boolean[] array
     */
    void bfsHelper(int v, final boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[v] = true;
        System.out.println("visiting vertex" + v);
        queue.add(v);
        while (queue.size() != 0) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[0][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    System.out.println("visiting vertex" + i);
                    queue.add(i);
                }
            }
            queue.clear();
        }
    }

    /**
     * Breadth-first-search(bfs) main algorithm.
     */
    void bfs() {
        boolean[] isVisited = new boolean[this.adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (!isVisited[i]) {
                bfsHelper(i, isVisited);
            }
        }
    }

    /**
     * Overridden toString method to match requirements of
     * an adjacency matrix.
     * @return results of string building
     */
    public String toString() {
        StringBuilder matrixString;
        matrixString = new StringBuilder("Matrix\n");
        for (int[] newAdjacencyMatrix : adjacencyMatrix) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                matrixString.append(newAdjacencyMatrix[j]);
                matrixString.append(" ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }
}
