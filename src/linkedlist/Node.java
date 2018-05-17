package linkedlist;

/**
 * Created by Ravikanth on 4/25/2018.
 */
public class Node {
    Node next, bottom;
    int data;

    public Node(int data, Node next) {
        this.next = next;
        this.data = data;
    }



    public Node(int data) {
        this.data = data;
    }
}
