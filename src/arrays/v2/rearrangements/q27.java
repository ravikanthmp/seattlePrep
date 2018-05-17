package arrays.v2.rearrangements;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/16/2018.
 */
public class q27 {

    private Map<Integer, Integer> frequency(Integer[] a){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        return map;
    }

    public void sort(Integer[] a){
        Map<Integer, Integer> map = frequency(a);
        Arrays.sort(a, (i, j) -> {
            int cmp = Integer.compare(map.get(j), map.get(i));
            if (cmp == 0){
                return Integer.compare(i, j);
            }
            return cmp;
        });
        StringBuilder sb = new StringBuilder();
        for (int i : a){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            Integer[] arr = null;
            StringTokenizer stringTokenizer = null;
            q27 test = new q27();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new Integer[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                test.sort(arr);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
