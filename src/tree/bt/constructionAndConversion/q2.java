package tree.bt.constructionAndConversion;

import tree.Node;
import tree.Util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ravikanth on 5/12/2018.
 */
public class q2 {

    public Node build(int[] inorder, int[] levelorder) {
        if (levelorder.length == 0) return null;
        Node root = new Node(levelorder[0]);
        Queue<Node> currLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();

        int[] inorderMark = new int[inorder.length];

        currLevel.add(root);
        mark(inorder, root.data, inorderMark);

        Node curr;
        int currIdx = 1;

        while (!currLevel.isEmpty()) {

            while (!currLevel.isEmpty()) {
                curr = currLevel.remove();
                if (hasLeft(curr, inorder, inorderMark)) {
                    curr.left = new Node(levelorder[currIdx++]);
                    nextLevel.add(curr.left);
                    mark(inorder, curr.left.data, inorderMark);
                }

                if (hasRight(curr, inorder, inorderMark)) {
                    curr.right = new Node(levelorder[currIdx++]);
                    nextLevel.add(curr.right);
                    mark(inorder, curr.right.data, inorderMark);
                }
            }

            Queue<Node> temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;

        }
        return root;
    }

    private boolean hasLeft(Node node, int[] inorder,  int[] inorderMark){
        int idx = find(inorder, node.data);
        return  (idx > 0 && inorderMark[idx - 1] != Integer.MAX_VALUE);
    }

    private boolean hasRight(Node node, int[] inorder, int[] inorderMark){
        int idx = find(inorder, node.data);
        return  (idx < inorder.length - 1 && inorderMark[idx + 1] != Integer.MAX_VALUE);
    }

    private void mark(int[] A, int el, int[] mark){
        int i = find(A, el);
        mark[i] = Integer.MAX_VALUE;
    }

    private int find(int[] A, int el){
        for (int i = 0; i < A.length; i++) {
            if (A[i] == el) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int in[]    = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};

        q2 test = new q2();
        Node node = test.build(in, level);

        Util.printInorderWithRecursion(node);
    }
}
