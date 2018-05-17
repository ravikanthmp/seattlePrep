package arrays.v2.orderstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/20/2018.
 */
public class q18 {

    public void maxToZRight(int[] a){
        int ans = 1;
        int maxToright = a[a.length - 1];
        for (int i = a.length - 2; i >= 0 ; i--) {
            if (a[i] > maxToright){
                maxToright = a[i];
            }else {
                ans = Math.max(ans, maxToright - a[i]);
            }
        }

        System.out.println(ans);
    }


    public static void main(String[] args) {
        q18 test = new q18();

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

                test.maxToZRight(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
