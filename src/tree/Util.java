package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ravikanth on 5/9/2018.
 */
public class Util {

    public static BinaryTree createSampleBinaryTree(){
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        return tree;
    }

    public static BinaryTree createSampleBinaryTreeBigly(){
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        tree.root.right.left= new Node(6);
        tree.root.right.right= new Node(7);


        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
//
//
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);

        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);

        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);
//
//
//        tree.root.left.left.right.right = new Node(12);
//
//        tree.root.left.left.right.right.left = new Node(13);
//        tree.root.left.left.right.right.right = new Node(14);

        return tree;
    }

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

                sb.append("\n");

                temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }

        System.out.println(sb.toString());
    }

    public static void printInorderWithRecursion(Node root){
        StringBuilder sb = new StringBuilder();
        printInorderWithRecursion(root, sb);
        System.out.println(sb.toString());
    }

    private static void printInorderWithRecursion(Node node, StringBuilder sb){
        if (node != null){
            printInorderWithRecursion(node.left, sb);
            sb.append(node.data).append(" ");
            printInorderWithRecursion(node.right, sb);
        }
    }
}
