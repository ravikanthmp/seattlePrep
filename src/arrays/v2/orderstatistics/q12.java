package arrays.v2.orderstatistics;

import java.util.*;

/**
 * Created by Ravikanth on 4/20/2018.
 */
public class q12 {


    class Pair implements Comparable<Pair> {

        int val, freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair o) {
            int cmp = Integer.compare(freq, o.freq);
            if (cmp == 0) {
                cmp = Integer.compare(val, o.val);
            }
            return cmp;
        }
    }

    private int floor(int[] a, int k) {
        int el = a[k];
        int lo = 0, hi = a.length - 1, mid, sol = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] >= el) {
                hi = mid - 1;

            } else {
                sol = mid;
                lo = mid + 1;
            }
        }
        return sol + 1;
    }

    private int ceil(int[] a, int k) {
        int el = a[k];
        int lo = 0, hi = a.length - 1, mid, sol = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] > el) {

                sol = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return a.length - sol;
    }


    public void maxKPairs(int[] a, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Arrays.sort(a);
        int f, c, num;

        for (int i = 0; i < a.length; i++) {
            f = floor(a, i);
            c = ceil(a, i);
            num = Math.abs(f - c) + 1;

            if (pq.size() == k && pq.peek().freq < num) {
                pq.remove();
                pq.add(new Pair(a[i], num));
            } else if (pq.size() < k) {
                pq.add(new Pair(a[i], num));
            }
        }

        Stack<Integer> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push(pq.remove().val);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

    public void maxkPairsEasy(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])){
                map.put(a[i], 1);
            }else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Pair pair;
        for (Integer key : map.keySet()){

            if (pq.size() < k){
                pq.add(new Pair(key, map.get(key)));
            }else {
                pair = new Pair(key, map.get(key));
                if (pq.peek().compareTo(pair) < 0){
                    pq.remove();
                    pq.add(pair);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push(pq.remove().val);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        q12 test = new q12();
        test.maxkPairsEasy(arr, 4);
    }
}
