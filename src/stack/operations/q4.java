package stack.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 5/3/2018.
 */
public class q4 {


    private int[] nextSmallerElement(int[] a){
        int[] nse = new int[a.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {

            while (!stack.isEmpty() && a[stack.peek()] > a[i]){
                nse[stack.pop()] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            nse[stack.pop()] = a.length;
        }


        return nse;
    }
    
    private int[] previousSmallerElement(int[] a){
        int[] pse = new int[a.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] < a[stack.peek()]){
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            pse[stack.pop()] = -1;
        }

        return pse;

    }
    
    public int maxArea(int[] a){
        int[] nextSmallerElement = nextSmallerElement(a);
        int[] previousSmallerElement = previousSmallerElement(a);

        int maxArea = 0;
        
        for (int i = 0; i < a.length; i++) {
            maxArea = Math.max(maxArea, area(a, i, previousSmallerElement[i], nextSmallerElement[i]));    
        }
        
        return maxArea;
    }
    
    private int area(int[] a, int idx, int pse, int nse){
        int height = a[idx];
        int width;
        
        width = nse - idx;
        width += idx - (pse + 1);
        
        return width * height;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q4 test = new q4();
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                System.out.println(test.maxArea(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
