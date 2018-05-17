package arrays.v2.searchingSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/24/2018.
 */
public class q14 {

    int[] aux;

    public void countInversions(int[] a){
        aux = new int[a.length];
        int count = sort(a, 0, a.length - 1);
        System.out.println(count);
    }

    private int merge(int[] a, int lo,int mid, int hi){

        int inv = 0;
        System.arraycopy(a, lo,  aux, lo, hi - lo + 1);

        int l = lo, m = mid + 1;

        for (int i = lo; i <= hi ; i++) {
            if (l > mid){
                a[i] = aux[m++];
            }else if (m > hi){
                a[i] = aux[l++];
            }else if (aux[l] <= aux[m]){
                a[i] = aux[l++];
            }else {
                a[i] = aux[m++];
                inv+= mid - l + 1;
            }
        }

        return inv;
    }

    private int sort(int[] a, int lo, int hi){
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo)/2;

        int left = sort(a, lo, mid);
        int right = sort(a, mid + 1, hi);

        return left + right + merge(a, lo, mid, hi);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            q14 test = new q14();
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                test.countInversions(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
