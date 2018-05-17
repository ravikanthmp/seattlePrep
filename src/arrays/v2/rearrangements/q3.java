package arrays.v2.rearrangements;

import arrays.Util;

/**
 * Created by Ravikanth on 4/1/2018.
 */
public class q3 {

    public static int rearrange(int[] a, int lo, int hi){
        if (lo == hi){
            return a[lo] <= 0 ? 1 : 0;
        }

        int mid = lo + (hi - lo)/2;

        int left = rearrange(a, lo, mid);
        int right = rearrange(a, mid + 1, hi);

        merge(a, lo, mid, hi, left, right);

        return left + right;
    }

    private static void merge(int[] a, int lo, int mid, int hi, int left, int right){

        Util.reverse(a, lo + left, mid);
        Util.reverse(a, mid + 1, mid + right);
        Util.reverse(a, lo + left, mid + right);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, -1, 0, 2, -5, -7};
        System.out.println(Util.print(a));
        rearrange(a, 0, a.length -1 );
        System.out.println(Util.print(a));
    }
}
