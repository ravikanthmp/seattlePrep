package graph.shortestpath;

import edu.princeton.cs.algs4.IndexMinPQ;
import graph.DirectedWeightedEdgeGraph;
import graph.Edge;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class AcyclicSP extends BaseSP{

    public AcyclicSP(DirectedWeightedEdgeGraph graph, int src) {
        this.graph = graph;
        this.src = src;
        distTo = new double[graph.V()];
        edgeTo = new Edge[graph.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[src] = 0;
        for (int i : graph.topologicalOrderFromSrc(src)){
            relax(i);
        }
    }

    @Override
    public boolean hasPathTo(int i) {
        return distTo[i] != Double.MAX_VALUE;
    }

    void relax(int v){
        for (Edge e : graph.adj(v)){
            if (distTo[e.to()] > distTo[v] + e.weight()){
                edgeTo[e.to()] = e;
                distTo[e.to()] = distTo[v] + e.weight();
            }
        }
    }
}
