package arrays.v2.rotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 3/28/2018.
 */
public class q9 {

    public int rotationCountInSortedAndRotatedArray(int[] a){
        int pivot = findPivot(a);
        return pivot + 1;
    }

    private int findPivot(int[] a) {
        return findPivot(a, 0, a.length - 1);
    }

    private int findPivot(int[] a, int lo, int hi) {
        if (lo >= hi) return -1;
        int mid = lo + (hi - lo)/2;

        // test  mid
        if (mid < hi && a[mid] > a[mid + 1]) return mid;
        else if (mid > lo && a[mid - 1] > a[mid]) return mid - 1;
        else if (a[lo] < a[mid]) return findPivot(a, mid + 1, hi);
        else return findPivot(a, lo, mid - 1);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q9 driver = new q9();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                System.out.println(driver.rotationCountInSortedAndRotatedArray(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
