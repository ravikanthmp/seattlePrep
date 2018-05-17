package arrays.v2.orderstatistics;

import java.util.Arrays;

/**
 * Created by Ravikanth on 4/19/2018.
 */
public class q7 {

    private void largest3(int[] a){
        int fromEnd = 3;
        select(a, a.length - fromEnd, 0, a.length -1 );
        Arrays.sort(a, a.length - fromEnd, a.length);

        StringBuilder sb = new StringBuilder();
        for (int i = a.length - 1; i >= a.length - fromEnd; i--) {
            sb.append(a[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private void select(int[] a, int k, int lo, int hi){

        int p = partition(a, 0, a.length - 1);
        while (p != k){
            if (p > k){
                p = partition(a, lo, p - 1);
            }else {
                p = partition(a, p + 1, hi);
            }
        }
    }

    private int partition(int[] a, int lo, int hi){
        int pivot = a[lo];
        int i = lo + 1;
        int j = lo;

        while (i <= hi){
            if (a[i] < pivot) exch(a, ++j, i++);
            else i++;
        }

        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {10, 4, 3, 50, 23, 90};
        q7 test = new q7();
        test.largest3(arr);

    }
}
