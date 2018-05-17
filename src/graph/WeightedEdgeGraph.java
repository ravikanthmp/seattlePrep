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
    public WeightedEdgeGraph(int v){
        adjList = new LinkedList[v];
    }

    public void addEdge(int u, int v){
        addEdge(u, v, 0);
    }
    public void addEdge(int u, int v, double w){
        Edge e = new Edge(u, v, w);
        if (adjList[u] == null) adjList[u] = new LinkedList<>();
       adjList[u].add(e);

        if (adjList[v] == null) adjList[v] = new LinkedList<>();
        adjList[v].add(e);
        E++;
    }

    public Iterable<Edge> adj(int u){
        return adjList[u] == null ? Collections.EMPTY_LIST : adjList[u];
    }

    public int V(){
        return adjList.length;
    }

    public int E(){
        return E;
    }

}
