package arrays;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Stack;

/**
 * Created by Ravikanth on 2/20/2018.
 */
public class Util {

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }

    public static String print(double[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }

    public static void reverse(int[] a, int lo, int hi){
        int len = hi - lo + 1;
        for (int i = 0; i < len / 2; i++) {
            Util.swap(a, lo + i, hi - i);
        }
    }

    public static String print(int[] a, int lo, int hi) {
        StringBuilder sb = new StringBuilder();

        for (int i = lo; i <= hi; i++){
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }

//    public static String print(int[] a, int k, int size) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < size; i++) {
//            sb.append(a[k + i]).append(" ");
//        }
//        return sb.toString();
//    }

    public static boolean isSorted(int[] a){

        for (int i = 1; i < a.length; i++) {
                if (a[i] < a[i - 1]) {
                    System.out.println("at i = " + i + " a[i] = " + a[i] + " is less than i - 1 " + (i - 1) + " a[i-1] = " + a[i-1] );
                    return false;
                }
        }
        return true;
    }

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

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] generateArray(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(n);
        }
        return a;
    }

    private static int findCeiling(Stack<Integer>[] stacks, int lo, int hi, int key) {
        int mid, ans = hi + 1;
        while (lo <= hi){
            mid = lo + (hi - lo)/2;
            if (stacks[mid].peek() == key){
                return mid;
            }else if (stacks[mid].peek() > key){
                ans = mid;
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static class LIS{
        public Stack<Integer>[] stacks;
        public int h;

        public LIS(Stack<Integer>[] stacks, int h) {
            this.stacks = stacks;
            this.h = h;
        }
    }

    public static LIS lis(int[] a) {
        Stack<Integer>[] stack = new Stack[a.length];
        int hi = 0, j;
        stack[0] = new Stack<>();
        stack[0].push(a[0]);
        for (int i = 1; i < a.length; i++) {
            j = findCeiling(stack, 0, hi, a[i]);
            if (j > hi) {
                hi++;
                stack[hi] = new Stack<>();
                stack[hi].push(a[i]);
            }else {
                stack[j].push(a[i]);
            }
        }
        return new LIS(stack, hi);
    }
}
