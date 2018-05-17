package arrays.v2.searchingSorting;

import arrays.v2.orderstatistics.q26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/23/2018.
 */
public class q3 {

    private void findPair(int[] a, int sum){
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            int m = a[i];
            int ans = Arrays.binarySearch(a, i + 1, a.length, sum - m);
            if (ans > i){
                System.out.println("Yes" + " " + String.valueOf(m) + " and " + String.valueOf(sum - m));
                return;
            }
        }

        System.out.println("No");
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            q3 test = new q3();
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int K = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                test.findPair(arr, K);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
