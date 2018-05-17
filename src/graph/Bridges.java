package graph;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class Bridges {

    private WeightedEdgeGraph graph;
    private boolean[] visited;
    private int[] low;
    private int ctr;
    private int[] count;


    public Bridges(WeightedEdgeGraph graph) {
        visited = new boolean[graph.V()];
        low = new int[graph.V()];
        count = new int[graph.V()];
        this.graph = graph;
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                dfs(i, i, i);
            }
        }
    }

    private void dfs(int c, int parent, int root){
        int u;
        visited[c] = true;
        count[c] = ctr++;
        low[c] = count[c]; //init

        for (Edge e : graph.adj(c)){
            u = e.other(c);
            if (!visited[u]){
                dfs(u, c, root);
                low[c] = Math.min(low[c], low[u]);
                if (low[u] > count[c]){
                    System.out.println("Bridge " + e);
                }
            }else {
                if (u != parent){
                    low[c] = Math.min(low[c], low[u]);
                }
            }
        }
    }

    public static void main(String[] args) {
        WeightedEdgeGraph g2 = new WeightedEdgeGraph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);
        g2.addEdge(1, 6);
        g2.addEdge(3, 5);
        g2.addEdge(4, 5);
        Bridges ap = new Bridges(g2);
    }
}
