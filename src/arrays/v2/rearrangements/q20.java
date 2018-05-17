package arrays.v2.rearrangements;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/7/2018.
 */
public class q20 {

    public int[] ge(int[] A)
    {
        int cmax = A[A.length - 1];
        int[] ge = new int[A.length];
        ge[A.length - 1] = -1;
        for (int i = A.length - 2; i >= 0; i--) {
            ge[i] = cmax;
            cmax = Math.max(cmax, A[i]);
        }
        return ge;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q20 test = new q20();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());

                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }


                System.out.println(print(test.ge(arr)));

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
