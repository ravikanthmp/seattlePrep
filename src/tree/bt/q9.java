package tree.bt;

import java.util.Stack;
import tree.Node;
import tree.Util;

/**
 * Created by Ravikanth on 5/10/2018.
 */
public class q9 {

    public void reverseLevelOrder(Node node){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node curr;


        s1.push(node);

        StringBuilder sb = new StringBuilder();

        boolean ulta = false;

        while (!s1.isEmpty()){

            while (!s1.isEmpty()){
                curr = s1.pop();
                sb.append(curr.data).append(" ");

                if (ulta){
                    if (curr.right != null){
                        s2.push(curr.right);
                    }

                    if (curr.left != null){
                        s2.push(curr.left);
                    }
                }else {
                    if (curr.left != null){
                        s2.push(curr.left);
                    }

                    if (curr.right != null){
                        s2.push(curr.right);
                    }
                }
            }

            ulta = !ulta;
            sb.append("\n");


            Stack temp = s1;
            s1 = s2;
            s2 = temp;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        q9 test = new q9();
        test.reverseLevelOrder(Util.createSampleBinaryTreeBigly().root);
    }
}
