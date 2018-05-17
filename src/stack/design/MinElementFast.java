package stack.design;

import linkedlist.LinkedList;
import stack.Stack;

/**
 * Created by Ravikanth on 5/1/2018.
 */
public class MinElementFast {

    private int min, size;

    public MinElementFast() {
        min = 0;
    }

    LinkedList list = new LinkedList();
    Stack<Integer> stack = new Stack<>();

    public int pop() throws Exception {
        int ans = stack.pop();
        int diff;
        if (ans < min){
            diff = min - ans;
            return ans + 2*diff;
        }else {
            diff = ans - min;
            int temp = min;
            min = min + diff;

            return temp;
        }

    }

    public int size() {
        return stack.size();
    }

    public void push(int data) {
        if (size() == 0){
            min = data;
            stack.push(data);
        }else {
            if (data < min){
                int diff = min - data;
                min = data;
                stack.push(data + diff);
            }else {
                int diff = data - min;
                stack.push(min - diff);
            }
        }
    }

    public int peek() throws Exception {
        int ans = stack.peek();
        if (ans < min){
            return ans + 2*(min - ans);
        }else {
            return min;
        }
    }

    public int getMin() throws Exception {
        return min;
    }

    public static void main(String[] args) throws Exception {
        MinElementFast integers = new MinElementFast();
        int[] a = {18, 19, 29, 15, 16};
        for (int i : a){
            integers.push(i);
        }

//        System.out.println(integers.stack);
      while (integers.size() != 0){
          System.out.println("Min: " + integers.getMin() + " Pop: " + integers.pop());
      }
    }
}
