package arrays.v2.rotations;

import arrays.Util;
import edu.princeton.cs.algs4.StdIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 3/28/2018.
 */
public class q1 {

    public static void main(String[] args) {
//        int[] a = Util.generateArray(StdIn.readInt());
//        System.out.println(Util.print(a));
//        rotate(a, StdIn.readInt());
//        System.out.println(Util.print(a));

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
                stringTokenizer = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(stringTokenizer.nextToken());


                rotate(arr, d);
                System.out.println(print(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }


    private static void rotate(int[] a, int d){
        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int[] a, int lo, int hi){
        int len = hi - lo + 1;
        for (int i = 0; i < len / 2; i++) {
            swap(a, lo + i, hi - i);
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
