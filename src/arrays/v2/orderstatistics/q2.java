package arrays.v2.orderstatistics;

import java.util.PriorityQueue;

/**
 * Created by Ravikanth on 4/18/2018.
 */
public class q2 {

    class Pair implements Comparable<Pair> {
        int row, column;
        int value;

        public Pair(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(value, o.value);
        }
    }

    private int kthsmallest(int[][] a, int n, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(0, i, a[0][i]));
        }

        int i = 0;
        Pair removed = null;
        while (i != k) {
            removed = pq.remove();
            if (removed.row != n - 1) {
                pq.add(new Pair(removed.row + 1, removed.column, a[removed.row + 1][removed.column]));
            }
            i++;
        }

        if (i < k) {
            while (i != k) {
                removed = pq.remove();
                i++;
            }
        }

        return removed.value;
    }


    public static void main(String[] args) {

        int mat[][] = {{10, 20},
                {25, 35}
        };

        q2 test = new q2();
        try {
            System.out.println(test.kthsmallest(mat, mat.length, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
