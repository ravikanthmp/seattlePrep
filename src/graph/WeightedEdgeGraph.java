package graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ravikanth on 5/15/2018.
 */
public class WeightedEdgeGraph {

    List<Edge>[] adjList;
    int E;

    //adjacency list
    public WeightedEdgeGraph(int v) {
        adjList = new LinkedList[v];
    }


    public WeightedEdgeGraph(int[][] matrix) {

        adjList = new LinkedList[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0){
                    addEdge(i, j, matrix[i][j]);
                }
            }
        }
    }


    public void addEdge(int u, int v) {
        addEdge(u, v, 0);
    }

    public void addEdge(int u, int v, double w) {
        Edge e = new Edge(u, v, w);
        if (adjList[u] == null) adjList[u] = new LinkedList<>();
        adjList[u].add(e);

        if (adjList[v] == null) adjList[v] = new LinkedList<>();
        adjList[v].add(e);
        E++;
    }

    public Iterable<Edge> adj(int u) {
        return adjList[u] == null ? Collections.EMPTY_LIST : adjList[u];
    }

    public int V() {
        return adjList.length;
    }

    public int E() {
        return E;
    }

    public int degree(int v) {
        return adjList[v] == null ? 0 : adjList[v].size();
    }

}
