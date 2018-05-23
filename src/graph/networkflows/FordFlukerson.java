package graph.networkflows;


import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Ravikanth on 5/17/2018.
 */
public class FordFlukerson {
    private static final double FLOATING_POINT_EPSILON = 1E-11;

    private final int V;          // number of vertices
    private boolean[] marked;     // marked[v] = true iff s->v path in residual graph
    private FlowEdge[] edgeTo;    // edgeTo[v] = last edge on shortest residual s->v path
    private double value;         // current value of max flow

    /**
     * Compute a maximum flow and minimum cut in the network {@code G}
     * from vertex {@code s} to vertex {@code t}.
     *
     * @param  G the flow network
     * @param  s the source vertex
     * @param  t the sink vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     * @throws IllegalArgumentException unless {@code 0 <= t < V}
     * @throws IllegalArgumentException if {@code s == t}
     * @throws IllegalArgumentException if initial flow is infeasible
     */
    public FordFlukerson(FlowNetwork G, int s, int t) {
        V = G.V();
        validate(s);
        validate(t);
        if (s == t)               throw new IllegalArgumentException("Source equals sink");
     //   if (!isFeasible(G, s, t)) throw new IllegalArgumentException("Initial flow is infeasible");

        // while there exists an augmenting path, use it
        value = excess(G, t);
        while (hasAugmentingPath(G, s, t)) {

            // compute bottleneck capacity
            int bottle = Integer.MAX_VALUE;

            for (FlowEdge edge = edgeTo[t]; edge != null; edge = edgeTo[edge.from()]) {
                bottle = Math.min(bottle, edge.residualCapacityTo(edge.to()));
            }

//            for (int v = t; v != s; v = edgeTo[v].other(v)) {
//                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
//            }

            // augment flow
//            for (int v = t; v != s; v = edgeTo[v].other(v)) {
//                edgeTo[v].addResidualFlowTo(v, bottle);
//            }

            for (FlowEdge edge = edgeTo[t]; edge != null; edge = edgeTo[edge.from()]) {
                edge.addResidualFlowTo(edge.from(), bottle);
            }


            value += bottle;
        }

        System.out.println(value);

        // check optimality conditions
        assert check(G, s, t);
    }

    /**
     * Returns the value of the maximum flow.
     *
     * @return the value of the maximum flow
     */
    public double value()  {
        return value;
    }

    /**
     * Returns true if the specified vertex is on the {@code s} side of the mincut.
     *
     * @param  v vertex
     * @return {@code true} if vertex {@code v} is on the {@code s} side of the micut;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean inCut(int v)  {
        validate(v);
        return marked[v];
    }

    // throw an IllegalArgumentException if v is outside prescibed range
    private void validate(int v)  {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }


    // is there an augmenting path? 
    // if so, upon termination edgeTo[] will contain a parent-link representation of such a path
    // this implementation finds a shortest augmenting path (fewest number of edges),
    // which performs well both in theory and in practice
    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];

        // breadth-first search
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty() && !marked[t]) {
            int v = queue.remove();

            for (FlowEdge e : G.adj(v)) {
                int w = e.to();

                // if residual capacity from v to w
                if (e.residualCapacityTo(w) > 0) {
                    if (!marked[w]) {
                        edgeTo[w] = e;
                        marked[w] = true;
                        queue.add(w);
                    }
                }
            }
        }

        // is there an augmenting path?
        return marked[t];
    }



    // return excess flow at vertex v
    private double excess(FlowNetwork G, int v) {
        double excess = 0.0;
        for (FlowEdge e : G.adj(v)) {
            if (v == e.from()) excess -= e.f;
            else               excess += e.f;
        }
        return excess;
    }

    // check optimality conditions
    private boolean check(FlowNetwork G, int s, int t) {

        // check that s is on the source side of min cut and that t is not on source side
        if (!inCut(s)) {
            System.err.println("source " + s + " is not on source side of min cut");
            return false;
        }
        if (inCut(t)) {
            System.err.println("sink " + t + " is on source side of min cut");
            return false;
        }

        // check that value of min cut = value of max flow
        double mincutValue = 0.0;
        for (int v = 0; v < G.V(); v++) {
            for (FlowEdge e : G.adj(v)) {
                if ((v == e.from()) && inCut(e.from()) && !inCut(e.to()))
                    mincutValue += e.capacity();
            }
        }

        if (Math.abs(mincutValue - value) > FLOATING_POINT_EPSILON) {
            System.err.println("Max flow value = " + value + ", min cut value = " + mincutValue);
            return false;
        }

        return true;
    }


    /**
     * Unit tests the {@code FordFlukerson} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        int[][] matrix =
                { {0, 16, 13, 0, 0, 0},
                        {0, 0, 10, 12, 0, 0},
                        {0, 4, 0, 0, 14, 0},
                        {0, 0, 9, 0, 0, 20},
                        {0, 0, 0, 7, 0, 4},
                        {0, 0, 0, 0, 0, 0}
                };


        FlowNetwork graph = new FlowNetwork(matrix.length);
//        graph.addEdge(0, 1, 16);
//        graph.addEdge(0, 1, 13);
//
//        graph.addEdge(1, 2, 10);
//        graph.addEdge(1, 3, 12);
//
//        graph.addEdge(2, 1, 4);
//        graph.addEdge(2, 4, 14);
//
//        graph.addEdge(3, 2, 9);
//        graph.addEdge(3, 5, 20);
//
//        graph.addEdge(4, 3, 7);
//        graph.addEdge(4, 5, 4);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0){
                    graph.addEdge(i, j, matrix[i][j]);
                }
            }
        }
        FordFlukerson maxflow = new FordFlukerson(graph, 0, 5);

        // print min-cut
        StdOut.print("Min cut: ");
        for (int v = 0; v < graph.V(); v++) {
            if (maxflow.inCut(v)) StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.println("Max flow value = " +  maxflow.value());

    }

}
