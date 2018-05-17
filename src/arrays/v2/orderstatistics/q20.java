package arrays.v2.orderstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Ravikanth on 4/21/2018.
 */
public class q20 {

    private void maxOfSubarraysOfSize(int[] a, int k) {
        if (a == null || k > a.length){
            try {
                throw new Exception("Invalid!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (!map.containsKey(a[i])){
                map.put(a[i], 1);
            }else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        sb.append(map.firstKey()).append(" ");

        int j;
        int ans;
        Map.Entry<Integer, Integer> first;
        for (int i = k; i < a.length ; i++) {
            j = i - k;
            ans = map.get(a[j]);
            if (ans == 1) {
                map.remove(a[j]);
            }else {
                map.put(a[j], ans - 1);
            }
            if (!map.containsKey(a[i])){
                map.put(a[i], 1);
            }else {
                map.put(a[i], map.get(a[i]) + 1);
            }
            sb.append(map.firstKey()).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q20 test = new q20();
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int K = Integer.parseInt(stringTokenizer.nextToken());
                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                test.maxOfSubarraysOfSize(arr, K);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
