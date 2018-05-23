package string.basics;

/**
 * Created by Ravikanth on 5/22/2018.
 */
public class TernaryST implements StringST {
    class Node{
        Node left, right, bottom;
        char c;
        Object val;

        public Node(char c) {
            this.c = c;
        }
    }

    Node root;

    @Override
    public Object get(String key) {
        Node ans = get(root, key, 0);
        return ans == null ? null : ans.val;
    }

    public Node get(Node node, String key, int d){
        if (node == null || d == key.length()) return null;
        char curr = node.c;
        char lookingfor = key.charAt(d);
        if (curr == lookingfor){
            if (d == key.length() - 1){
                return node;
            }else {
                return get(node.bottom, key, d + 1);
            }
        }else if (lookingfor > curr){
            return get(node.right, key, d);
        }else {
            return get(node.left, key, d);
        }
    }

    @Override
    public void put(String key, Object value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node curr, String key, Object v, int d){
        if (curr == null){
            curr = new Node(key.charAt(d));
        }

        if (d == key.length() - 1){
            curr.val = v;
            return curr;
        }else {
            char ch = key.charAt(d);
            if (ch == curr.c){
                curr.bottom = put(curr.bottom, key, v, d + 1);
            }else if (ch < curr.c){
                curr.left = put(curr.left, key, v, d);
            }else {
                curr.right = put(curr.right, key, v, d);
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        String[] dict = "hello there this is Ravikanth".split(" ");
        int i = 0;

        TernaryST tst = new TernaryST();
        for (String s : dict) {
            tst.put(s, i++);
        }


        for (String s : dict) {
            System.out.println(tst.get(s));
        }
    }
}
