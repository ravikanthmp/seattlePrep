package arrays.v1.rearrangement;

import arrays.Util;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Ravikanth on 2/27/2018.
 */
public class SortByAbsoluteDiff {

    private int absValue;

    public void sort(int[] a){
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi){
        if (lo >= hi) return;

        int partition = partition(a, lo, hi);

        sort(a, lo, partition - 1);
        sort(a, partition + 1, hi);
    }

    private int partition(int[] a, int lo, int hi){

        int m = lo ;
        int i = lo + 1;

        while (i <= hi){
            if (comp(a, i, lo) < 0){
                Util.swap(a, ++m, i);
            }
            i++;
        }
        Util.swap(a, lo, m);
        return m;
    }

    private int comp(int[] a, int i, int j){
        return Integer.compare(Math.abs(absValue - a[i]), Math.abs(absValue - a[j])) ;
    }

    public SortByAbsoluteDiff(int absValue){
        this.absValue = absValue;
    }

    public static void main(String[] args) {
        int absVal = StdIn.readInt();

        int N = StdIn.readInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(-1*N, N);
        }
        SortByAbsoluteDiff sortByAbsoluteDiff = new SortByAbsoluteDiff(absVal);

      //  System.out.println(Util.print(a));
        sortByAbsoluteDiff.sort(a);
       // System.out.println(Util.print(a));

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < a.length; i++) {
//            sb.append(Math.abs(absVal - a[i])).append(" ");
//        }
//        System.out.println(sb.toString());

        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i] - absVal) < Math.abs(a[i-1] - absVal)) {
                System.out.println("false");
                break;
            }
        }



    }
}

