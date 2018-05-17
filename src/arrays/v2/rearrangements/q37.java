package arrays.v2.rearrangements;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/18/2018.
 */
public class q37 {

    public void min(String S) {
        int[] A = new int[S.length() + 1];

        //init A
        for (int i = 0; i < A.length; i++) {
            A[i] = i + 1;
        }

        // Process pattern
        int i = 0, st;
        char c;
        int len = 0;
        while (i < S.length()) {
            c = S.charAt(i);
            if (c == 'D') {
                len = 0;
                st = i;
                while (i < S.length() && S.charAt(i) == 'D') {
                    len++;
                    i++;
                }
                reverse(A, st, st + len);

            } else {
                i++;
            }

        }

        System.out.println(print(A));
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static void reverse(int[] a, int lo, int hi) {
        int len = hi - lo + 1;
        for (int i = 0; i < len / 2; i++) {
            Util.swap(a, lo + i, hi - i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            q37 test = new q37();
            String S;
            for (int i = 0; i < T; i++) {
                S = br.readLine();
                test.min(S);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
