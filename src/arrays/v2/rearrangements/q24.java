package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/8/2018.
 */
public class q24 {

    private int lis(int[] a) {
        if (a.length == 0) return 0;
        Stack<Integer>[] lis = new Stack[a.length];
        int idx = 0, sol = 0;
        push(lis, 0, a[0]);
        for (int i = 1; i < a.length; i++) {
            sol = findCeiling(a[i], 0, idx, lis);
            if (sol > idx){
                idx++;
            }
            push(lis, sol, a[i]);
        }

        return idx + 1;
    }

    private int findCeiling(int a, int lo, int hi, Stack<Integer>[] lis) {
        int mid, ans = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (lis[mid].peek() >= a) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private void push(Stack<Integer>[] stack, int idx, int i) {
        if (stack[idx] == null) stack[idx] = new Stack<>();
        stack[idx].push(i);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q24 test = new q24();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                System.out.println(test.lis(arr));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
