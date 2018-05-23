package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ravikanth on 5/17/2018.
 */
public class EulerPath {

    boolean isConnected;
    WeightedEdgeGraph G;
    int degOne, degTwo;
    int counter;
    int[] low;
    Set<Edge> set;

    public EulerPath(WeightedEdgeGraph graph){
        G = graph;
        set = new HashSet<>();
        low = new int[graph.V()];
        if (isConnected(graph) && checkDegrees(graph)){
            int start = getDegOneIfPresent(graph);
            initBridges(graph, start);

        }
    }

    private void euler(WeightedEdgeGraph graph, int src){
        boolean[] visited = new boolean[graph.V()];
        dfsEuler(src, visited, graph, src);
    }

    private void dfsEuler(int src, boolean[] visited, WeightedEdgeGraph graph, int parent) {
        visited[src] = true;
        int u;

        boolean done = false;
        Set<Edge> tbd = new HashSet<>();
        for (Edge e : G.adj(src)) {
            u = e.other(src);
            if (!visited[u]){
                if (set.contains(e)){
                    tbd.add(e);
                    continue;
                }

                dfsEuler(u, visited, graph, src);
            }
        }
    }

    private void initBridges(WeightedEdgeGraph graph, int src){
        boolean[] visited = new boolean[graph.V()];
        dfsUtil(src, visited, graph, src);
    }

    private void dfsUtil(int src, boolean[] visited,  WeightedEdgeGraph G, int parent){
        visited[src] = true;
        int c = counter++;
        low[src] = c;

        int u;
        for (Edge e : G.adj(src)){
            u = e.other(src);

            if (!visited[u] ){
                dfsUtil(u, visited, G, src);
                low[src] = Math.min(low[src], low[u]);
                if (low[u] > c){
                    set.add(e);
                }
            }else if (u != parent){
                low[src] = Math.min(low[src], low[parent]);
            }
        }
    }

    private boolean isConnected(WeightedEdgeGraph graph){
        boolean[] visited = new boolean[graph.V()];
        int count  = 0;

        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                dfs(i, visited);
                count++;
            }
        }

       return count == 1;
    }

    private boolean checkDegrees(WeightedEdgeGraph graph){
        for (int i = 0; i < graph.V(); i++) {
            if ( (graph.degree(i) == 1)){
                degOne++;
                if (degOne > 2) return false;
            }else if (graph.degree(i) == 2){
                degTwo++;
            } else {
                return false;
            }
        }
        return ( ( (degOne == 0) || (degOne == 2) ) && (degTwo % 2 == 0) );
    }

    private int getDegOneIfPresent(WeightedEdgeGraph graph){
        for (int i = 0; i < graph.V(); i++) {
            if ((graph.degree(i) == 1)) {
                return i;
            }
        }

        return 0;
    }

    private void dfs(int src, boolean[] visited){
        visited[src] = true;
        for (Edge e : G.adj(src)){
            if (!visited[e.other(src)]){
                dfs(e.other(src), visited);
            }
        }
    }
}
