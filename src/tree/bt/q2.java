package tree.bt;

import tree.BinaryTree;
import tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Ravikanth on 5/9/2018.
 */
public class q2 {

    public static void levelOrder(Node root){
        Queue<Node> currentLevel = new LinkedList();
        Queue<Node> nextLevel = new LinkedList();
        Queue<Node> temp;
        Node removed;

        StringBuilder sb = new StringBuilder();

        if (root != null){
            currentLevel.add(root);

            while (!currentLevel.isEmpty()){
                while (!currentLevel.isEmpty()){
                    removed = currentLevel.remove();
                    sb.append(removed.data).append(" ");

                    if ( removed.left != null ){
                        nextLevel.add(removed.left);
                    }

                    if (removed.right != null){
                        nextLevel.add(removed.right);
                    }
                }

//                sb.append("\n");

                temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }

        System.out.println(sb.toString());
    }

    void levelOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        Node right;
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
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        q2 test = new q2();
        test.levelOrderIterative(tree.root);

    }

}
