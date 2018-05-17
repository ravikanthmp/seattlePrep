package bt.lca;

import org.omg.CORBA.INTERNAL;
import tree.Node;

/**
 * Created by Ravikanth on 5/12/2018.
 */
public class q2 {


    static class CountHolder {
        int count;
    }

    public Node lca(Node root, int l, int m) {
        CountHolder count = new CountHolder();
        Node node = lcaInternal(root, l, m, count);
     //   System.out.println("LCA is " + node == null ? " null " : node.data);
        return node;
    }

    public int findDistance(Node root, int a, int b) {
        Node node = lca(root, a, b);
        return findDist(node, a, 0) + findDist(node, b, 0);
    }

    private int  findDist(Node n, int a, int d){
        if (n == null) return Integer.MAX_VALUE;
        if (n.data == a) return d;
        return Math.min(findDist(n.left, a, d + 1), findDist(n.right, a, d + 1));
    }

    private Node lcaInternal(Node curr, int i1, int i2, CountHolder holder) {
        if (curr == null) return null;

        Node left = lcaInternal(curr.left, i1, i2, holder);
        if (holder.count == 2) return left;

        boolean checkThisNode = (curr.data == i1 || curr.data == i2);
        if (checkThisNode) holder.count++;


        Node right = lcaInternal(curr.right, i1, i2, holder);

        if (left != null && right != null) return curr;
        else if (left != null) return checkThisNode ? curr : left;
        else if (right != null) return checkThisNode ? curr : right;
        else return checkThisNode ? curr : null;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        q2 test = new q2();
        System.out.println(test.findDistance(root, 4, 6));;
    }
}
