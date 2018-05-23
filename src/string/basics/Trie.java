package string.basics;

/**
 * Created by Ravikanth on 5/22/2018.
 */
public class Trie implements StringST {

    int R = 256;
    Node root;

    class Node {
        Object val;
        Node[] next = new Node[R];
    }

    @Override
    public Object get(String key) {
        Node ans = get(root, key, 0);
        return ans == null ? null : ans.val;
    }

    public Node get(Node root, String key, int d) {
        if (root == null) return null;
        if (d == key.length()) {
            return root;
        } else {
            return get(root.next[key.charAt(d)], key, d + 1);
        }
    }

    @Override
    public void put(String key, Object value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node root, String key, Object value, int d) {
        if (root == null) {
            root = new Node();
        }

        if (d == key.length()) {
            root.val = value;
        } else {
            root.next[key.charAt(d)] = put(root.next[key.charAt(d)], key, value, d + 1);
        }
        return root;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] dict = "hello there this is Ravikanth".split(" ");
        int i = 0;
        for (String s : dict) {
            trie.put(s, i++);
        }
        for (String s : dict) {
            System.out.println(trie.get(s));
        }

    }
}
