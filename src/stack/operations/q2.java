package stack.operations;

import arrays.Util;
import stack.Stack;

/**
 * Created by Ravikanth on 5/2/2018.
 */
public class q2 {

    private void sort(Stack<Integer> stack) throws Exception {
        if (!stack.isEmpty()){
            int top = stack.pop();
            sort(stack);
            insert(stack, top);
        }
    }

    private void insert(Stack<Integer> stack, int x) throws Exception {
        if (stack.isEmpty() || stack.peek() <= x){
            stack.push(x);
        }else {
            int top = stack.pop();
            insert(stack, x);
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

        q2 test = new q2();
        try {
            test.sort(stack);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stack);
    }
}
