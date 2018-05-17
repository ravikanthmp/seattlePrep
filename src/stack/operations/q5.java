package stack.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Ravikanth on 5/3/2018.
 */
public class q5 {

    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();
    Stack<Integer> third = new Stack<>();


    Map<Stack, String> map = new HashMap<>();

    public void towersOfHanoi(int N){

        towersOfHanoi(N, 'A', 'B', 'C');
    }

    private void towersOfHanoi(int N, char A, char B, char C){
        if (N > 0){
            towersOfHanoi(N - 1, A, C, B);
            System.out.println("Move " + N + " from :" + A + " to: " + B);
            towersOfHanoi(N - 1, C, B, A);
        }
    }

    public static void main(String[] args) {
        q5 test = new q5();
        test.towersOfHanoi(4);
    }

}
