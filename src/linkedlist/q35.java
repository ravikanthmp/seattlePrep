package linkedlist;

/**
 * Created by Ravikanth on 4/26/2018.
 */
public class q35 {

    public Node add(Node n1, Node n2){
        Node ans = new Node(0);
        Node dummyHead = ans;

        int colSum = 0;
        int carry = 0;

        while (n1 != null && n2 != null){
            colSum = carry + n1.data + n2.data;
            ans.next = new Node(colSum % 10);
            carry = colSum / 10;
            n1 = n1.next;
            n2 = n2.next;
            ans = ans.next;
        }

        Node longerNumber = n1 == null ? n2 : n1;

        while (longerNumber != null){
            colSum = carry + longerNumber.data;
            ans.next = new Node(colSum % 10);
            carry = colSum / 10;
            longerNumber = longerNumber.next;
            ans = ans.next;
        }

        return dummyHead.next;

    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        int[] a = {8, 4};
        int[] b = {7, 5, 9, 4, 6};

        for (int i : a) {
            l1.insert(i);
        }

        for (int i : b) {
            l2.insert(i);
        }

        q35 test = new q35();
        Node add = test.add(l1.head, l2.head);

        Util.print(add);
    }
}
