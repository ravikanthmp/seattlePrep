package arrays.v2.rotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 3/28/2018.
 */
public class q6 {

    private int binarySearch(int[] a, int lo, int hi, int key, int skip){
        if (skip != -1) return skip;
        int mid;
        while (lo <= hi){
            mid = lo + (hi - lo)/2;
            if (a[mid] == key) return mid;
            else if (key > a[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    private int findPivot(int[] a, int lo, int hi){
        int mid = lo + (hi - lo)/2;
        if (mid < hi && a[mid] > a[mid + 1]) return mid;
        else if (mid > lo && a[mid] < a[mid - 1]) return mid - 1;
        else if (a[lo] < a[mid])
            return findPivot(a, mid + 1, hi);
        else return findPivot(a, lo, mid);
    }

    public int findPivot(int[] a){
        return findPivot(a, 0, a.length - 1);
    }

    public void findSum(int[] a, int sum){
        int pivot = findPivot(a);

        int ans = -1;
        int ls = -1, rs = -1;

        if (pivot != -1){
            for (int i = pivot + 1; i < a.length && ans == -1; i++) {
                ls = i;

                ans = binarySearch(a, i + 1, a.length - 1, sum - a[i], ans);
                ans = binarySearch(a, 0, pivot, sum - a[i], ans);

                rs = ans;
            }
            if (ans == -1){
                for (int i = 0; i < pivot && ans == -1; i++) {
                    ls = i;
                    ans = binarySearch(a, i + 1, pivot, sum - a[i], ans);
                    rs = ans;
                }
            }

        }
        if (ans == -1){
            System.out.println("There is no pair with sum " + sum);
        }else {
            System.out.println("There is a pair (" + a[ls] + ", " + a[rs] + ") with sum " + sum);
        }
    }

    public static void main(String[] args) {


    }
}
