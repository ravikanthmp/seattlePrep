package graph;

import java.util.*;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class DirectedWeightedEdgeGraph {

    List<Edge>[] adjList;
    int E;

    //adjacency list
    public DirectedWeightedEdgeGraph(int v){
        adjList = new LinkedList[v];
    }

    public void addEdge(int u, int v, double w){
        Edge e = new Edge(u, v, w);
        if (adjList[u] == null) adjList[u] = new LinkedList<>();
        adjList[u].add(e);

        E++;
    }

    public void addEdge(int u, int v){
      addEdge(u, v, 0);
    }

    public Iterable<Edge> adj(int u){
        return adjList[u] == null ? Collections.EMPTY_LIST : adjList[u];
    }

    public int V(){
        return adjList.length;
    }

    public Iterable<Integer> topologicalOrder(){
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[V()];
        for (int i = 0; i < V(); i++) {
            if (!visited[i]){
                dfs(i, stack, visited);
            }
        }
        return stack;
    }

    public DirectedWeightedEdgeGraph reverse(){
        DirectedWeightedEdgeGraph G = new DirectedWeightedEdgeGraph(V());
        for (int i = 0; i < V(); i++) {
            for (Edge e : adj(i)){
                G.addEdge(e.to(), e.from(), e.w);
            }
        }
        return G;
    }

    public Iterable<Integer> topologicalOrderFromSrc(int src){
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[V()];
        dfs(src, stack, visited);
        return stack;
    }

    private void dfs(int src, Deque<Integer> stack,  boolean[] visited ){
        visited[src] = true;
        for (Edge e : adj(src)){
            if (!visited[e.to()]){
                dfs(e.to(), stack, visited);
            }
        }
        stack.push(src);
    }

    public int E(){
        return E;
    }

}
