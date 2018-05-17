package arrays.v2.orderstatistics;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Ravikanth on 4/20/2018.
 */
public class q9 {

    class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x +
                    ", " + y +
                    ']';
        }
    }

    private int rank(int[] a , int el){
        int lo = 0, hi = a.length - 1, mid, soln = 0;
        while (lo <= hi){
            mid = lo + (hi - lo)/2;
            if (el >= a[mid]){
                soln = mid;
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return soln + 1;
    }

    public void findPairs(int[] a, int[] b, int k){
        int count = 0;
        int rank;
        Set<Pair> set = new LinkedHashSet<>();
        int t;
        for (int i = 0; i < a.length && count < k; i++) {

            if (i != a.length - 1){
                rank = rank(b, a[i+1] + b[0] - a[i]);
                t = Math.min(rank, k - count);
                for (int j = 0; j < t; j++, count++) {
                    set.add(new Pair(a[i], b[j]));
                }
            }else {
                t = Math.min(b.length, k - count);
                for (int j = 0; j < t; j++, count++) {
                    set.add(new Pair(a[i], b[j]));
                }
            }
        }

        for (Pair p : set){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 11};
        int arr2[] = {2, 4, 8};
        q9 test = new q9();
        test.findPairs(arr1, arr2, 4);
    }

}
