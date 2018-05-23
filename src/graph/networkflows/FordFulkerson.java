package graph.networkflows;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ravikanth on 5/17/2018.
 */
public class FordFulkerson {

    FlowNetwork G;
    boolean[] visited;
    FlowEdge[] edgeTo;
    int flow;

    public FordFulkerson(FlowNetwork graph, int s, int t) {
        G = graph;
        edgeTo = new FlowEdge[graph.V()];

        StringBuilder sb = new StringBuilder();

        while (hasAugmentationPath(s, t)) {

            int min = Integer.MAX_VALUE;

            for (FlowEdge edge = edgeTo[t]; edge != null; edge = edgeTo[edge.from()]) {
                min = Math.min(min, edge.residualCapacityTo(edge.to()));

            }

            for (FlowEdge edge = edgeTo[t]; edge != null; edge = edgeTo[edge.from()]) {
                edge.addResidualFlowTo(edge.from(), min);
            }



            flow += min;
        }

        System.out.println(flow);
    }

    public boolean[] getVisited() {
        return visited;
    }

    private boolean hasAugmentationPath(int s, int t) {
        visited = new boolean[G.V()];
        edgeTo = new FlowEdge[G.V()];
        bfs(s, visited);
        return visited[t];
    }

    private void bfs(int src, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        edgeTo[src] = null;
        queue.add(src);
        int u;

        while (!queue.isEmpty()) {
            u = queue.remove();
            for (FlowEdge x : G.adj(u)) {
                if (!visited[x.to()] && x.residualCapacityTo(x.to()) != 0) {
                    queue.add(x.to());
                    visited[x.to()] = true;
                    edgeTo[x.to()] = x;
                }
            }
        }
    }


    public int getMaxFlow(){
        return flow;
    }

    public void printFlows() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < G.V(); i++) {
            for (FlowEdge edge : G.adj(i)) {
                if (i == edge.from()) {
                    sb.append(edge.f).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

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
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0){
                    graph.addEdge(i, j, matrix[i][j]);
                }
            }
        }
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

        FordFulkerson ff = new FordFulkerson(graph, 0, 5);
      //  ff.printFlows();

    }
}
