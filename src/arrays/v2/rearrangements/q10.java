package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/2/2018.
 */
public class q10 {

    private int maxSum(int[] a){
        rearrange(a);
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            sum += Math.abs(a[i] - a[i + 1]);
        }
        sum += Math.abs(a[0] - a[a.length - 1]);
        return sum;
    }

    private void rearrange(int[] a){
        Arrays.sort(a);
        int[] aux = new int[a.length];
        System.arraycopy(a, 0, aux, 0, a.length);

        int i = 0, j = a.length - 1, k = 0;
        boolean isLeftsTurn = false;

        while (i <= j){
            a[k++] = isLeftsTurn ? aux[i++] : aux[j--];
            isLeftsTurn = !isLeftsTurn;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q10 test = new q10();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                System.out.println(test.maxSum(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
