package stack.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 5/4/2018.
 */
public class q10 {

    public int maxLength(String s) {

        Stack<Integer> stack = new Stack<>();
        char c ;
        int maxSoFar = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ')'){
                if (stack.size() > 1  && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    maxSoFar = Math.max(maxSoFar, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }else {
                stack.push(i);
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q10 test = new q10();
            for (int i = 0; i < T; i++) {

                System.out.println(test.maxLength(br.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
