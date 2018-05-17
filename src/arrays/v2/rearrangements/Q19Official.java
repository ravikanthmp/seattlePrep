package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/4/2018.
 */
public class Q19Official {

    public int calc(int[] a){
        int minimumProductEndingHere = 1;
        int maximumProductEndingHere = 1;

        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {

            if (a[i] < 0){

                int temp = maximumProductEndingHere;
                maximumProductEndingHere = Math.max(a[i], minimumProductEndingHere * a[i]);
                minimumProductEndingHere = Math.min(a[i], temp * a[i]);
            }else if (a[i] > 0){

                maximumProductEndingHere = Math.max(a[i], maximumProductEndingHere * a[i]);
                minimumProductEndingHere = Math.min(a[i], minimumProductEndingHere * a[i]);
            }

            maxSoFar = Math.max(maximumProductEndingHere, maxSoFar);

            if (a[i] == 0){
                minimumProductEndingHere = 1;
                maximumProductEndingHere = 1;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            Q19Official test = new Q19Official();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                System.out.println(test.calc(arr));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
