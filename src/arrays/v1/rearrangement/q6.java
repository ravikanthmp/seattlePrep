package arrays.v1.rearrangement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 2/28/2018.
 */
public class q6 {

    static int[] aux;

    public static void rearrange(int[] a){
        aux = new int[a.length];
        rearrange(a, 0, a.length - 1);
    }

    private static void rearrange(int[] a, int lo, int hi){
        if (lo >= hi) return;

        int mid = lo + (hi - lo)/2;

        rearrange(a, lo, mid);
        rearrange(a, mid + 1, hi);
        merge(a, lo, mid, hi);

    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);

        int l = lo, m = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (l > mid){
                a[i] = aux[m++];
            }else if (m > hi){
                a[i] = aux[l++];
            }else if (sameSign(aux, l, m)){
                a[i] = aux[l++];
            } else {
                if (aux[l] >= aux[m]){
                    a[i] = aux[l++];
                }else {
                    a[i] = aux[m++];
                }
            }
        }
    }

    private static boolean test(int[] a, int lo, int hi){
        boolean hasNegOccured = false;
        for (int i = lo; i <= hi; i++) {
            if (hasNegOccured && a[i] > 0){
                System.out.println("----------FAIL------------");
                return false;
            }else if (!hasNegOccured && a[i] < 0){
                hasNegOccured = true;
            }
        }
        return true;
    }

    private static boolean sameSign(int[] a, int l, int m){
        return  (a[l] < 0 && a[m] < 0) || (a[l] >= 0 && a[m] >= 0);
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
                arr = solve(arr);
                System.out.println(print(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] solve(int[] a){
        int[] aux = new int[a.length];
        int posnum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                posnum++;
        }

        int p = 0, j = posnum;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0){
                aux[posnum++] = a[i];
            }else {
                aux[p++] = a[i];
            }
        }

        return aux;
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }

}
