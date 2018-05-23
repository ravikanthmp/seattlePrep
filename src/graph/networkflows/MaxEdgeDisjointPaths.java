package graph.networkflows;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ravikanth on 5/18/2018.
 */
public class MaxEdgeDisjointPaths {

    private FlowNetwork graph;
    private int count;
    private boolean[] visited;
    private FlowEdge[] edgeTo;


    public MaxEdgeDisjointPaths(FlowNetwork graph, int s, int t) {
        this.graph = graph;

        while (hasAugmentationPath(s, t)){
            for (FlowEdge edge = edgeTo[t]; edge != null; edge = edgeTo[edge.from()]){
                edge.addResidualFlowTo(edge.from(), edge.residualCapacityTo(edge.to()));
            }
            count++;
        }
    }

    private boolean hasAugmentationPath(int src, int t){
        visited = new boolean[graph.V()];
        edgeTo = new FlowEdge[graph.V()];
        bfsUtl(src, visited, edgeTo);
        return visited[t];
    }

    private void bfsUtl(int src, boolean[] visted, FlowEdge[] edgeTo){
        Queue<Integer> queue = new LinkedList();
        queue.add(src);
        visted[src] = true;

        int u, v;
        while (!queue.isEmpty()){
            v = queue.remove();
            for (FlowEdge edge : graph.adj(v)){
                u = edge.to();
                if (!visted[u] && edge.residualCapacityTo(u) != 0){
                    queue.add(u);
                    visted[u] = true;
                    edgeTo[u] = edge;
                }
            }
        }
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        int matrix[][] = { {0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        FlowNetwork graph = new FlowNetwork(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0){
                    graph.addEdge(i, j, matrix[i][j]);
                }
            }
        }

        MaxEdgeDisjointPaths maxEdgeDisjointPaths = new MaxEdgeDisjointPaths(graph, 0, 7);

        System.out.println(maxEdgeDisjointPaths.count());
    }
}
