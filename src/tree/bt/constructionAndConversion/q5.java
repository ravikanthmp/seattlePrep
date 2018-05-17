package tree.bt.constructionAndConversion;

import tree.Node;
import tree.Util;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/13/2018.
 */
public class q5 {

    public Node build(int[] pre, char[] preLN) {
        Stack<Node> currStack = new Stack<>();
        int idx = 0;
        Node root = new Node(pre[idx]);
        Node curr;
        if (preLN[idx] != 'L') {
            currStack.push(root);
            for (int i = idx + 1; i < pre.length; i++) {
                curr = currStack.pop();
                Node newNode = new Node(pre[i]);
                if (curr.left == null){
                    curr.left = newNode;
                    currStack.push(curr);
                }else {
                    curr.right = newNode;
                }

                if (preLN[i] == 'N') {
                     currStack.push(newNode);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int  pre[] = {10, 30, 20, 5, 15};
        char preLN[] = {'N', 'N', 'L', 'L', 'L'};
        q5 test = new q5();
        Node root = test.build(pre, preLN);
        Util.printInorderWithRecursion(root);
    }
}
