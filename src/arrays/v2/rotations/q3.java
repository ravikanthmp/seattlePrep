package arrays.v2.rotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 3/28/2018.
 */
public class q3 {

    private void swap(int[] a, int ll, int lr, int rl, int rr) {

        int lSize = lr - ll + 1;
        int rSize = rr - rl + 1;

        if (ll > lr || rl > rr || (lSize != rSize)) throw new InputMismatchException();

        for (int i = 0; i < lSize; i++) {
            swap(a, ll++, rl++);
        }

    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    private void rotate(int[] a, int l, int r, int d) {


        int lSize = d;
        int rSize = (r - l + 1) - d;

        if (lSize == 0 || rSize == 0) return;

        if (lSize == rSize) {
            swap(a, l, l + d - 1, l + d, r);
        } else if (lSize < rSize) {
            swap(a, l, l + d - 1, r - d + 1, r);
            rotate(a, l, r - d , d);
        } else {
            swap(a, l, l + rSize - 1, r - rSize + 1, r);
            rotate(a, l + rSize, r, d - rSize);
        }
    }

    public void rotate(int[] a, int d){
        rotate(a, 0, a.length - 1, d);
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
            q3 driver = new q3();

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

                driver.rotate(arr, d);
                System.out.println(print(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
