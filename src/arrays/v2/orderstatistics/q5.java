package arrays.v2.orderstatistics;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/19/2018.
 */
public class q5 {

    private void kthSmallest(int[] a, int k){
        int lo = 0, hi = a.length -1 ;
        int p = partition(a, lo, hi);

        while ( p != k - 1){
            if (p < k - 1){
                p = partition(a, p + 1, hi);
            }else {
                p = partition(a, lo, p - 1);
            }
        }

        System.out.println(a[p]);
    }

    private int partition(int[] a, int lo, int hi){
        if (hi == lo) return lo;
        int i = lo + 1, j = lo;
        int pivot = a[lo];
        while (i <= hi){
            if (a[i] < pivot) Util.swap(a, ++j, i++);
            else i++;
        }
        Util.swap(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q5 test = new q5();

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
