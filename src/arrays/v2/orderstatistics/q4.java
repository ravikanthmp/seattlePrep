package arrays.v2.orderstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/19/2018.
 */
public class q4 {
    
    private void kthSmallest(int[] a, int k){
        
        if (a == null || (k < 0 || k >= a.length)) try {
            throw new Exception("Invalid input!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Arrays.sort(a);
        System.out.println(a[k - 1]);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q4 test = new q4();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                stringTokenizer = new StringTokenizer(br.readLine());
                int K = Integer.parseInt(stringTokenizer.nextToken());
                test.kthSmallest(arr, K);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
