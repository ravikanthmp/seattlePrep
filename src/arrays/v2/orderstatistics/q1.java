package arrays.v2.orderstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/18/2018.
 */
public class q1 {

    private void maxKElementsInternalQuickPartition(int[] a, int k) {

        int p;
        int lo = 0, hi = a.length - 1;

        while ((p = partitionGlobal(a, lo, hi)) != k) {
            if (p > k) hi = p - 1;
            else lo = p + 1;
        }

        Arrays.sort(a, 0, k );

        StringBuilder sb = new StringBuilder();
        for (int i = k - 1; i >= 0 ; i--) {
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private void maxKElementsInternalQuickPartitionHeap(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() < a[i]) {
                    pq.remove();
                    pq.add(a[i]);
                }
            } else {
                pq.add(a[i]);
            }
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            pq2.add(pq.remove());
        }

        while (!pq2.isEmpty()) {
            sb.append(pq2.remove()).append(" ");
        }

        System.out.println(sb.toString());
    }

    private void maxKElements(int[] a, int k) {
        maxKElementsInternalQuickPartition(a, k);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q1 test = new q1();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int K = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                test.maxKElements(arr, K);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int partitionGlobal(int[] a, int lo, int hi) {
        if (a == null) return -1;
        if (lo == hi) return lo;

        int pivot = a[lo];

        int i = lo;

        for (int j = lo + 1; j <= hi; j++) {
            if (a[j] >= pivot) {
                swap(a, ++i, j);
            }
        }

        swap(a, lo, i);

        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
