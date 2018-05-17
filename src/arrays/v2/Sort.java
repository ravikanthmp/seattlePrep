package arrays.v2;

import arrays.Util;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Ravikanth on 4/17/2018.
 */
public class Sort {

    class QSort extends RecursiveAction {

        public QSort(int[] a, int lo, int hi) {
            this.a = a;
            this.lo = lo;
            this.hi = hi;
        }

        private int[] a;
        private int lo, hi;

        @Override
        protected void compute() {
            if (lo >= hi) return;

            // System.out.println(Util.print(a) + " pivot = " + a[lo] + " lo = " + lo + " hi = " + hi);
            int i = lo + 1;
            int pivot = a[lo];
            int lt = lo, gt = hi + 1;
            int cmp;

            while (i < gt) {
                cmp = compare(a[i], pivot);
                if (cmp == 0) i++;
                else if (cmp < 0) exch(a, i++, ++lt);
                else exch(a, --gt, i);
            }

            exch(a, lo, lt);

            QSort leftArray = new QSort(a, lo, lt - 1);
            QSort rightArray = new QSort(a, gt, hi);

            leftArray.fork();
            rightArray.exec();
            leftArray.join();
        }
    }

    private void q3sort(int[] a) {
        q3sort(a, 0, a.length - 1);
//        QSort qs = new QSort(a, 0, a.length - 1);
//        ForkJoinPool.commonPool().invoke(qs);
//        qs.join();
    }

    private void q3sort(int[] a, int lo, int hi) {

        if (lo >= hi) return;

      //  System.out.println(Util.print(a) + " pivot = " + a[lo] + " lo = " + lo + " hi = " + hi);
        int i = lo + 1;
        int pivot = a[lo];
        int lt = lo, gt = hi;
        int cmp ;

        while (i <= gt){
            cmp = compare(a[i], pivot);
            if (cmp == 0) i++;
            else if (cmp < 0) exch(a, i++, ++lt);
            else exch(a, gt--, i);
        }

        exch(a, lo, lt);

        q3sort(a, lo, lt - 1);
        q3sort(a, gt + 1, hi);

//        if (lo >= hi) return;
//
//        // System.out.println(Util.print(a) + " pivot = " + a[lo] + " lo = " + lo + " hi = " + hi);
//        int i = lo + 1;
//        int pivot = a[lo];
//        int lt = lo, gt = hi + 1;
//        int cmp;
//
//        while (i < gt) {
//            cmp = compare(a[i], pivot);
//            if (cmp == 0) i++;
//            else if (cmp < 0) exch(a, i++, ++lt);
//            else exch(a, --gt, i);
//        }
//
//        exch(a, lo, lt);
//
//        q3sort(a, lo, lt - 1);
//        q3sort(a, gt, hi);
    }


    private int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public void test(int T, int[] a) throws Exception {

        Stopwatch stopwatch;
        double time, totalTime = 0;
        for (int i = 0; i < T; i++) {
            StdRandom.shuffle(a);
            stopwatch = new Stopwatch();
            q3sort(a);
            time = stopwatch.elapsedTime();
            if (!Util.isSorted(a)) {
                System.out.println(Util.print(a));
                throw new Exception("Fail!");
            }
            totalTime += time;
        }

        System.out.println("Total time = " + totalTime);
        System.out.println("Average time = " + totalTime / T);
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(1000);
        }
        Sort test = new Sort();

        try {
            test.test(StdIn.readInt(), a);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(Util.isSorted(a));
//        System.out.println(Util.print(a));
    }
}
