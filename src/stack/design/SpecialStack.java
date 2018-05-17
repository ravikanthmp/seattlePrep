package stack.design;

import stack.Stack;

/**
 * Created by Ravikanth on 4/30/2018.
 */
public class SpecialStack<Item extends Comparable> extends Stack<Item>{

    class Node{
        Item item;
        Item prevMin;

        public Node(Item item) {
            this.item = item;
            prevMin = minSoFar;
        }
    }

    private Stack<Node> stack = new Stack<>();

    Item minSoFar;

    @Override
    public void push(Item item) {
        Node currItem = new Node(item);
        stack.push(currItem);
        if (stack.size() == 1){
            minSoFar = item;
        }else {
            minSoFar = (item.compareTo(minSoFar) < 0) ? item : minSoFar;
        }
    }

    @Override
    public Item pop() throws Exception {
        Node pop = stack.pop();
        if (stack.size() != 0){
            Node peek = stack.peek();
            minSoFar =  peek.item.compareTo(peek.prevMin) < 0 ? peek.item : peek.prevMin;
        }

        return pop.item;
    }


    public Item getMin() throws Exception{
        if (stack.size() == 0){
            throw new Exception("getMin() called on empty stack");
        }

        return minSoFar;
    }

    public static void main(String[] args) throws Exception {
        SpecialStack<Integer> integers = new SpecialStack<>();
        int[] a = {18, 19, 29, 15, 16};
        for (int i : a){
            integers.push(i);
        }

        System.out.println(integers.getMin());

        System.out.println(integers.pop());
        System.out.println(integers.pop());

        System.out.println(integers.getMin());
    }
}
