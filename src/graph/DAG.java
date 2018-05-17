package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class DAG {
    List<Edge>[] adjList;
    int E;

    //adjacency list
    public DAG(int v){
        adjList = new LinkedList[v];
        for (int i = 0; i < adjList.length  ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v, int w){
        adjList[u].add(new Edge(u, v, w));
        E++;
    }

    public void addEdge(int u, int v){
       addEdge(u, v, 1);
    }

    public Iterable<Edge> adj(int u){
        return adjList[u];
    }

    public int V(){
        return adjList.length;
    }

    public int E(){
        return E;
    }
}
