package arrays.v2.orderstatistics;

import java.util.Stack;

/**
 * Created by Ravikanth on 4/23/2018.
 */
public class q33 {

    public void rmeovekSmaller(int[] a, int k) {

        Stack<Integer> stack = new Stack<>();
        int r = 0;

        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && r < k && a[i] > stack.peek()){
                stack.pop();
            }
            stack.push(a[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int j : stack) {
            sb.append(j).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int arr[] = {23, 45, 11, 77, 18};
        q33 test = new q33();
        test.rmeovekSmaller(arr, 3);
    }
}
