package tree.bt.constructionAndConversion;

import tree.Node;
import tree.Util;

/**
 * Created by Ravikanth on 5/12/2018.
 */
public class q1 {


    public Node build(int[] inorder, int[] preorder) {
        Node root = build(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    private Node build(int[] inorder, int[] preorder, int ileft, int iright, int pleft, int pright) {
        if (isLegit(preorder, pleft, pright) && isLegit(inorder, ileft, iright)) {
            Node root = new Node(preorder[pleft]);
            int idx = find(inorder, ileft, iright, root.data);
            int L = idx - ileft;

            root.left = build(inorder, preorder, ileft, idx - 1, pleft + 1, pleft + L);
            root.right = build(inorder, preorder, idx + 1, iright, pleft + L + 1, pright);

            return root;

        } else return null;
    }


    private int find(int[] A, int l, int r, int el) {
        for (int i = l; i <= r; i++) {
            if (A[i] == el) return i;
        }
        return -1;
    }


    private boolean isLegit(int[] A, int left, int right) {
        return left >= 0 && left <= right;
    }

    public static void main(String[] args) {
        int in[] = new int[]{1, 2, 3};
        int pre[] = new int[]{3, 2, 1};
        q1 test = new q1();
        Node build = test.build(in, pre);
        Util.printInorderWithRecursion(build);
    }
}
