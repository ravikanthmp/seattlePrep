package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/25/2018.
 */
public class q33 {

    public static class Node {
        Node next;
        int data;

        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public Node segregate(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        // find Tail
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node origTail = curr;
        Node tail = origTail;

        // segregate
        Node dummy = new Node(0, head);
        Node prev = dummy;
        curr = head;

        while (curr != origTail) {
            if (curr.data % 2 != 0) {
                prev.next = curr.next;
                tail.next = curr;
                curr.next = null;
                curr = prev.next;
                tail = tail.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        if (origTail.data % 2 != 0 && origTail.next != null) {
            prev.next = curr.next;
            tail.next = curr;
            curr.next = null;
            tail = tail.next;
        }

        return dummy.next;
    }

    public Node segregate2(Node head){

        if (head == null) return null;
        Node dummy = new Node(0, head);
        Node evenDummy, oddDummy;
        evenDummy = new Node(0);
        oddDummy = new Node(0);
        Node oddCurrent = oddDummy;
        Node evenCurrent = evenDummy;

        Node prev = dummy;
        Node curr = head;

        while (curr != null){
            if (curr.data % 2 != 0){
                oddCurrent.next = curr;
                prev.next = curr.next;
                oddCurrent = oddCurrent.next;
                oddCurrent.next = null;
            }else {
                evenCurrent.next = curr;
                prev.next = curr.next;
                evenCurrent = evenCurrent.next;
                evenCurrent.next = null;
            }
            curr = prev.next;
        }

        evenCurrent.next = oddDummy.next;
        return evenDummy.next;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            q33 test = new q33();

            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                Node dummy = new Node(0);
                Node curr = dummy;
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    curr.next = new Node(Integer.parseInt(stringTokenizer.nextToken()));
                    curr = curr.next;
                }

                q33.Node node = test.segregate2(dummy.next);
                StringBuilder sb = new StringBuilder();
                while (node != null) {
                    sb.append(node.data).append(" ");
                    node = node.next;
                }

                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
