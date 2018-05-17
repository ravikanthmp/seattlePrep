package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class Graph {

    List<Integer>[] adjList;
    int E;

    //adjacency list
    public Graph(int v){
        adjList = new LinkedList[v];
    }

    public void addEdge(int u, int v){
        if (adjList[u] == null) adjList[u] = new LinkedList<>();
        adjList[u].add(v);

        if (adjList[v] == null) adjList[v] = new LinkedList<>();
        adjList[v].add(u);
        E++;
    }

    public Iterable<Integer> adj(int u){
        return adjList[u];
    }

    public int V(){
        return adjList.length;
    }

    public int E(){
      return E;
    }



}
