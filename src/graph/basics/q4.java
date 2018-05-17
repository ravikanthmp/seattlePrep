package graph.basics;

import arrays.Util;
import graph.DAG;
import graph.Edge;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class q4 {

    boolean[] visited;
    Stack<Integer> stack;
    double[] distTo;

    public q4(DAG DAG, int src) {
        visited = new boolean[DAG.V()];
        stack = new Stack<>();
        distTo = new double[DAG.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Integer.MIN_VALUE;
        }
        distTo[src] = 0;

        dfsUtil(DAG, src);
        int el;
        while (!stack.isEmpty()){
            el = stack.pop();
            for (Edge e : DAG.adj(el)){
                if (distTo[e.other(el)] < distTo[el] + e.weight()){
                    distTo[e.other(el)] = distTo[el] + e.weight();
                }
            }
        }

        System.out.println(Util.print(distTo));;
    }

    private void dfsUtil(DAG DAG, int src) {

        visited[src] = true;
        for(Edge e : DAG.adj(src)){
            if (!visited[e.other(src)]){
                dfsUtil(DAG, e.other(src));
            }
        }

        stack.push(src);

    }

    public static void main(String[] args) {
        DAG g = new DAG(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        q4 test = new q4(g, 1);
    }
}
