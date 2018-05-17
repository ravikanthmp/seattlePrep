package linkedlist;

import arrays.Util;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Ravikanth on 4/24/2018.
 */
public class LinkedList {
    public LinkedList(){

    }

    public static LinkedList create(int[] a){
        return new LinkedList(a);
    }

    public LinkedList(int[] a){
        for (int i : a){
            insert(i);
        }
    }


    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }


    Node head, tail;
    int count;

    public void insert(int data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
        } else {
            tail.next = new Node(data, null);
            tail = tail.next;
        }

        count++;
    }


    public void insertFront(int data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
        } else {
            head = new Node(data, head);
        }
        count++;
    }

    public void delete(int key) {
        Node curr = head;
        Node prev = null;

        while (curr != null && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            if (prev == null) {
                head = curr.next;
            } else {
                prev.next = curr.next;
            }
            count--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node n = head; n != null; n = n.next) {
            sb.append(n.data).append(" ");
        }
        return sb.toString();
    }

    public int length() {
        return length(head);
    }

    public int lengthIter() {
        int i = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            i++;
        }
        return i;
    }

    private int length(Node n) {
        return n == null ? 0 : 1 + length(n.next);
    }

    public void deleteAt(int index) {
        if (index >= count || index < 0) {
            try {
                throw new Exception("Invalid Index!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int i = 0;
        Node n, prev = null;
        for (n = head; n != null && i < index; n = n.next, i++) {
            prev = n;
        }

        if (prev == null) {
            head = n.next;
        } else {
            prev.next = n.next;
        }
        count--;
    }

    public void swap(int x, int y) {
        Node c = head, prev = null;
        while (c != null && (c.data != x && c.data != y)) {
            prev = c;
            c = c.next;
        }

        Node c2 = null, prev2 = null;
        if (c != null) {
            c2 = c.next;
            prev2 = c2;
            while (c2 != null && (c2.data != x && c2.data != y)) {
                prev2 = c2;
                c2 = c2.next;
            }
        }

        if (c != null && c2 != null) {

            if (tail == c2) {
                tail = c;
            }

            if (c.next == c2) {
                if (prev != null) {
                    prev.next = c2;
                } else {
                    head = c2;
                }
                c.next = c2.next;
                c2.next = c;
            } else {
                if (prev != null) {
                    prev.next = c2;
                } else {
                    head = c2;
                }
                prev2.next = c;
                Node temp = c2.next;
                c.next = c2.next;
                c2.next = temp;
            }

        }
    }

    private void reverse() {
        if (head != null) {
            Node temp = tail;
            tail = reverse(head);
            head = temp;
        }
    }

    public void reverseIter() {
        if (head != null && head.next != null) {
            Node prevPrev = null, prev = head, curr = head.next, next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev.next = prevPrev;
                prevPrev = prev;
                prev = curr;
                curr = next;
            }
            Node temp = tail;
            tail = head;
            head = temp;
        }
    }

    private Node reverse(Node n) {
        if (n.next == null) return n;
        else {
            Node ans;

            reverse(n.next).next = n;
            n.next = null;
            return n;
        }
    }

    public static void main(String[] args) {
        int[] a = Util.generateArray(StdIn.readInt());
        //    System.out.println(Util.print(a));
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        for (int i : a) {
            list.insert(i);

        }

        System.out.println(list);
//        list.swap(4, 23);
//
//        list.deleteAt(0);
//
//        list.swap(4, 23);
//
        list.reverseIter();
        System.out.println(list);
    }
}
