package graph.mst;

import graph.Edge;
import graph.WeightedEdgeGraph;
import heap.IndexMinPQ;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Ravikanth on 5/15/2018.
 */
public class PrimMST implements MST {

    WeightedEdgeGraph graph;
    boolean[] visited;
    double[] distTo;
    IndexMinPQ<Double> pq;
    Edge[] edgeTo;
    Queue<Edge> queue = new LinkedList<>();

    public PrimMST(WeightedEdgeGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        distTo = new double[graph.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        pq = new IndexMinPQ<>(graph.V());
        edgeTo = new Edge[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                prims(i);
            }
        }

    }


    private void prims(int src){
        distTo[src] = 0;
        visit(src);
        int v;
        while (!pq.isEmpty()){
            v = pq.delMin();
            if (edgeTo[v] != null){
                queue.add(edgeTo[v]);
            }
            visit(v);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return queue;
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Edge e : edges()){
            weight += e.weight();
        }
        return weight;
    }


    private void visit(int v){
        visited[v] = true;
        int other;
        for (Edge e : graph.adj(v)){
             other = e.other(v);
            if (!visited[other]){
                if (distTo[other] > e.weight()){
                    distTo[other] = e.weight();
                    edgeTo[other] = e;
                    if (!pq.contains(other)){
                        pq.insert(other, distTo[other]);
                    }else {
                        pq.changeKey(other, distTo[other]);
                    }
                }
            }
        }
    }
}
