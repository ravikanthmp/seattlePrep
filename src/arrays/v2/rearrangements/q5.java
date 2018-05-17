package arrays.v2.rearrangements;

import arrays.Util;
import arrays.v2.rotations.q9;
import edu.princeton.cs.algs4.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/1/2018.
 */
public class q5 {

    int[] aux;

    private void sort(int[] a, int base){
        aux = new int[a.length];
        sort(a, 0, a.length - 1, base);
    }

    private void sort(int[] a, int l, int r, int base) {

        if ( l >= r) return;

        int mid = l + (r - l)/2;

        sort(a, l, mid, base);
        sort(a, mid + 1, r, base);


        merge(a, l, mid, r, base);
    }

    private void merge(int[] a, int l, int mid, int r, int base) {

        System.arraycopy(a, l, aux, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r ; k++) {
            if (i == mid + 1) {
                a[k] = aux[j++];
            } else if (j > r) {
                a[k] = aux[i++];
            } else if (less(aux, i, j, base)) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    private boolean less(int[] a, int l, int m, int base){
        return Integer.compare( Math.abs(a[l] - base), Math.abs(a[m] - base)) <= 0;
    }

    private void exch(int[] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q5 test = new q5();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int K = Integer.parseInt(stringTokenizer.nextToken());

                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                test.sort(arr, K);
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
}
