package graph.shortestpath;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.*;

import graph.Edge;
import graph.DirectedWeightedEdgeGraph;

import static graph.mst.MSTClient.construct;
import static graph.mst.MSTClient.construct2;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class DijkstraSP extends BaseSP {

    private boolean[] visited;

    private DirectedWeightedEdgeGraph graph;
    private IndexMinPQ<Double> minPQ;
    int src;


    public DijkstraSP(DirectedWeightedEdgeGraph graph, int src) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        distTo = new double[graph.V()];
        edgeTo = new Edge[graph.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        minPQ = new IndexMinPQ<>(graph.V());
        this.src = src;
        dijkstra(src);
    }

    @Override
    public boolean hasPathTo(int i) {
        return visited[i];
    }



    private void dijkstra(int v){
        distTo[v] = 0;
        edgeTo[v] = null;
        minPQ.insert(v, distTo[v]);
        int u;
        while (!minPQ.isEmpty()){
            u = minPQ.delMin();
            visited[u] = true;
            relax(u);
        }

    }

    private void relax(int v){
        int u ;
        for (Edge e : graph.adj(v)){
            u = e.other(v);
            if (!visited[u]){
                if (distTo[u] > distTo[v] + e.weight()){
                    distTo[u] = distTo[v] + e.weight();
                    edgeTo[u] = e;
                    if (minPQ.contains(u)){
                        minPQ.decreaseKey(u, distTo[u]);
                    }
                }

                if (!minPQ.contains(u)){
                    minPQ.insert(u, distTo[u]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWD.txt";
        DirectedWeightedEdgeGraph graph = construct2(url);
        SP sp = new DijkstraSP(graph, 0);

        for (int i = 0; i < graph.V(); i++) {
                sp.printPathTo(i);
        }
    }
}
