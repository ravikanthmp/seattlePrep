package arrays.v2.orderstatistics;

import arrays.Util;

import edu.princeton.cs.algs4.RedBlackBST;

/**
 * Created by Ravikanth on 4/21/2018.
 */
public class q23 {

    private void countSmaller(int[] a){
        int[] smaller = new int[a.length];

        RedBlackBST bst = new RedBlackBST();
        bst.put(a[a.length - 1], 1);

        int rank;
        for (int i = a.length - 2; i >= 0 ; i--) {
            rank = bst.rank(a[i]);
            smaller[i] = rank;
            bst.put(a[i], 1);
        }

        System.out.println(Util.print(smaller));
    }

    public static void main(String[] args) {

        int arr[] =  {12, 1, 2, 3, 0, 11, 4};
        q23 test = new q23();
        test.countSmaller(arr);
    }
}
