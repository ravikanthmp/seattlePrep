package arrays.v2.orderstatistics;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Ravikanth on 4/20/2018.
 */
public class Q10 {

    class Pair {
        int start, end;


        public Pair(int start, int end) {
            this.start = start;
            this.end = end;;
        }

        public boolean belongs(int k) {
            return (k >= start && k <= end);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    class Pair2 implements Comparable<Pair2>{
        int i , j;
        int[] arr;

        @Override
        public int compareTo(Pair2 o) {
            return Integer.compare(arr[j] - arr[i], o.arr[o.i] - o.arr[o.j]);
        }
    }

    public void kthSmallest(int[] a, int k) {

        if (k <= 0 || k > (a.length)*(a.length-1)/2) try {
            throw new Exception("Invalid Input");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Arrays.sort(a);

        int N = a.length;
        int start = 1;
        int end = N - 1;
        int numPairs = N - 1;
        int incr = 1;

        Pair p = new Pair(start, end);

        while (!p.belongs(k)){
            incr++;
            numPairs = (N - 1) - incr;
            p.start = end + 1;
            p.end = p.start + numPairs;
        }

        int min = Integer.MAX_VALUE;

        if (incr > a.length - 2){
            try {
                throw new Exception("Somrthing went wrong!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        Pair minPair = new Pair(0, Integer.MAX_VALUE);
        for (int i = 0; i < a.length - incr - 1; i++) {
            if (a[i + incr] - a[i] < minPair.end - minPair.start){
                minPair.end = a[i + incr];
                minPair.start  = a[i];
            }
        }

        System.out.println(minPair);


    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int k = 3;
        Q10 test = new Q10();
        test.kthSmallest(a, k);
    }

}
