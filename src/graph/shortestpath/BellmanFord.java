package graph.shortestpath;

import graph.DirectedWeightedEdgeGraph;
import graph.Edge;

import static graph.mst.MSTClient.construct2;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class BellmanFord {

    private DirectedWeightedEdgeGraph graph;
    private double[] distTo;

    public BellmanFord(DirectedWeightedEdgeGraph graph, int src) {
        this.graph = graph;
        distTo = new double[graph.V()];

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[src] = 0;

        for (int i = 0; i < graph.V() - 1; i++) {
            for (int j = 0; j < graph.V(); j++) {
                relax(j);
            }
        }

        for (int j = 0; j < graph.V(); j++) {
            if (relax(j)){
                System.out.println("Negative cycle detected!");
            }
            break;
        }
    }

    private boolean relax(int src){
        boolean ans = false;
        for (Edge edge : graph.adj(src)) {
            if (distTo[edge.to()] > distTo[src] + edge.weight()){
                distTo[edge.to()] = distTo[src] + edge.weight();
                ans = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWDn.txt";
        DirectedWeightedEdgeGraph graph = construct2(url);
        BellmanFord bellmanFord = new BellmanFord(graph, 0);
    }
}
