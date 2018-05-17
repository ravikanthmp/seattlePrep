package graph.cycle;

import graph.DAG;
import graph.Edge;

import java.util.LinkedList;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class q1 {

    boolean[] visited;

    public q1(DAG dag) {
        visited = new boolean[dag.V()];
        boolean ans = false;

        for (int i = 0; i < dag.V(); i++) {
            if (!visited[i]) {
                ans = dfsUtil(dag, i, i);
                if (!ans) {
                    break;
                }
            }
        }
        if (!ans) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private boolean dfsUtil(DAG graph, int v, int from) {
        visited[v] = true;
        for (Edge edge : graph.adj(v)) {
            if (visited[edge.other(v)] && edge.other(v) != from) {
                return false;
            } else {
                dfsUtil(graph, edge.other(v), v);
            }
        }
        return true;
    }

    public boolean hasCycle(int v, LinkedList<Integer>[] alist, boolean[] visited, boolean[] explored) {
        // add code here.
        boolean ans = false;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ans = dfsUtil(alist, i, i);
                if (ans) {
                    break;
                }
            }
        }
        return false;
    }


    private boolean dfsUtil(LinkedList<Integer>[] alist, int v, int from) {
        visited[v] = true;
        for (int u : alist[v]) {
            if (visited[u] && u != from) {
                return true;
            } else {
                dfsUtil(alist, u, v);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
