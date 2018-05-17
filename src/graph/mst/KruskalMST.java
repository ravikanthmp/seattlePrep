package graph.mst;

import graph.Edge;
import graph.WeightedEdgeGraph;
import uf.UnionFind;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class KruskalMST implements MST {

    WeightedEdgeGraph graph;

    public KruskalMST(WeightedEdgeGraph graph) {
        this.graph = graph;
    }

    @Override
    public Iterable<Edge> edges() {
        Queue<Edge> queue = new LinkedList<Edge>();
        UnionFind uf = new UnionFind(graph.V());
        PriorityQueue<Edge> minPQ = new PriorityQueue<>();
        collectEdges(graph, minPQ);

        int n = 0, V = graph.V() - 1;
        Edge e;
        int i, j;

        while (!minPQ.isEmpty() ){
            e = minPQ.remove();
            i = e.either();
            j = e.other(i);

            if (!uf.find(i, j)){
                uf.union(i, j);
                queue.add(e);
            }
        }


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

    private void collectEdges(WeightedEdgeGraph graph, PriorityQueue<Edge> minPQ) {
        for (int i = 0; i < graph.V(); i++) {
            for (Edge edge : graph.adj(i)) {
                minPQ.add(edge);
            }
        }
    }
}
