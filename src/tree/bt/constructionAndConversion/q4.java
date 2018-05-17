package tree.bt.constructionAndConversion;

import tree.Node;

/**
 * Created by Ravikanth on 5/13/2018.
 */
public class q4 {

    public Node build(int[] pre, int[] post){
        return build(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private Node build(int[] pre, int[] post, int preL, int preR, int postL, int postR ){
        if (isInvalid(pre, preL, preR) || isInvalid(post, postL, postR) || size(pre, preL, preR) != size(post, postL, postR)){
            return null;
        }else {
            Node node = new Node(pre[preL]);
            int L = findSize(pre, post, preL,postR);
            node.left = build(pre, post, preL + 1, preL + L, postR - L, postR - 1);
            node.right = build(pre, post, preL + L + 1, preR, postL, postR - L - 1);
            return node;
        }
    }


    private int findSize(int[] pre, int[] post, int preL, int postR){
        int size = 0;
        for (int i = preL + 1, j = postR - 1; pre[i] == post[j]; i++, j--){
            size++;
        }
        return size;
    }


    private boolean isInvalid(int[] A, int left, int right){
        return false;
    }

    private int size(int[] A, int l, int r){
        return r - l + 1;
    }

    public static void main(String[] args) {

    }
}
