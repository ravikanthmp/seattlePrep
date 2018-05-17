package tree.bt;

import tree.BinaryTree;
import tree.Node;
import tree.Util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ravikanth on 5/11/2018.
 */
public class q19 {

    public void print(Node root){

        LinkedList<Node> forward = new LinkedList<>();
        LinkedList<Node> reverse = new LinkedList<>();
        LinkedList<Node> forwardTemp = new LinkedList<>();
        LinkedList<Node> reverseTemp = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        if (root!= null){
            sb.append(root.data).append("\n");

            if (root.left != null){
                forward.add(root.left);
                reverse.add(root.right);

                Node front, back;

                while (!forward.isEmpty()){


                    while (!forward.isEmpty()){
                        front = forward.remove();
                        back = reverse.removeLast();

                        sb.append(front.data).append(" ");
                        sb.append(back.data).append(" ");

                        if (front.left != null){
                            forwardTemp.addLast(front.left);
                            forwardTemp.addLast(front.right);
                        }

                        reverseTemp.addFirst(back.right);
                        reverseTemp.addFirst(back.left);


                    }
                    sb.append("\n");

                    LinkedList temp;
                    temp = forward;
                    forward = forwardTemp;
                    forwardTemp = temp;

                    temp = reverse;
                    reverse = reverseTemp;
                    reverseTemp = temp;

                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BinaryTree sampleBinaryTreeBigly = Util.createSampleBinaryTreeBigly();
        q19 test = new q19();
        test.print(sampleBinaryTreeBigly.root);

    }

}
