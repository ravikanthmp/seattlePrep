package linkedlist;

/**
 * Created by Ravikanth on 4/26/2018.
 */
public class Util {

    public static void print(Node node) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (node != null && i < 100) {
            sb.append(node.data).append(" ");
            node = node.next;
            i++;
        }
        System.out.println(sb.toString());
    }
}
