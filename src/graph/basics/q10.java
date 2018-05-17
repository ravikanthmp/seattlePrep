package graph.basics;

import graph.DAG;
import graph.Edge;

import java.util.Stack;


/**
 * Created by Ravikanth on 5/14/2018.
 */
public class q10 {

    public q10(DAG g, int src){

        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        int curr;
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[g.V()];

        visited[src] = true;
        while (!stack.isEmpty()){
            curr = stack.pop();
            sb.append(curr).append(" ");
            for (Edge e : g.adj(curr)){
                if (!visited[e.other(curr)]){
                    visited[e.other(curr)] = true;
                    stack.push(e.other(curr));
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        DAG g = new DAG(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
    q10 test = new q10(g, 0);
    }
}
