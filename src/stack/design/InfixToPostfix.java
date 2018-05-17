package stack.design;

import stack.Stack;

/**
 * Created by Ravikanth on 5/1/2018.
 */
public class InfixToPostfix {


    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        try {
            System.out.println(infixToPostfix.convertInfixToPostfix("A*(B+C)/D"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String convertInfixToPostfix(String infix) throws Exception {
        StringBuilder sb = new StringBuilder();
        Stack<Operator> stack = new Stack<>();

        for (char c : infix.toCharArray()){
            if (isOperand(c)){
                sb.append(c);
            }else {
                Operator op = Operator.create(c);
                if (op == null) throw new UnsupportedOperationException("Invalid operand! " + c);
                while (!stack.isEmpty() && compare(op, stack.peek()) >= 0){
                    Operator pop = stack.pop();

                    if (!pop.equals(Operator.LeftBrace)){
                        sb.append(pop.getSymbol());
                    }
                }
                if (!op.equals(Operator.RightBrace)){
                    stack.push(op);
                }
            }
        }
        while (!stack.isEmpty()){
            Operator pop = stack.pop();

            if (!pop.equals(Operator.LeftBrace)){
                sb.append(pop.getSymbol());
            }
        }
        return sb.toString();
    }


    private int compare(Operator op1, Operator op2){
        return Integer.compare(op1.priority(), op2.priority());
    }

    private boolean isOperand(char ch){
        Operator[] values = Operator.values();
        for (Operator op : values){
            if (op.getSymbol() == ch){
                return false;
            }
        }
        return true;
    }

    enum Operator{

        Divide{
            @Override
            int priority() {
                return 4;
            }

            @Override
            char getSymbol() {
                return '/';
            }
        },
        Multiply{
            @Override
            int priority() {
                return 3;
            }

            @Override
            char getSymbol() {
                return '*';
            }
        },
        Addition{
            @Override
            int priority() {
                return 2;
            }

            @Override
            char getSymbol() {
                return '+';
            }
        },
        Subtraction{
            @Override
            int priority() {
                return 1;
            }

            @Override
            char getSymbol() {
                return '-';
            }
        },
        LeftBrace{
            @Override
            int priority() {
                return 10;
            }

            @Override
            char getSymbol() {
                return '(';
            }
        },
        RightBrace{
            @Override
            int priority() {
                return 10;
            }

            @Override
            char getSymbol() {
                return ')';
            }
        };

        abstract int priority();
        abstract char getSymbol();

        public static Operator create(char ch){
            for (Operator operator : Operator.values()) {
                if (ch == operator.getSymbol()){
                    return operator;
                }
            }
            return null;
        }
    }
}
