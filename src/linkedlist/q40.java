package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Ravikanth on 4/26/2018.
 */
public class q40 {
    Node head;

    static class Node {
        Integer data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    public Node flatten(Node head) {
        head = process(head);
        return head;
    }

    private Node process(Node head) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i.data));
        Node ans = new Node(0);
        Node solnHead = ans;

        for (Node curr = head; curr != null; curr = curr.next) {
            minHeap.add(curr);
        }

        while (!minHeap.isEmpty()) {
            ans.next = minHeap.remove();
            ans = ans.next;

            if (ans.bottom != null) {
                minHeap.add(ans.bottom);
            }

            ans.next = null;
        }

        return solnHead.next;
    }

    public void printList(Node node) {
        StringBuilder sb = new StringBuilder();
        for (Node curr = node; curr != null; curr = curr.next) {
            sb.append(curr.data).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        q40 list = new q40();
        while (t > 0) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();

            Node root = list.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}
