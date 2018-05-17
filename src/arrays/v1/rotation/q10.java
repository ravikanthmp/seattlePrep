package arrays.v1.rearrangement.rotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 2/22/2018.
 */
public class q10 {


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++ ) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int X = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                quickRotation(arr, X);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void quickRotation(int[] a, int k){
        int[] b = Arrays.copyOf(a, 2*a.length);
        System.arraycopy(a, 0, b, a.length, a.length);
        print(b, k%a.length, a.length);
    }

    private static void print(int[] a, int k, int size ){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(a[k + i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
