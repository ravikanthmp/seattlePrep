package linkedlist;

import arrays.*;
import arrays.Util;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Ravikanth on 4/26/2018.
 */
public class q39 {

    private Node rotate(Node head, int k){

        if (head == null) return null;

        Node kthEl = head;
        for (int i = 0; i < k - 1; i++) {
            kthEl = kthEl.next;
        }

        Node newhead = kthEl.next;
        if (newhead != null){
            Node curr = newhead;
            while (curr.next != null){
                curr = curr.next;
            }
            kthEl.next = null;
            curr.next = head;
            head = newhead;

        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] ints = Util.generateArray(StdIn.readInt());
        for (int anInt : ints) {
            list.insert(anInt);
        }

        System.out.println(Util.print(ints));

        q39 test = new q39();

        list.head = test.rotate(list.head, 3);

        linkedlist.Util.print(list.head);
    }
}
