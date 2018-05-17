package stack.operations;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 5/4/2018.
 */
public class q9 {

    public int[] maxOfWinSizes(int[] a){
        int[] aux = new int[a.length];
        System.arraycopy(a, 0, aux, 0, a.length);
        int[] result = new int[a.length];

        for (int ws = 1; ws <= a.length; ws++){
            int maxOfMin = Integer.MIN_VALUE;
            for (int i = 0; i <= a.length - ws; i++) {
                aux[i] = Math.min(aux[i], a[i + ws - 1]);
                maxOfMin = Math.max(aux[i], maxOfMin);
            }

            result[ws - 1] = maxOfMin;
        }

        return result;
    }

    public int[] maxOfWinSizesFyassst(int[] a){

        int[] nse = nse(a);
        int[] pse = pse(a);

        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MIN_VALUE;
        }

        int maxInWindow;
        for (int i = 0; i < a.length; i++) {
            maxInWindow = windowSize(i, nse, pse);
            if (result[maxInWindow - 1] < a[i]){
                result[maxInWindow - 1] = a[i];
            }
        }

        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MIN_VALUE){
                result[i] = result[i - 1];
            }
        }

        return result;

    }

    private int windowSize(int i, int[] nse, int[] pse){

        return 1 + (nse[i] - i - 1) + (i - pse[i] - 1);
    }

    private int[] nse(int[] a){
        int[] res = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {

            while (!stack.isEmpty() && a[i] < a[stack.peek()]){
                res[stack.pop()] = i;
            }

            stack.push(i);
        }

        int popped;
        while (!stack.isEmpty()){
          popped = stack.pop();
          res[popped] = a.length;
        }

        return res;
    }

    private int[] pse(int[] a){
        int[] res = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] < a[stack.peek()]){
                res[stack.pop()] = i;
            }

            stack.push(i);
        }
        int popped;
        while (!stack.isEmpty()){
            popped = stack.pop();
            res[popped] = -1;
        }

        return res;
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q9 test = new q9();
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                System.out.println(print(test.maxOfWinSizesFyassst(arr)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
