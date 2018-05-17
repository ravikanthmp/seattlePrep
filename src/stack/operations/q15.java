package stack.operations;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/6/2018.
 */
public class q15 {

    public boolean hasDuplicateParanthesis(String S){
        Stack<String> operands = new Stack<>();
        Stack<Character> ops = new Stack<>();

        char ch;

        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (ch == '+' || ch == '('){
                ops.push(ch);
            }else if (ch == ')'){
                if (operands.isEmpty()) return true;
                else {
                    while (ops.peek() != '('){
                        if (operands.size() >= 2)
                            operands.push(operands.pop() + " " + operands.pop() + " " + ops.pop());
                        else return true;
                    }
                    if (!operands.isEmpty())ops.pop();
                    else return true;
                }
            }else {
                operands.push(String.valueOf(ch));
            }

        }
        return false;
    }

    public static void main(String[] args) {
        q15 test = new q15();
        String s ="(((a+(b))+c+d))";
        System.out.println(test.hasDuplicateParanthesis(s));;
    }
}
