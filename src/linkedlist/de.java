package linkedlist;

/**
 * Created by Ravikanth on 4/24/2018.
 */


import java.util.*;
import linkedlist.q16.Node;

class MergeLists
{

    private Node head;

    public void addToTheLast(q16.Node node)
    {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }



    /* Driver program to test above functions */
    public static void main(String args[])
    {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            MergeLists llist1 = new MergeLists();
            MergeLists llist2 = new MergeLists();

            int a1=sc.nextInt();
            Node head1= new Node(a1);
            llist1.addToTheLast(head1);
            if (sc.hasNextInt())
                for (int i = 1; i < n1; i++)
                {
                    //int a;

                    int a = sc.nextInt();
                    llist1.addToTheLast(new Node(a));
                }


            int b1=sc.nextInt();
            Node head2 = new Node(b1);
            llist2.addToTheLast(head2);
            if (sc.hasNextInt())
                for (int i = 1; i < n2; i++)
                {
                    //int b;

                    int b = sc.nextInt();
                    llist2.addToTheLast(new Node(b));
                }
            llist1.head= new q16().MergeLists(llist1.head,llist2.head);
            llist1.printList();
            //System.out.println();
            t--;

        }




    }
}

