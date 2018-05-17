package arrays.v2.orderstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/20/2018.
 */
public class q16 {

    public void maxSum(int[] a) {
        int maxIncl = 0, maxExl = 0;
        int prevMaxExcl = maxExl, prevMaxIncl = maxIncl;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            maxIncl = prevMaxExcl + a[i];
            maxExl = prevMaxIncl;
            max = Math.max(maxExl, maxIncl);

            prevMaxExcl = maxExl;
            prevMaxIncl = maxIncl;
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        q16 test = new q16();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                test.maxSum(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
