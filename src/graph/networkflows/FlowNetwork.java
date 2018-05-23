package graph.networkflows;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ravikanth on 5/17/2018.
 */
public class FlowNetwork {

    private List<FlowEdge>[] adjList;
    private int V, E;

    public FlowNetwork(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public List<FlowEdge> adj(int i) {
        return adjList[i];
    }

    public void addEdge(int u, int v, int w) {
        FlowEdge edge = new FlowEdge(u, v, w);
        adjList[u].add(edge);
        adjList[v].add(edge);
        E += 2;
    }
}
