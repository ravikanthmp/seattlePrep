package tree.bt;

import java.util.Stack;

import tree.BinaryTree;
import tree.Node;
import tree.Util;

/**
 * Created by Ravikanth on 5/10/2018.
 */
public class q6 {

    public void preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if (root != null){
            Node curr;
            stack.push(root);
            while (!stack.isEmpty()){
                curr = stack.pop();
                sb.append(curr.data).append(" ");
                if (curr.right != null){
                    stack.push(curr.right);
                }
                if (curr.left != null){
                    stack.push(curr.left);
                }

            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BinaryTree sampleBinaryTree = Util.createSampleBinaryTree();
        q6 test = new q6();
        test.preorder(sampleBinaryTree.root);
    }
}
