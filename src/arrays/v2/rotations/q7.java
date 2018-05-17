package arrays.v2.rotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 3/28/2018.
 */
public class q7 {

    public int maxSum(int[] a){
        int SUM = 0;
        for (int i = 0; i < a.length; i++) {
            SUM += i*a[i];
        }

        int maxSum = SUM;

        int arraySum = 0;
        for (int i = 0; i < a.length; i++) {
            arraySum += a[i];
        }

        for (int i = 1; i < a.length; i++) {
            SUM = SUM - arraySum + (a.length )*a[i - 1];
            maxSum = Math.max(maxSum, SUM);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q7 driver = new q7();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                System.out.println(driver.maxSum(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
