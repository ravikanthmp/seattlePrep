package arrays.v1.rearrangement.rotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 2/19/2018.
 */
public class q1 {

    private static void rotate(int[] a, int k) {
        int[] temp = new int[a.length];
        for (int j = 0; j < a.length; j++) {
            temp[j] = a[k];
            k = (k + 1) % a.length;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = temp[i];
        }
    }

    private static void rotate2(int[] a , int k){
        if (k == a.length) return;
        if (k <= 0) return;

        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
        reverse(a, 0, a.length - 1);

        byte mybite = 9;
    }


    private static void reverse(int[] a, int start, int end) {
        if (start >= end) return;
        int size = (end - start + 1)/2;
        for (int i = 0; i < size; i++) {
            swap(a, start + i, end - i);
        }
    }

    private static void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }


    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(a));
//        rotate(a, 2);
//        System.out.println(Arrays.toString(a));


        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int T = Integer.parseInt(br.readLine());
                int[] arr = null;
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                int k = Integer.parseInt(br.readLine());
                rotate2(arr, k);
                System.out.println( printArray(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

        private static String printArray(int[] a){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length; i++) {
                sb.append(a[i]).append(" ");
            }
            return sb.toString();
        }
}
