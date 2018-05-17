package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravikanth on 4/27/2018.
 */
public class q38 {

    private void threeSum(Node n1, Node n2, Node n3, int totalSum) {
        Map<Integer, Node[]> map = new HashMap<>();
        int sum;
        for (Node c1 = n1; c1 != null; c1 = c1.next) {

            for (Node c2 = n2; c2 != null; c2 = c2.next) {
                map.put(c1.data + c2.data, new Node[]{c1, c2});
            }
        }

        for (Node c3 = n3; c3 != null; c3 = c3.next) {
            if (map.containsKey(totalSum - c3.data)) {
                Node[] nodes = map.get(totalSum - c3.data);
                System.out.println(nodes[0].data + ", " + nodes[1].data + ", " +c3.data);
                return;
            }
        }

        System.out.println("No Key Pair found!");
    }

    public static void main(String[] args) {
        int[] a = {12, 6, 29};
        int[] b = {23, 5, 8};
        int[] c = {90, 20, 59};

        LinkedList list = LinkedList.create(a);
        LinkedList list1 = LinkedList.create(b);
        LinkedList list2 = LinkedList.create(c);

        q38 test = new q38();
        test.threeSum(list.head, list1.head, list2.head, 101);

    }

}
