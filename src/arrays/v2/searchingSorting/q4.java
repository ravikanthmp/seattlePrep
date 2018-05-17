package arrays.v2.searchingSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/23/2018.
 */
public class q4 {

    private void majority(int[] a){
        int c = 1, v = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == v){
                c++;
            }else {
                if (c == 0){
                    v = a[i];
                    c = 1;
                }else {
                    c--;
                }
            }
        }

        if (c != 0){
           int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == v) count++;
            }
            if (count > a.length/2){
                System.out.println(v);
            }else {
                System.out.println("NO Majority Element");
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            q4 test = new q4();
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                test.majority(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
