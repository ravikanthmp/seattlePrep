package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class q28 {

    class IndexedPair implements Comparable<IndexedPair>{
        int idx, val, col;

        public IndexedPair(int idx, int val, int col) {
            this.idx = idx;
            this.val = val;
            this.col = col;
        }

        @Override
        public int compareTo(IndexedPair o) {
            return Integer.compare(val, o.val);
        }
    }

    private List<Integer> mergeKSorted(int[][] arrays, int k){

        PriorityQueue<IndexedPair> minHeap = new PriorityQueue<>(arrays.length);
        for (int i = 0; i < k; i++) {
            minHeap.add(new IndexedPair(i, arrays[i][0], 0));
        }

        ArrayList<Integer> b = new ArrayList<>();
        int minRow, minCol;
        IndexedPair removedPair;
        for (int i = 0; i < k*k; i++) {
            removedPair = minHeap.remove();
            b.add(removedPair.val);
            minRow = removedPair.idx;
            minCol = removedPair.col;

            if (minCol != k - 1){
                minCol++;
                minHeap.add(new IndexedPair(minRow, arrays[minRow][minCol], minCol));
            }
        }

        return b;
    }


    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[][] arr ;
            q28 test = new q28();

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                String[] string = br.readLine().split(" ");
                int k =0;
                arr = new int[N][N];
                for (int j = 0; j < N; j++) {
                    for (int l = 0; l < N; l++) {
                        arr[j][l] = Integer.parseInt(string[k]);
                        k++;
                    }
                }
            //    System.out.println((print(test.mergeKSorted(arr,N))));;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
