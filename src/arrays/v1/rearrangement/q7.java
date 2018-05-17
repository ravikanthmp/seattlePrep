package arrays.v1.rearrangement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 3/6/2018.
 */
public class q7 {


    public  ArrayList<Integer> rangepartition(ArrayList<Integer> a, int l, int m) {
        return rangepartition(a, 0, a.size() - 1, l, m);
    }
    private  ArrayList<Integer> rangepartition(ArrayList<Integer> a, int lo, int hi, int l, int m) {
        int i = lo + 1, lt = lo, gt = hi, cmp;
        while (i <= gt) {
            cmp = compare(a, i, l, m);
            if (cmp == 0) i++;
            else if (cmp < 0) swap(a, i++, lt++);
            else swap(a, i, gt--);
        }
        return  a;
    }


    private static int compare(ArrayList<Integer> a, int i, int lt, int gt) {
        if (a.get(i) < lt) return -1;
        else if (a.get(i) > gt) return 1;
        else return 0;
    }

    public static void swap(ArrayList<Integer> a, int i, int j) {
        int temp =a.get(i);
        a.set(j, a.get(i));
        a.set(i, temp);
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }

    public ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int lo, int hi)
    {
        //add code here.
        ArrayList<Integer> ans = new ArrayList<>();

        int mode = 0;

        for (int a : A){
            if (mode == 0){
                if (a >= lo){
                    if (a > hi){
                        mode = 2;
                    }else {
                        mode = 1;
                    }
                }
            }else if (mode == 1){
                if (a > hi) {
                    mode = 2;
                }else if (a < lo){
                    ans.add(0);
                    return ans;
                }
            }else {
                if (a < hi){
                    ans.add(0);
                    return ans;
                }
            }
        }

        ans.add(1);
        return ans;
    }

    private static void printIfOrdered(int[] a, int lo, int hi){
        int mode = 0;

        int temp = lo;
        lo = Math.min(lo, hi);
        hi = Math.max(temp, hi);

        for (int i = 0; i < a.length; i++) {
            if (mode == 0){
                if (a[i] >= lo){
                    if (a[i] > hi){
                        mode = 2;
                    }else {
                        mode = 1;
                    }
                }
            }else if (mode == 1){
                if (a[i] > hi) {
                    mode = 2;
                }else if (a[i] < lo){
                    System.out.println("0");
                    return;
                }
            }else {
                if (a[i] < hi){
                    System.out.println("0");
                    return;
                }
            }
        }

        System.out.println("1");

    }



    public static void main(String[] args) {

//        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 13, 15,
//                98, 3, 1, 32};
//        rangepartition(arr, 0, arr.length - 1, 10, 20);
//        System.out.println(Util.print(arr));
        q7 ques = new q7();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l, m;
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
                stringTokenizer = new StringTokenizer(br.readLine());
                l = Integer.parseInt(stringTokenizer.nextToken());
                m = Integer.parseInt(stringTokenizer.nextToken());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
