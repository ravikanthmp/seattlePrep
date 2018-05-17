package linkedlist;

import arrays.Util;

/**
 * Created by Ravikanth on 4/27/2018.
 */
public class q45 {

    private Node dummyStart = new Node(0), resultHead;

    private Node qsort(Node head, Node tail) {
        //    linkedlist.Util.print(head);

        Node ans;
        if (head == null || tail == null || head == tail) return null;
        Node pivot = head;
        System.out.println("Partitioning on pivot: " + pivot.data + " tail: " + tail.data);
        Node lesser = dummyStart;
        dummyStart.next = null;
        Node prev = pivot, curr = prev.next;
        int left, right = 0;

        while (curr != null) {

            if (curr.data < pivot.data) {
                lesser.next = curr;
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
                lesser = lesser.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        lesser.next = pivot;

        ans = dummyStart.next;
        if (dummyStart.next != pivot) qsort(dummyStart.next, lesser);
        Node head2 = qsort(pivot.next, tail);
        lesser.next = head2;
        System.out.println("Returning head " + ans.data);
        linkedlist.Util.print(ans);
        return ans;
    }

    public Node qsort(Node head) {
        if (head == null) return null;

        Node tail = head;
        while (tail.next != null) tail = tail.next;

        return qsort(head, tail);
    }

    public static void main(String[] args) {
        int[] ints = Util.generateArray(3);
        System.out.println(Util.print(ints));

        q45 test = new q45();
        LinkedList list = LinkedList.create(ints);

        Node ans = test.qsort(list.head);
        linkedlist.Util.print(ans);


    }
}
