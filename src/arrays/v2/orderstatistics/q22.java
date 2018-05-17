package arrays.v2.orderstatistics;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/21/2018.
 */
public class q22 {


    public void bitonicSearch(int[] a, int x){
        int max =  findMax(a);
        int ans = binSearch(a, 0, max, x, Comparator.naturalOrder());
        if (ans == -1){
            ans = binSearch(a, max + 1, a.length - 1, x, Comparator.reverseOrder());
        }
        if (ans == -1){
            System.out.println("OOPS! NOT FOUND");
        }else {
            System.out.println(ans);
        }
    }

    private int binSearch(int[] a, int lo, int hi, int el, Comparator<Integer> cmp){
        int mid, c;
        while (lo <= hi){
            mid = lo + (hi - lo)/2;
            c = cmp.compare(el, a[mid]);
            if (c == 0){
                return mid;
            }else if (c > 0){
                lo = mid + 1;
            }else
            {
                hi = mid - 1;
            }
        }

        return -1;
    }

    private int findMax(int[] a){
        return findMax(a, 0, a.length - 1);
    }

    private int findMax(int[] a, int lo, int hi){
        if ( (hi - lo + 1) == 1){
            return lo;
        }else if (hi - lo + 1 == 2){
            return a[lo] > a[hi] ? hi : lo;
        }
        else {
            int mid = lo + (hi - lo)/2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]){
                return mid;
            }else if (a[mid]> a[mid - 1]){
                return findMax(a, mid + 1, hi);
            }else {
                return findMax(a, lo, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q22 test = new q22();
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int X = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                test.bitonicSearch(arr, X);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
