package stack.design;

import stack.Stack;

import java.util.Iterator;

/**
 * Created by Ravikanth on 4/30/2018.
 */
public class Queue<Item> {

    private Stack<Item> stack1 = new Stack<>();
    private Stack<Item> stack2 = new Stack<>();

    public void enque(Item item){
        stack1.push(item);
    }

    public Item deque() throws Exception {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int size(){
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       for (Item i : stack2){
           sb.append(i).append(" ");
       }

        for (Iterator<Item> it = stack1.reverseIterator(); it.hasNext(); ) {
            Item i = it.next();
            sb.append(i).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Queue q = new Queue();
        q.enque(1);
        System.out.println(q);
        q.enque(2);
        System.out.println(q);
        q.enque(3);
        System.out.println(q);

        System.out.println("Deque");
        /* Dequeue items */
        System.out.println(q.deque() + " ");
        System.out.println(q.deque() + " ");
        System.out.println(q.deque() + " ");
    }
}
