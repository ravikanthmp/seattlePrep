package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/7/2018.
 */
public class q22 {

    public int max(int[] a) {
        int A = maxCircularSA(a);
        if (A < 0) return A;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            a[i] *= -1;
        }

        int B = maxCircularSA(a);

        return Math.max(A, sum + B);
    }

    private int maxCircularSA(int[] a) {
        int maxTillHere = 0, lengthTillHere = 0, maxSoFar = 0;
        boolean allNeg = true;
int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {

            if (a[i] > 0) allNeg = false;
            max = Math.max(max, a[i]);
            maxTillHere = Math.max(maxTillHere + a[i], 0);
            maxSoFar = Math.max(maxSoFar, maxTillHere);
        }


        return allNeg ? max : maxSoFar;
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
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q22 test = new q22();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                System.out.println(test.max(arr));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
