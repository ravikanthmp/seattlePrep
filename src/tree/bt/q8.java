package tree.bt;

import tree.Node;
import tree.Util;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/10/2018.
 */
public class q8 {

    public void postorder(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        if (root != null) stack1.push(root);

        Node curr;

        while (!stack1.isEmpty()){
            curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack2.isEmpty()){
            sb.append(stack2.pop().data).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        q8 test = new q8();
        test.postorder(Util.createSampleBinaryTreeBigly().root);
    }
}
