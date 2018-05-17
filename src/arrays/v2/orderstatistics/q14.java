package arrays.v2.orderstatistics;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/20/2018.
 */
public class q14 {

    public void nge(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                nge[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        System.out.println(Util.print(nge));
    }

    public static void main(String[] args) {
        q14 test = new q14();
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

                test.nge(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
