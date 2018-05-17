package arrays.v2.rearrangements;

import arrays.Util;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravikanth on 4/8/2018.
 */
public class q23 {

    private void shuffle(int[] a) {
        int next;
        for (int i = 0; i < a.length; i++) {
            next = StdRandom.uniform(i, a.length);
            swap(a, i, next);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public void shuffle(int[] orig, int n) {
        int[] ints;
        String s;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ints = Arrays.copyOf(orig, orig.length);
            shuffle(ints);
            s = toString(ints);
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    private String toString(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] ints = Util.generateArray(StdIn.readInt());
        q23 test = new q23();
        int k = StdIn.readInt();
        test.shuffle(ints, k);
    }
}
