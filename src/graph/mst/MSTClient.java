package graph.mst;

import edu.princeton.cs.algs4.In;
import graph.DirectedWeightedEdgeGraph;
import graph.Edge;
import graph.Graph;
import graph.WeightedEdgeGraph;
import graph.networkflows.FlowNetwork;

/**
 * Created by Ravikanth on 5/15/2018.
 */
public class MSTClient {

    public static void mst(MST mst){
        double weight = 0;
        for (Edge edge : mst.edges()){
            System.out.println(edge);
            weight += edge.weight();
        }
        System.out.println(weight);
    }

    public static WeightedEdgeGraph construct(String url){
        In in = new In(url);
        int V = in.readInt();
        int E = in.readInt();
        WeightedEdgeGraph graph = new WeightedEdgeGraph(V);

        for (int i = 0; i < E; i++) {
            graph.addEdge(in.readInt(),in.readInt(), in.readDouble());
        }

        return graph;
    }

    public static DirectedWeightedEdgeGraph construct2(String url){
        In in = new In(url);
        int V = in.readInt();
        int E = in.readInt();
        DirectedWeightedEdgeGraph graph = new DirectedWeightedEdgeGraph(V);

        for (int i = 0; i < E; i++) {
            graph.addEdge(in.readInt(),in.readInt(), in.readDouble());
        }

        return graph;
    }

    public static FlowNetwork construct3(String url){
        In in = new In(url);
        int V = in.readInt();
        int E = in.readInt();
        FlowNetwork graph = new FlowNetwork(V);

        for (int i = 0; i < E; i++) {
            graph.addEdge(in.readInt(),in.readInt(), (int)in.readDouble());
        }

        return graph;
    }

    public static void main(String[] args) {
        String url = "https://algs4.cs.princeton.edu/43mst/tinyEWG.txt";
        WeightedEdgeGraph graph = construct(url);
        mst(new PrimMST(graph));
        mst(new KruskalMST(graph));

    }
}
