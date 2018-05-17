package arrays.v2.orderstatistics;

import arrays.Quicksort;
import arrays.v2.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/22/2018.
 */
public class q26 {

    private void maxRepeating(int[] a, int k){
        for (int i = 0; i < a.length; i++) {
            a[a[i] % k] += k;
        }

        int maxOccuring = 0;
        int maxKth = -1;

        int temp;
        for (int i = 0; i < k; i++) {
            temp = a[i]/k;

            if (temp >  maxOccuring){
                maxOccuring = temp;
                maxKth = i;
            }
        }

        System.out.println(maxKth);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            q26 test = new q26();
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

                test.maxRepeating(arr, K);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
