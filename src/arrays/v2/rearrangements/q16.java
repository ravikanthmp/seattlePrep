package arrays.v2.rearrangements;

import edu.princeton.cs.algs4.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/3/2018.
 */
public class q16 {

    private static int[] nge(int[] a) {
        int[] nge = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int k;
        for (int i = 0; i < a.length; i++) {

            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                k = stack.pop();
                nge[k] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        return nge;
    }

    public static ArrayList find3Numbers(int[] a, int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] nge = nge(a);
        for (int i = 0; i < a.length; i++) {
            if (isSequencePresent(nge, i)){
                arrayList.add(a[i]);
                arrayList.add(a[nge[i]]);
                arrayList.add(a[nge[nge[i]]]);
                break;
            }
        }
        return arrayList;
    }

    private static boolean isSequencePresent(int[] nge, int index) {
        return isValid(nge, index) && isValid(nge, nge[index]);
    }

    private static boolean isValid(int[] nge, int index) {
        return (nge[index] != -1 && nge[index] < nge.length);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q14 test = new q14();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                ArrayList<Integer> numbers = find3Numbers(arr, arr.length);
                for (int num : numbers){
                    System.out.print(num+ " ");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
