package graph.shortestpath;

import graph.DirectedWeightedEdgeGraph;
import graph.Edge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public abstract class BaseSP implements SP{

    double[] distTo;
    Edge[] edgeTo;
    int src;
    DirectedWeightedEdgeGraph graph;

    @Override
    public Iterable<Edge> pathTo(int i) {
        Deque<Edge> stack = new ArrayDeque<Edge>();
        for (Edge edge = edgeTo[i]; edge != null;  ){
            stack.push(edge);
            i = edge.other(i);
            edge = edgeTo[i];

        }
        return stack;
    }

    @Override
    public void printPathTo(int i) {
        StringBuilder sb = new StringBuilder();
        Iterable<Edge> edges = pathTo(i);
        double weight = 0;
        for (Edge e : edges){
            weight += e.weight();
            sb.append(e.from() + " -> " + e.to() + " " + e.weight()).append(" ");
        }
        sb.append(" Total Weight: ").append(weight);
        System.out.println("Path from " + src + " to " + i  + " " + sb.toString());
    }


    @Override
    public double distTo(int i) {
        return distTo[i];
    }

}
