package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/3/2018.
 */
public class q14 {

    public  void rearrangeOddEen(int[] a){
        int j = partition(a);
        Arrays.sort(a, 0, j + 1);
        Arrays.sort(a, j + 1, a.length);
    }

    private int partition(int[] a){
        int j = -1;

        for (int i = 0; i < a.length ; i++) {
            if ( a[i] % 2 == 0){
                swap(a, i, ++j);
            }
        }
        
        return j;
    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
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
            q14 test = new q14();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                test.rearrangeOddEen(arr);
                System.out.println(print(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
