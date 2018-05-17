package stack.operations;

import arrays.Util;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/2/2018.
 */
public class q1 {

    public void reverse(Stack<Integer> stack){
        if (!stack.isEmpty()){
            int top = stack.pop();
            reverse(stack);
            insertAtBottom(stack, top);
        }
    }


    private void insertAtBottom(Stack<Integer> stack, int x){
        if (stack.isEmpty()){
            stack.push(x);
        }else {
            int top = stack.pop();
            insertAtBottom(stack, x);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        int[] ints = Util.generateArray(10);
        Stack<Integer> stack = new Stack<>();
        for (int i : ints) {
            stack.push(i);
        }

        System.out.println(stack);


        q1 test = new q1();
        test.reverse(stack);

        System.out.println(stack);
    }
}
