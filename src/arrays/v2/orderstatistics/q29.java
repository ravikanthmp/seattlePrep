package arrays.v2.orderstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/23/2018.
 */
public class q29 {

    int maxPathSum(int[] a, int[] b){
        int N = a.length, M = b.length;
        int i =0, j = 0 ;

        int lSum = 0;
        int rSum = 0;
        int sum = 0;

        while (i < N || j < M){
            if (i == N) {
               while (j < M){
                   rSum += b[j++];
               }
            }else if (j == M){
                while (i < N){
                    lSum += a[i++];
                }
            }else if (a[i] == b[j]){
                sum += Math.max(lSum, rSum) + a[i];
                lSum = 0;
                rSum = 0;
                i++;
                j++;
            }else if (a[i] < b[j]){
                lSum += a[i++];
            }else {
                rSum += b[j++];
            }
        }

        sum += Math.max(lSum, rSum);

        return sum;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr1 = null;
            int[] arr2 = null;
            q29 test = new q29();
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int M = Integer.parseInt(stringTokenizer.nextToken());
                arr1 = new int[N];
                arr2 = new int[M];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr1[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr2[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                test.maxPathSum(arr1,arr2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
