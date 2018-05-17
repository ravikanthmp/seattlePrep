package graph.shortestpath;

import graph.DirectedWeightedEdgeGraph;
import graph.Edge;

import static graph.mst.MSTClient.construct2;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class AcyclicLP extends AcyclicSP {

    public AcyclicLP(DirectedWeightedEdgeGraph graph, int src) {
        super(graph, src);
    }

    @Override
    void relax(int v) {
        for (Edge e : graph.adj(v)){
            e.setW(-e.weight());
            if (distTo[e.to()] > distTo[v] + e.weight()){
                edgeTo[e.to()] = e;
                distTo[e.to()] = distTo[v] + e.weight();
            }
            e.setW(-e.weight());
        }
    }

    public double longestPath(){
        double MaxLength = 0;
        for (int i = 0; i < graph.V(); i++) {
            if (distTo[i] < MaxLength){
                MaxLength = distTo[i];
            }
        }
        return -1* MaxLength;
    }

    public static void main(String[] args) {
        String url = " https://algs4.cs.princeton.edu/44sp/tinyEWDAG.txt";
        DirectedWeightedEdgeGraph graph = construct2(url);
        AcyclicLP sp = new AcyclicLP(graph, 5);

        System.out.println(sp.longestPath());

//        for (int i = 0; i < graph.V(); i++) {
//            sp.printPathTo(i);
//        }
    }
}
