package linkedlist;

import arrays.*;
import arrays.Util;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

/**
 * Created by Ravikanth on 4/29/2018.
 */
public class q49 {

    static class Node{
        int data;
        Node next, random;

        public Node(int data){
            this.data = data;
        }
    }

    private Node clone(Node orig){
        Node dummy = new Node(0);
        Node prev = dummy;
        Map<Node, Node> map = new HashMap<>();
        for (Node curr = orig; curr != null; curr = curr.next){
            prev.next = new Node(curr.data);
            map.put(curr, prev.next);
            prev = prev.next;
        }

        Node c2 = dummy.next;
        for (Node curr = orig; curr != null; curr = curr.next){
             c2.random = map.get(curr.random);
             c2 = c2.next;
        }

        return dummy.next;
    }

    private void print(Node node){
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (node != null){
            sb.append("Node data: " + node.data + " Random Pointer: " + node.random.data).append("\n");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] ints = Util.generateArray(StdIn.readInt());
        Node dummy = new Node(0);
        Node curr = dummy;
        Node[] set = new Node[ints.length];

        int j = 0;
        for (int i : ints){
            curr.next = new Node(i);
            curr = curr.next;
            set[j++] = curr;
        }



        for (Node n = dummy.next; n != null; n = n.next){
            n.random = set[StdRandom.uniform(ints.length)];
        }

        q49 test = new q49();
        test.print(dummy.next);

        Node clone = test.clone(dummy.next);
        test.print(clone);


    }
}
