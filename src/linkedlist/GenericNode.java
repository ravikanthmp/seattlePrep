package linkedlist;

/**
 * Created by Ravikanth on 4/30/2018.
 */
public class GenericNode<Item> {
    Node next, bottom;
    Item data;

    public GenericNode(Item data, Node next) {
        this.next = next;
        this.data = data;
    }



    public GenericNode(Item data) {
        this.data = data;
    }
}

