package arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Ravikanth on 2/28/2018.
 */
public class Sort {

    public static void quick(int[] a, int num){
        //quick(a, 0, a.length -1);
        quick3(a, 0, a.length -1, num);
    }

    private static void quick(int[] a, int lo, int hi){
        if (lo >= hi) return;

        System.out.println("sort lo : " + lo + " hi: " + hi);
        int pivot = partition(a, lo, hi);
        quick(a, lo, pivot - 1);
        quick(a, pivot + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi){

        int m = lo , i = lo, pivot = a[lo];

        while (i <= hi){
            if (a[i] < pivot){
                Util.swap(a, i, ++m);
            }
            i++;
        }
        Util.swap(a, m, lo);
        return m;
    }


    private static void quick3(int[] a, int lo, int hi, int num){
        if (lo >= hi) return;

        int lt = lo, gt = hi, i = lo + 1;
        int pivot = a[lo];

        int cmp;

        while (i <= gt){
            cmp = Integer.compare(Math.abs(a[i] - num), Math.abs(num - pivot));
            if (cmp == 0){
                i++;
            }else if (cmp < 0){
                Util.swap(a, i++, lt++);
            }else {
                Util.swap(a, i, gt--);
            }
        }

        quick3(a, lo, lt - 1, num);
        quick3(a, gt + 1, hi, num);
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(-10, 10);
        }
        quick(a, 20);
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]){
                System.out.println(a[i] + " : " + a[i - 1]);
                System.out.println("----FAIL-----");
            }
        }
    }

}
