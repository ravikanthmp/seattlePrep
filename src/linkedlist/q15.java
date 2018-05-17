package linkedlist;

/**
 * Created by Ravikanth on 4/24/2018.
 */
public class q15 {

    private int loop(LinkedList list) {
        if (list != null && list.head != null && list.head.next != null) {

            Node slow = list.head;
            Node fast = slow.next.next;

            while (slow != null && fast != null) {
                if (slow == fast) {

                    return 1;
                }
            }


        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
