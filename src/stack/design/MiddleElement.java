package stack.design;

import arrays.Util;

/**
 * Created by Ravikanth on 4/30/2018.
 */
public class MiddleElement {

    class DLLNode{
        DLLNode left, right;
        int data;

        public DLLNode(int data) {
            this.data = data;
        }
    }

    private int size;

    private DLLNode head, tail, middle;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DLLNode curr = head; curr != null; curr = curr.right){
            sb.append(curr.data).append(" ");
        }
        return sb.toString();
    }

    public void push(int data){
        DLLNode node = new DLLNode(data);
        if (size == 0){
            head = node;
            tail = node;
            middle = head;
        }else {
            node.right = head;
            head.left = node;
            head = node;
            if (size % 2 == 0){
                middle = middle.left;
            }
        }
        size++;
    }

    public int pop() throws Exception{
        if (size == 0) throw new Exception("pop called on an empty Doubly Linked List");
        DLLNode ans = head;
        head = head.right;
        if (size % 2 != 0){
            middle = middle.right;
        }
        size--;
        return ans.data;
    }

    public int findMiddle() throws  Exception{
        if (size == 0) throw new Exception("findMiddle called on an empty DLL");
        else return middle.data;
    }

    public static void main(String[] args) {
        int[] ints = Util.generateArray(10);
        System.out.println(Util.print(ints));
        MiddleElement myStack = new MiddleElement();
        for (int i : ints){
            myStack.push(i);
            System.out.println("Stack " + myStack);
            try {
                System.out.println("Middle Element: " + myStack.findMiddle());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
