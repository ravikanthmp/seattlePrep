package arrays.v2.rearrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/16/2018.
 */
public class q26 {


    class Segment implements Comparable<Segment> {
        int startIdx, endIndex, sum;

        public Segment(Segment segment) {
            startIdx = segment.startIdx;
            endIndex = segment.endIndex;
            sum = segment.sum;
        }

        public Segment(int startIdx, int endIndex, int sum) {
            this.startIdx = startIdx;
            this.endIndex = endIndex;
            this.sum = sum;
        }

        @Override
        public int compareTo(Segment o) {
            int cmp = Integer.compare(sum, o.sum);
            if (cmp == 0) {
                cmp = Integer.compare(endIndex - startIdx, o.endIndex - o.startIdx);
                if (cmp == 0) {
                    cmp = Integer.compare(startIdx, o.startIdx);
                }
            }
            return cmp;
        }
    }


    // max Non-negative sub array sum

    public void maxSubArraySum(int[] a) {
        Segment maxTillHere = new Segment(0, 0, a[0]);
        Segment maxSoFar = new Segment(0, 0, a[0]);

        for (int i = 1; i < a.length; i++) {

            if (a[i] < 0) {
                maxTillHere = new Segment(i, i, a[i]);
            } else {
                if (maxTillHere.sum < 0) {
                    maxTillHere = new Segment(i, i, a[i]);
                } else {
                    maxTillHere.endIndex++;
                    maxTillHere.sum += a[i];
                }
            }

            maxSoFar = (maxSoFar.compareTo(maxTillHere) < 0) ? new Segment(maxTillHere) : maxSoFar;

        }

        StringBuilder sb = new StringBuilder();
        for (int i = maxSoFar.startIdx; i <= maxSoFar.endIndex; i++)
        {
            sb.append(a[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q26 test = new q26();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                test.maxSubArraySum(arr);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
