package linkedlist;

/**
 * Created by Ravikanth on 4/24/2018.
 */
public class q25 {

    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    class LinkedList
    {
        Node head;  // head of list
    }

    int intersectPoint(Node headA, Node headB)
    {
       if (headA != null && headB != null){
           int ALength = 0;
           while (headA != null){
               ALength++;
               headA = headA.next;
           }

           int BLength = 0;
           while (headB != null){
               BLength++;
               headB = headB.next;
           }

           boolean ALonger = ALength > BLength;

           if (ALonger){
               for (int i = 0; i < ALength - BLength; i++) {
                   headA = headA.next;
               }
           }else {
               for (int i = 0; i < BLength - ALength; i++) {
                   headB = headB.next;
               }
           }

           while (headA != null && headB != null){
               if (headA == headB){
                   return headA.data;
               }else {
                   headA = headA.next;
                   headB = headB.next;
               }
           }


       }
        return -1;
    }

}
