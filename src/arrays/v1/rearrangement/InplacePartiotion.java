package arrays.v1.rearrangement;

import arrays.Util;

import edu.princeton.cs.algs4.*;

/**
 * Created by Ravikanth on 2/25/2018.
 */
public class InplacePartiotion {

    private int[] aux;

    private void rearrange(int[] a) {

        aux = new int[a.length];
        rearrange(a, 0, a.length - 1);
    }

    private void rearrange(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;

        rearrange(a, lo, mid);
        rearrange(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }

    private void merge(int[] a, int lo, int mid, int hi) {

        System.arraycopy(a, lo, aux, lo, hi - lo + 1);

        int len = hi - lo + 1;
        int i = lo, j = mid + 1, k = 0;

        while (k < len) {
            if (i == mid + 1) {
                a[lo + k++] = aux[j++];
            } else if (j > hi) {
                a[lo + k++] = aux[i++];
            } else {

                if (sameSign(aux[i], aux[j])) {
                    a[lo + k++] = aux[i++];
                } else {
                    a[lo + k++] = (aux[i] < aux[j]) ? aux[i++] : aux[j++];
                }
            }
        }
    }

    private boolean sameSign(int a, int b) {
        return ((a >= 0 && b >= 0) || (a < 0 && b < 0));
    }

    public static void main(String[] args) {

        int N = StdIn.readInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(-20, 20);
        }
        System.out.println(Util.print(a));
        InplacePartiotion inplacePartiotion = new InplacePartiotion();
        inplacePartiotion.rearrange2(a, 0, a.length - 1);
        System.out.println(Util.print(a));
    }































    private static int rearrange2(int[] a , int lo, int hi){
        if (lo > hi) return 0;
        if (lo == hi){
            return a[lo] <= 0 ? 1 : 0;
        }else{
            int mid = lo + (hi - lo)/2;

            int left = rearrange2(a, lo, mid);
            int right = rearrange2(a, mid + 1, hi);
            return merge(a, lo, mid, hi, left, right);
        }
    }

    private static int merge(int[] a, int lo, int mid, int hi, int left, int right) {
        // rev a[lo + left -1, mid]
        Util.reverse(a, lo + left, mid);

        // rev a[mid + 1, hi]
        Util.reverse(a, mid + 1, mid + right);

        // rev a[lo + left - 1, mid + right - 1]
        Util.reverse(a, lo + left, mid + right);

        return left + right;
    }

}
