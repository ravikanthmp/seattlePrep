package graph.shortestpath;

import graph.DirectedWeightedEdgeGraph;

import static graph.mst.MSTClient.construct2;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class SPClient {
    public static void main(String[] args) {
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWDAG.txt";
        DirectedWeightedEdgeGraph graph = construct2(url);
        SP sp = new AcyclicSP(graph, 5);

        for (int i = 0; i < graph.V(); i++) {
            sp.printPathTo(i);
        }
    }
}
