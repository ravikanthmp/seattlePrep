package stack.operations;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/7/2018.
 */
public class q21 {

    public String decodeString(String s) {
        Stack<String> tokenStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int currNumber = 0;

        StringBuilder sb = new StringBuilder();
        String processedToken;
        int repeatTimes;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(currNumber);
                currNumber = 0;
                tokenStack.push(String.valueOf(c));
            } else if (c >= '0' && c <= '9') {
                currNumber *= 10;
                currNumber += Character.getNumericValue(c);
            } else if (c == ']'){
                processToken(tokenStack, numStack);
            } else {
                tokenStack.push(String.valueOf(c));
            }
        }

        sb = new StringBuilder();
        while (!tokenStack.isEmpty()) {
            sb.insert(0, tokenStack.pop());
        }
        return sb.toString();
    }


    private void processToken(Stack<String> tokenStack, Stack<Integer> numStack) {
        StringBuilder sb = new StringBuilder();
        String processedToken;
        int repeatTimes;
        sb = new StringBuilder();
        while (!tokenStack.peek().equals("[")) {
            sb.insert(0, tokenStack.pop());
        }
        tokenStack.pop();

        processedToken = sb.toString();
        repeatTimes = numStack.pop();

        tokenStack.push(doAppend(processedToken, repeatTimes));
    }

    private String doAppend(String processedToken, int repeatTimes) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < repeatTimes; i++) {
            sb.append(processedToken);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        q21 test = new q21();

        System.out.println(test.decodeString("100[leetcode]"));
    }
}
