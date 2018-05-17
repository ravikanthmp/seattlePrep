package arrays.v2.orderstatistics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/19/2018.
 */
public class q6 {

    public static void main(String[] args) {
        //int arr[] = {7, 10, 4, 3, 20, 15};
        q6 test = new q6();
        //System.out.println(test.select(arr, 3));

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
                stringTokenizer = new StringTokenizer(br.readLine());
                int K = Integer.parseInt(stringTokenizer.nextToken());
//                for (int j = 0; j < arr.length; j++) {
//                    System.out.println(test.select(arr, j));;
//                }
                System.out.println(test.select(arr, K - 1));
                ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findMedian5(int[] a, int lo, int hi) {
        int size = hi - lo + 1;
        Arrays.sort(a, lo, hi + 1);
        return (a[lo + (int) Math.floor(size / 2)] + a[lo + (int) Math.ceil(size / 2)]) / 2;
    }


    private int select(int[] a, int k) {
        return select(a, k, 0, a.length - 1);
    }

    private int select(int[] a, int k, int lo, int hi) {
        if (a == null || lo > hi || (k < 0 || k >= a.length)) {
            return -1;
        }
        if ((hi - lo + 1) <= 5) {
            Arrays.sort(a, lo, hi + 1);
            return a[lo + k];
        } else {
            int groups = (int) Math.ceil((hi - lo + 1) / 5.0);
            int[] b = new int[groups];

            for (int i = 0; i < groups; i++) {
                b[i] = findMedian5(a, i * 5, Math.min(hi, (i + 1) * 5 - 1));
            }


            double x;

            // dont do this

            x = select(b, (int) Math.floor((b.length - 1) / 2.0), 0, b.length - 1);
            int p = partition(a, lo, hi);

            int i = lo;
            for (i = lo; i <= hi; i++) {
                if (a[i] == x) {
                    break;
                }
            }
            swap(a, lo, i);
            if (p == k - 1) return a[p];
            else if (p > (k)) {
                return select(a, k - 1, lo, p - 1);

            } else {
                return select(a, k - p, p + 1, hi);
            }
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int j = lo - 1;
        int pivot = a[lo];
        for (int i = lo; i <= hi; i++) {
            if (a[i] < pivot) swap(a, ++j, i);
        }
        swap(a, lo, j);
        return j;
    }


    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
