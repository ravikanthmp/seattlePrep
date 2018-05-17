package stack.operations;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/8/2018.
 */
public class q31 {

    private boolean pairWiseConsequtive(Stack<Integer> stack) {
        if (stack.size() > 1) {
            if (stack.size() % 2 == 0) {
                return pairWiseConsequtiveInternal(stack, stack.size(), 1);
            } else {
                Integer pop = stack.pop();
                boolean ans = pairWiseConsequtiveInternal(stack, stack.size(), 1);
                stack.push(pop);
                return ans;
            }
        } else {
            return true;
        }

    }

    private boolean pairWiseConsequtiveInternal(Stack<Integer> stack, int stackLength, int depth) {
        Integer top = stack.pop();
        Integer bottom = stack.pop();
        boolean ans;

        if (depth + 1 == stackLength) {
           ans = Math.abs(top - bottom) == 1 ? true : false;
        } else {
           ans = pairWiseConsequtiveInternal(stack, stackLength, depth + 2);
           return ans && Math.abs(top - bottom) == 1 ? true : false;
        }
        stack.push(bottom);
        stack.push(top);

        return ans;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] a =  {4, 5, -2, -3, 11, 10, 5, 6, 20};
        for (int i : a) stack.push(i);
        q31 test = new q31();
        System.out.println(test.pairWiseConsequtive(stack));
    }
}
