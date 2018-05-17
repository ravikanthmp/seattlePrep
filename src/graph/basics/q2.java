package graph.basics;

import graph.Graph;
import  java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class q2 {

    private boolean[] visited;

    public q2(Graph graph, int src) {
        visited = new boolean[graph.V()];
        bfsUtil(graph, src);
    }

    private void bfsUtil(Graph graph, int src){
        Queue<Integer> queue = new LinkedList();
        queue.add(src);
        visited[src] = true;
        StringBuilder sb = new StringBuilder();
        int front;

        while (!queue.isEmpty()){
            front = queue.remove();
            sb.append(front).append(" ");
            for (int i : graph.adj(front)){
                if (!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        q2 test = new q2(g, 2);

    }
}
