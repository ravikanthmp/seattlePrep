package arrays.v1.rearrangement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 3/6/2018.
 */
public class q8 {

    private static int[] rearrange(int[] a){
        int[] b = new int[a.length];
        boolean right = true;
        int lt = 0, rt = a.length - 1;

        for (int i = 0; i < b.length; i++) {
            if (right){
                b[i] = a[rt--];
            }else {
                b[i] = a[lt++];
            }
            right = !right;

        }
        return b;
    }

    public static void main(String[] args) {
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

                System.out.println(print(rearrange(arr)));
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
}
