package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/16/2018.
 */
public class q25 {

    private int reverseComp(int a, int b){
        return compare(a, b)* -1;
    }

    private int compare(int a, int b) {


        int A = Integer.parseInt(Integer.toString(a).concat(Integer.toString(b)));
        int B = Integer.parseInt(Integer.toString(b).concat(Integer.toString(a)));

        return Integer.compare(A, B);

    }


    public void sort(Integer[] a) {
//        Arrays.sort(a, (i, j) -> compare(i, j));
    }

    public String maxNum(int[] a){
        sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i : a){
            sb.append(i);
        }
        return sb.toString();
    }

    public void sort(int[] a){
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi){

//        if (lo >= hi) return;
//        int pivot = a[lo];
//        int lt = lo, gt = hi, i = lo;
//        int comp ;
//        while (i <= gt){
//            comp = compare(pivot, a[i]);
//            if (comp < 0) exch(a, ++lt, i++);
//            else if (comp ==0) i++;
//            else exch(a, gt--, i);
//        }
//
//        sort(a, lo, lt - 1);
//        sort(a, gt + 1, hi);

        if (lo >= hi) return;
        int pivot = a[lo];

        int j = lo ;
        for (int k = lo + 1; k <= hi; k++) {
            if (reverseComp(a[k], pivot) < 0 ){
                exch(a, ++j, k);
            }
        }

        exch(a, lo, j);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private void exch(int[] a, int l, int r)
    {
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
            q25 test = new q25();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                System.out.println(test.maxNum(arr));;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
