package arrays.v2.rearrangements;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/7/2018.
 */
public class q21 {

    class Tuple implements Comparable<Tuple>{

        int index, value;

        public Tuple(int index, int value) {
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(value, o.value);
        }
    }
    private void rearrange(int[] a, int k){
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            priorityQueue.add(new Tuple(i, a[i]));
        }

        Tuple min;

        int i, j;

        for (i = k, j = 0; i < a.length; i++) {
            min = priorityQueue.remove();
            a[j++] = min.value;
            priorityQueue.add(new Tuple(i, a[i]));
        }

        while (!priorityQueue.isEmpty()){
            min = priorityQueue.remove();
            a[j++] = min.value;
        }

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q21 test = new q21();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int K = Integer.parseInt(stringTokenizer.nextToken());

                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

               test.rearrange(arr, Math.min(arr.length, K));
                System.out.println(Util.print(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
