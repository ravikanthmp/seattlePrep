package arrays.v2.orderstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/21/2018.
 */
public class q24 {

    public static int lis(int[] a) {
        int[] lis = new int[a.length];
        int j, temp, masSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            j = i - 1;
            lis[i] = 1;
            while (j >= 0) {
                if (a[j] < a[i]) {
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
                j--;
            }
            masSoFar = Math.max(masSoFar, lis[i]);
        }

        return masSoFar;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q24 test = new q24();
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

                test.lis2(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findCeiling(Stack<Integer>[] stacks, int lo, int hi, int key) {
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

    private void lis2(int[] a) {
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
        System.out.println(hi + 1);
    }
}
