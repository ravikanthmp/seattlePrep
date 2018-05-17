package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/26/2018.
 */
public class q34 {

    private void detectAndRemove(Node node) {

        int length = loopLength(node);
        removeLoopNode(node, length);
        print(node);
    }

    private void print(Node node, int length) {
        if (length == -1){
            System.out.println(0);
        }else {
            System.out.println(1);
        }
    }


    public void print(Node node) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (node != null && i < 100) {
            sb.append(node.data).append(" ");
            node = node.next;
            i++;
        }
        System.out.println(sb.toString());
    }

    private void removeLoopNode(Node node, int length) {
        if (length != -1) {
            Node ptr1 = node;
            Node ptr2 = next(node, length);

            while (ptr1.next != ptr2.next) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            ptr2.next = null;
        }

    }

    private Node next(Node node, int length) {
        for (int i = 0; i < length; i++) {
            node = node.next;
        }
        return node;
    }

    private int loopLength(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null) return -1;
        else {
            Node fixedLoc = slow;
            Node other = fixedLoc;
            int length = 1;
            while (other.next != fixedLoc){
                other = other.next;
                length++;
            }
            return length;
        }
    }

    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            int T = Integer.parseInt(br.readLine());
//            q34 test = new q34();
//
//            StringTokenizer stringTokenizer = null;
//            for (int i = 0; i < T; i++) {
//                Node dummy = new Node(0);
//                Node curr = dummy;
//                stringTokenizer = new StringTokenizer(br.readLine());
//                int N = Integer.parseInt(stringTokenizer.nextToken());
//                stringTokenizer = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    curr.next = new Node(Integer.parseInt(stringTokenizer.nextToken()));
//                    curr = curr.next;
//                }
//
//                test.detectAndRemove(dummy.next);
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        int[] a = {2, 3, 5, 7, 9, 10, 11,12, 13, 14, 15};
        Node dummy = new Node(0);
        Node curr = dummy;
        for (int i : a){
            curr.next = new Node(i);
            curr = curr.next;
        }



        Node last = curr;

        curr = dummy;
        for (int i = 0; i < 3; i++) {
            curr = curr.next;
        }
        last.next = curr;

        q34 test = new q34();

        test.print(dummy.next);
        test.detectAndRemove(dummy.next);


    }
}
