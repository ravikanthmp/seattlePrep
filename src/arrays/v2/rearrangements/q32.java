package arrays.v2.rearrangements;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/17/2018.
 */
public class q32 {

    private void replace(int[] a){

        if (a == null || a.length == 1)return;

        int temp;
        int prev = a[0];
        int second = a[1];
        int secondLast = a[a.length - 2];
        for (int i = 1; i < a.length - 1; i++) {
            temp = a[i];
            a[i] = prev * a[i + 1];
            prev = temp;
        }

        a[0] *=second;
        a[a.length -1] *= secondLast;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6};
        q32 test = new q32();
        test.replace(arr);
        System.out.println(Util.print(arr));
    }
}
