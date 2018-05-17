package stack.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Ravikanth on 5/8/2018.
 */
public class q25 {

    private boolean checkPermutation(int[] original, int[] result){

        int ch;
        int checkIdx;

        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < original.length   ; i++) {
            map.put(original[i], i);
        }

        for (int i = 0; i < result.length; i++) {
            ch = result[i];
            checkIdx = map.get(ch);

            if (!stack.isEmpty() && checkIdx < stack.peek()){
                return false;
            }else if (!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }else {
                int si = stack.isEmpty() ? 0 : stack.peek() + 1;
                for (int j = si; j < checkIdx; j++) {
                    stack.push(j);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        q25 test = new q25();
        int input[] = {1, 2, 3};

        // Output Queue
        int output[] = {3, 1, 2};

        System.out.println(test.checkPermutation(input, output));

    }
}
