package tree.bt.constructionAndConversion;

import tree.Node;
import tree.Util;

/**
 * Created by Ravikanth on 5/12/2018.
 */
public class q3 {

    int lCounter = 0;

    public Node build(int[] inorder, int[] levelorder){
            Node ans = build(inorder, levelorder, 0, inorder.length - 1, lCounter);
            return ans;
    }

    private Node build(int[] inorder, int[] levelorder, int ileft, int iright, int lleft){
        if (lCounter >= levelorder.length) return null;
        int root = levelorder[lCounter];
        Node curr = new Node(root);

        int idx = find(inorder, ileft, iright, levelorder[lleft]);
        int L = idx - ileft;
        if (L > 0){
            lCounter++;
            curr.left = build(inorder, levelorder, ileft, idx - 1, lCounter);
        }
        int R = iright - idx;
        if (R > 0){
            lCounter++;
            curr.right = build(inorder, levelorder, idx + 1, iright, lCounter);
        }

        return curr;
    }

    private int find(int[] A, int l, int r, int el){
        for (int i = l; i<= r; i++){
            if (A[i] == el ) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int in[]    = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};
        q3 test = new q3();
        Node node = test.build(in, level);
        Util.printInorderWithRecursion(node);
    }

}
