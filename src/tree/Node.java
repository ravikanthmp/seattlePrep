package tree;

/**
 * Created by Ravikanth on 5/9/2018.
 */
public class Node {
    public Node left, right;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
    }
}
