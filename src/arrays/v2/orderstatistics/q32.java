package arrays.v2.orderstatistics;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/23/2018.
 */
public class q32 {

    private void nge(int[] a) {
        int[] nge = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i : stack) {
            nge[i] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nge.length; i++) {
            if (nge[i] == -1){
                sb.append('_');
            }else {
                sb.append(a[i]);
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            q32 test = new q32();
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
