package tree.bt;

import tree.BinaryTree;
import tree.Node;
import tree.Util;

/**
 * Created by Ravikanth on 5/10/2018.
 */
public class q5 {

    public void morrisInorder(Node root){
        Node curr = root;
        Node pred;

        StringBuilder sb = new StringBuilder();

        while (curr != null){
            if (curr.left == null){
                sb.append(curr.data).append(" ");
                curr = curr.right;
            }else {
                pred = findPredecessor(curr);
                if (pred.right != null){
                    sb.append(curr.data).append(" ");
                    pred.right = null;
                    curr = curr.right;
                }else {
                    pred.right = curr;
                    curr = curr.left;
                }
            }
        }

        System.out.println(sb.toString());
    }

    private Node findPredecessor(Node root){
        Node curr = root.left;
        while (curr.right != null && curr.right != root) {
            curr = curr.right;
        }
        return curr;
    }


    public static void main(String[] args) {
        BinaryTree sampleBinaryTree = Util.createSampleBinaryTree();
        q5 test = new q5();
        test.morrisInorder(sampleBinaryTree.root);
    }
}
