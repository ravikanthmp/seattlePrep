package linkedlist;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/24/2018.
 */
public class q16 {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    public Node MergeLists(Node headA, Node headB) {
        Node resultHead = null, resultTail = null;

        while (headA != null || headB != null) {
            if (headA == null) {
                if (resultTail != null) {
                    resultTail.next = new Node(headB.data);
                    resultTail = resultTail.next;
                } else {
                    resultTail = new Node(headB.data);
                    resultHead = resultTail;
                }
                headB = headB.next;
            } else if (headB == null) {
                if (resultTail != null) {
                    resultTail.next = new Node(headA.data);
                    resultTail = resultTail.next;
                } else {
                    resultTail = new Node(headA.data);
                    resultHead = resultTail;
                }
                headA = headA.next;
            } else if (headA.data <= headB.data) {
                if (resultTail != null) {
                    resultTail.next = new Node(headA.data);
                    resultTail = resultTail.next;
                } else {
                    resultTail = new Node(headA.data);
                    resultHead = resultTail;
                }
                headA = headA.next;
            } else {
                if (resultTail != null) {
                    resultTail.next = new Node(headB.data);
                    resultTail = resultTail.next;
                } else {
                    resultTail = new Node(headB.data);
                    resultHead = resultTail;
                }
                headB = headB.next;
            }


        }

        return resultHead;
    }


    public Node deleteAlt(Node head){
        Node curr = head;
        if (curr != null){
            while (curr.next != null){
                curr.next = curr.next.next;
                curr = curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
//        Node n1 = new Node(2);
//        n1.next = new Node(3);
//        n1.next.next = new Node(4);
//        n1.next.next.next = new Node(10);
//        n1.next.next.next.next = new Node(12);
//        n1.next.next.next.next.next = new Node(110);
//        n1.next.next.next.next.next.next = new Node(102);
//
//
//        Node n2 = new Node(1);
//        n2.next = new Node(5);
//        n2.next.next = new Node(14);
//
//        q16 test = new q16();
//        Node node = test.deleteAlt(n1);
//
//
//        StringBuilder sb = new StringBuilder();
//        while (node != null) {
//            sb.append(node.data).append(" ");
//            node = node.next;
//        }
//
//        System.out.println(sb.toString());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            q16 test = new q16();
            Node dummy = new Node(0);
            Node curr = dummy;
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    curr.next = new Node(Integer.parseInt(stringTokenizer.nextToken()));
                    curr = curr.next;
                }

                Node node = test.deleteAlt(dummy.next);
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
