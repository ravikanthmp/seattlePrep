package arrays.v2.rearrangements;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/17/2018.
 */
public class Q29 {

    private int[] referenceArray;

    private Map<Integer, Integer> map;


    public Q29(int[] referenceArray) {
        this.referenceArray = referenceArray;
        map = new HashMap<>(referenceArray.length);
    }


    private void sort(int[] a) {
        for (int i = 0; i < referenceArray.length; i++) {
            map.put(referenceArray[i], i);
        }
        sort(a, 0, a.length - 1);
    }

    private int compare(int i, int j) {
        boolean hasI = map.containsKey(i);
        boolean hasJ = map.containsKey(j);

        if (hasI && hasJ) {
            return Integer.compare(map.get(i), map.get(j));
        } else if (hasI) {
            return -1;
        } else if (hasJ) {
            return 1;
        } else {
            return Integer.compare(i, j);
        }


    }

    private void sort(int[] a, int lo, int hi) {

        if (lo >= hi) return;

        int pivot = a[lo];
        int i = lo + 1;
        int lt = lo;
        int gt = hi;

        int cmp;

        while (i <= gt) {
            cmp = compare(a[i], pivot);
            if (cmp == 0) i++;
            else if (cmp < 0) exch(a, i++, ++lt);
            else exch(a, i, gt--);
        }

        exch(a, lo, lt);

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int A1[];
        int A2[];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            Q29 test;

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int M = Integer.parseInt(stringTokenizer.nextToken());

                A1 = new int[N];
                A2 = new int[M];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A1[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    A2[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                test = new Q29(A2);

                test.sort(A1);

                System.out.println(print(A1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }
}
