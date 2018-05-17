package stack;


import arrays.Util;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Ravikanth on 4/30/2018.
 */
public class Stack<Item> implements Iterable<Item>{

    LinkedList<Item> list = new LinkedList();

    public void push(Item item) {
        list.addFirst(item);
    }

    public Item pop() throws Exception {
        if (isEmpty()) throw new Exception("Pop called oin empty stack");

        Item i = list.removeFirst();
        return i;
    }

    public Item peek() throws Exception {
        if (isEmpty()) throw new Exception("Peek called oin empty stack");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item i : list){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        int[] ints = Util.generateArray(5);
        Stack<Integer> integerStack = new Stack<>();
        int N = StdIn.readInt();
        for (int i = 0; i < N; i++) {
            if (StdRandom.uniform() < 0.5){

                integerStack.push(StdRandom.uniform(1000));
            }
            else{

                try {
                    System.out.println(integerStack.pop());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println(integerStack.toString());
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return list.iterator();
    }

    public Iterator<Item> reverseIterator() {
        return list.descendingIterator();
    }
}
