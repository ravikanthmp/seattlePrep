package tree.bt;


/**
 * Created by Ravikanth on 5/11/2018.
 */
public class q14 {

    static class Node{
        Node left, right, parent;
        int data;

        public Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public void printInorder(Node root){
        Node curr = root;
        if (curr != null){
            while (curr.left != null) curr = curr.left;
            StringBuilder sb = new StringBuilder();
            for (Node n = curr; n != null; n = successor(n)){
                sb.append(n.data).append(" ");
            }
            System.out.println(sb.toString());
        }

    }

    public Node successor(Node node){
        Node curr = node;
        if (node == null) return null;
        if (curr.right != null){
            curr = curr.right;
            while (curr.left != null) curr = curr.left;
            return curr;
        }
        while (curr.parent != null && curr == curr.parent.right){
            curr = curr.parent;
        }
        return curr.parent;
    }

    public static Node createSampleBinaryTreeBigly(){
        Node root = new Node(1, null);
        root= new Node(1, null);
        root.left= new Node(2, root);
        root.right= new Node(3, root);
        root.left.left= new Node(4, root.left);
        root.left.right= new Node(5, root.left);

        root.right.left= new Node(6, root.right);
        root.right.right= new Node(7, root.right);

        root.left.left.left = new Node(8, root.left.left);
        root.left.left.right = new Node(9, root.left.left);

        root.left.left.left.left = new Node(10, root.left.left.left);
        root.left.left.left.right = new Node(11, root.left.left.left);

        root.left.left.right.left = new Node(13, root.left.left.right);
        root.left.left.right.right = new Node(14, root.left.left.right);

        return root;
    }

    public static void main(String[] args) {
        Node root = createSampleBinaryTreeBigly();
        q14 test = new q14();
        test.printInorder(root);
    }
}
