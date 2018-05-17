package stack.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 5/6/2018.
 */
public class q16 {
    
    public int maxDiff(int[] a){
        int[] nse = nse(a);
        int[] pse = pse(a);

        int maxoFar = Integer.MIN_VALUE;
        
        for (int i = 0; i < a.length; i++) {
            maxoFar = Math.max(maxoFar, Math.abs(pse[i] - nse[i]));    
        }
        
        return maxoFar;
    }
    
    private int[] nse(int[] a){
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[a.length];
        
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] < a[stack.peek()]){
                nse[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()){
            nse[stack.pop()] = 0;
        }
        
        return nse;
    }
    
    private int[] pse(int[] a){
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && a[i] < a[stack.peek()]){
                pse[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            pse[stack.pop()] = 0;
        }

        return pse;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q16 test = new q16();
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                System.out.println(test.maxDiff(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
