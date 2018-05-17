

package arrays.v1.rearrangement;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 2/26/2018.
 */
public class q5 {

    private static int[] aux;

    private static void sort(int[] a, int base){
        aux = new int[a.length];
        sort(a, 0, a.length - 1, base);
    }

    private static void sort(int[] a, int lo, int hi, int base) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo)/2;

        sort(a, lo, mid, base);
        sort(a, mid + 1, hi, base);

        merge(a, lo, mid, hi, base);
    }

    private static void merge(int[] a, int lo, int mid, int hi, int base){

        System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        int left = lo, right = mid + 1;

        for (int i = lo ; i <= hi ; i++) {
           if (left > mid){
               a[i] = aux[right++];
           }else if (right > hi){
               a[i] = aux[left++];
           }else if (Math.abs(aux[left] - base) <= Math.abs(aux[right] - base)){
               a[i] = aux[left++];
           }else {
               a[i] = aux[right++];
           }
        }
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
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int K = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                sort(arr, K);
                System.out.println(print(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
