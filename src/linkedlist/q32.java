package linkedlist;

import arrays.Util;
import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * Created by Ravikanth on 4/25/2018.
 */
public class q32 {

    class Pair {
        int idx, value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    private int[] nge(LinkedList a) {
        int[] nge = new int[a.lengthIter()];
        Stack<Pair> integerStack = new Stack<>();
        if (a.lengthIter() > 0) {
            integerStack.push(new Pair(0, a.head.data));
            Node curr = a.head.next;
            for (int i = 1; curr != null; i++, curr = curr.next) {

                while (!integerStack.isEmpty() && integerStack.peek().value < curr.data) {
                    nge[integerStack.pop().idx] = i;
                }

                integerStack.push(new Pair(i, curr.data));
            }

            while (!integerStack.isEmpty()) {
                nge[integerStack.pop().idx] = -1;
            }

        }

        return nge;
    }

    public LinkedList deleteToRight(LinkedList list){
        int[] nge = nge(list);
        Node dummy = new Node(0, list.head);
        Node dummyOrig = dummy;
        Node prev = dummy;
        Node curr = dummy.next;

        int i = 0;

        while (curr != null){

            if (nge[i] != -1){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            i++;
            curr = curr.next;
        }

        list.tail = prev;
        list.head = dummyOrig.next;

        return list;
    }

    public static void main(String[] args) {

        int[] a = Util.generateArray(StdIn.readInt());
        LinkedList list = new LinkedList();


        for (int i : a){
            list.insert(i);
        }

        System.out.println(list);


        q32 test = new q32();
        System.out.println(Util.print(test.nge(list)));;
        LinkedList linkedList = test.deleteToRight(list);
        System.out.println(linkedList);

    }
}
