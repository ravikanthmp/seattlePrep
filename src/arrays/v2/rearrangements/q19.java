package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/3/2018.
 */
public class q19 {

    class Segment{

        private int maxSoFar, currentMax;

        private void process(int[] a, int i, int[] cumulativeProductLeft, int[] cumulativeProductRight){
            if ((i == a.length) || (a[i] == 0)){
                currentMax = Math.max(currentMax, cumulativeProductLeft[i]);
                maxSoFar = Math.max(maxSoFar, currentMax);
                currentMax = Integer.MIN_VALUE;
            }else if (a[i] < 0){

                if (cumulativeProductLeft[i] < 0){
                    currentMax = Math.max(cumulativeProductLeft[i] * a[i], currentMax);
                }else if (cumulativeProductRight[i] < 0){
                    currentMax = Math.max(cumulativeProductRight[i] * a[i], currentMax);
                } else {
                    currentMax = Math.max(cumulativeProductRight[i], cumulativeProductLeft[i]);
                }

            }
        }
    }

    private int maxSAProduct(int[] a) {

        Segment segment = new Segment();
        int[] cumulativeProductLeft = new int[a.length + 1];
        int[] cumulativeProductRight = new int[a.length + 1];

        int cl = 1, cr = 1;

        cumulativeProductLeft[0] = 1;
        for (int i = 1; i <= a.length; i++) {
            if (a[i - 1] == 0){
                cumulativeProductLeft[i] = 1;
            }else {
                cumulativeProductLeft[i] = cumulativeProductLeft[i - 1] * a[i - 1];
            }
        }

        cumulativeProductRight[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i + 1] == 0){
                cumulativeProductRight[i] = 1;
            }else {
                cumulativeProductRight[i] = cumulativeProductRight[i + 1] * a[i + 1];
            }
        }

        for (int i = 0; i <= a.length; i++) {

            segment.process(a, i, cumulativeProductLeft, cumulativeProductRight);
        }
        return Math.max(segment.maxSoFar, segment.currentMax);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q19 test = new q19();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                System.out.println(test.maxSAProduct(arr));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        q19 test = new q19();
//        int[] a = {};
//        test.maxSAProduct(a);
    }

}
