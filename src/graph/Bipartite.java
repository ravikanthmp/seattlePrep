package graph;

/**
 * Created by Ravikanth on 5/20/2018.
 */
public class Bipartite {

    private boolean[] visited;
    private boolean[] color;

    public Bipartite(WeightedEdgeGraph graph) {
        visited = new boolean[graph.V()];
        color = new boolean[graph.V()];
        boolean ans = true;
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                ans = dfsUtil(graph, i, i);
                if (!ans) {
                    break;
                }
            }
        }

        System.out.println("Is Graph Bipartite " + ans);
    }

    private boolean dfsUtil(WeightedEdgeGraph graph, int src, int parent) {
        visited[src] = true;
        color[src] = !color[parent];
        boolean ans;

        for (Edge i : graph.adj(src)) {
            if (!visited[i.other(src)]) {
                ans = dfsUtil(graph, i.other(src), src);
                if (!ans) return ans;
            } else if (i.other(src) != parent) {
                if (color[i.other(src)] == color[src]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int G[][] = {{0, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 0, 0, 0}
        };
        WeightedEdgeGraph graph = new WeightedEdgeGraph(G);
        Bipartite bipartite = new Bipartite(graph);

    }
}
