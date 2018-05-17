package tree.bt;

import java.util.Stack;
import tree.BinaryTree;
import tree.Node;
import tree.Util;

/**
 * Created by Ravikanth on 5/9/2018.
 */
public class q4 {

    private void printInorderWithRecursion(Node root){
        StringBuilder sb = new StringBuilder();
        printInorderWithRecursion(root, sb);
        System.out.println(sb.toString());
    }

    private void printInorderWithRecursion(Node node, StringBuilder sb){
        if (node != null){
            printInorderWithRecursion(node.left, sb);
            sb.append(node.data).append(" ");
            printInorderWithRecursion(node.right, sb);
        }
    }

    private void printInorderWithoutRecursion(Node node){
        Stack<Node> stack = new Stack<>();
        Node curr = node;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }


        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            curr = stack.pop();
            sb.append(curr.data).append(" ");
            curr = curr.right;
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BinaryTree sampleBinaryTree = Util.createSampleBinaryTreeBigly();
        q4 test = new q4();
        test.printInorderWithRecursion(sampleBinaryTree.root);
        test.printInorderWithoutRecursion(sampleBinaryTree.root);
    }
}
