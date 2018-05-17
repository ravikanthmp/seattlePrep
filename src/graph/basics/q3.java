package graph.basics;

import graph.Graph;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class q3 {

    boolean[] visited;

    public q3(Graph graph, int src) {
        visited = new boolean[graph.V()];
//        int cc = 0;
//        for (int i = 0; i < visited.length; i++) {
//            if (!visited[i]){
//                dfsUtil(graph, i);
//            }
//        }

        StringBuilder sb = new StringBuilder();
        dfsUtil(graph, src, sb);
        System.out.println(sb.toString());
    }

    private void dfsUtil(Graph graph, int src, StringBuilder sb){
        visited[src] = true;
        sb.append(src).append(" ");
        for (int v : graph.adj(src)){
            if (!visited[v]){
                dfsUtil(graph, v, sb);
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        q3 test = new q3(g, 2);

    }
}
