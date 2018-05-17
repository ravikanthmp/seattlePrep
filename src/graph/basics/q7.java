package graph.basics;

import graph.DAG;
import graph.Edge;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class q7 {
    private boolean[] visited;
    int unvisited ;
    private DAG graph;

    public q7(DAG dag) {
        visited = new boolean[dag.V()];
        unvisited = dag.V();
        this.graph = dag;

    }

    private boolean check(int v){
        dfsUtilREV(graph, v);
        return unvisited == graph.V();
    }

    public void dfs(){
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                dfsUtil(graph, i);
                if (unvisited == 0){
                    if (check(i))
                        System.out.println("Mother vertex is: " + i);
                    else
                        System.out.println("Disconnected graph ");
                    break;
                }
            }
        }
    }

    private void dfsUtil(DAG dag, int src){
        visited[src] = true;
        unvisited--;
        int other ;
        for ( Edge e : dag.adj(src)){
            other = e.other(src);
            if (!visited[other]){
                dfsUtil(dag, other);
            }
        }
    }


    private void dfsUtilREV(DAG dag, int src){
        visited[src] = false;
        unvisited++;
        int other ;
        for ( Edge e : dag.adj(src)){
            other = e.other(src);
            if (visited[other]){
                dfsUtilREV(dag, other);
            }
        }
    }
    public static void main(String[] args) {
        DAG g = new DAG(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        q7 test = new q7(g);
        test.dfs();

    }
}


