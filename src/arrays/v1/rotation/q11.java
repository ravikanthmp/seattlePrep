package arrays.v1.rearrangement.rotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 2/22/2018.
 */
public class q11 {
    public static int findPivotInSortedAndRotatedArray(int[] a) {
        return findPivotInSortedAndRotatedArray(a, 0, a.length - 1);
    }

    private static int findPivotInSortedAndRotatedArray(int[] a, int lo, int hi) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        if (mid < hi && a[mid] > a[mid + 1]) {
            return mid + 1;
        } else if (lo < mid && a[mid - 1] > a[mid]) {
            return mid;
        }

        return (a[lo] < a[mid]) ? findPivotInSortedAndRotatedArray(a, mid + 1, hi) :
                findPivotInSortedAndRotatedArray(a, lo, mid - 1);
    }

    public static void main(String[] args) {
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
                System.out.println(arr[findPivotInSortedAndRotatedArray(arr)]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
