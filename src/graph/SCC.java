package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public class SCC {

    private boolean[] visted;
    private int[] cc;
    private int count;

    public SCC(DirectedWeightedEdgeGraph graph) {
        visted = new boolean[graph.V()];
        cc = new int[graph.V()];
        DirectedWeightedEdgeGraph G = graph.reverse();

        for (int i : G.topologicalOrder()) {
            if (!visted[i]) {
                dfs(i, graph);
                count++;
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.V(); i++) {
            if (!map.containsKey(cc[i])){
                map.put(cc[i], new LinkedList<>());
            }

            map.get(cc[i]).add(i);
        }

        for (int c : map.keySet()){
            StringBuilder sb = new StringBuilder();
            for (int i : map.get(c)){
                sb.append(i).append(" ");
            }
           // System.out.println(sb.toString());
        }
    }

    private void dfs(int src, DirectedWeightedEdgeGraph G) {
        visted[src] = true;
        cc[src] = count;
        for (Edge e : G.adj(src)) {
            if (!visted[e.to()]) {
                dfs(e.to(), G);
            }
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int i, int j) {
        return cc[i] == cc[j];
    }

    public static void main(String[] args) {
        DirectedWeightedEdgeGraph g = new DirectedWeightedEdgeGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        SCC test = new SCC(g);
        System.out.println(test.count());

    }
}
