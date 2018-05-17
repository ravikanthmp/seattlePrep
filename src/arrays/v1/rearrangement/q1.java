package arrays.v1.rearrangement;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 2/22/2018.
 */
public class q1 {

    private static int partition(int[] a){
        int pivot = 0, i=  0, j = a.length - 1;
        while (i < j){
            if (a[i] < pivot) i++;
            else if (a[j] > pivot) j--;
            else Util.swap(a, i++, j--);
        }
        return i;
    }

    private static int[] rearrange(int[] a){

        int pivotIdx = partition(a);

        // pivotIdx is where +ve numbers start
        int[] b = new int[a.length];

        int l = 0, m = pivotIdx;
        boolean rTurn = true;

        for (int i = 0; i < b.length; i++) {
            if (rTurn){
                if (m < a.length){
                    b[i] = a[m++];
                }else {
                    b[i] = a[l++];
                }
            }else {
                if (l < pivotIdx){
                    b[i] = a[l++];
                }else {
                    b[i] = a[m++];
                }
            }
            rTurn = !rTurn;
        }
        return b;
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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

}
