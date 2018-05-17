package linkedlist;

/**
 * Created by Ravikanth on 4/28/2018.
 */
public class q46 {

    private void merge(Node n1, Node n2) {
        Node temp1, temp2;
        Node head1 = n1;

        while (n1 != null && n2 != null) {
            temp1 = n1.next;
            n1.next = n2;
            temp2 = n2.next;
            n2.next = temp1;
            n2 = temp2;
            n1 = n1.next.next;
        }

        print(head1);

        print(n2);

    }

    private void print(Node head){
        StringBuilder sb = new StringBuilder();
        for (Node curr = head; curr != null; curr = curr.next){
            sb.append(curr.data).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        LinkedList list = LinkedList.create(new int[]{1, 2, 3, 4, 5});
        LinkedList list2 = LinkedList.create(new int[]{6, 7});

        q46 test = new q46();
        test.merge(list.head, list2.head);
    }
}
