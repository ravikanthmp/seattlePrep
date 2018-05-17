package stack;

/**
 * Created by Ravikanth on 5/2/2018.
 */
public class Util {

    public static void sort(Stack<Comparable> stack) throws Exception {
        if (!stack.isEmpty()){
            Comparable top = stack.pop();
            sort(stack);
            insert(stack, top);
        }
    }

    private static void insert(Stack<Comparable> stack, Comparable x) throws Exception {
        if (stack.isEmpty() || stack.peek().compareTo(x) <= 0){
            stack.push(x);
        }else {
            Comparable top = stack.pop();
            insert(stack, x);
            stack.push(top);
        }
    }
}
