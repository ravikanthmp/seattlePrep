package arrays.v1.rearrangement.rotation;

import arrays.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 2/20/2018.
 */
public class q4 {


    private static void rotate(int[] a) {
        int last = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = last;
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                int T = Integer.parseInt(br.readLine());
                int[] arr = null;
                StringTokenizer stringTokenizer = null;
                for (int i = 0; i < T; i++) {
                    int N = Integer.parseInt(br.readLine());
                    arr = new int[N];
                    stringTokenizer = new StringTokenizer(br.readLine());
                    for (int j = 0; j < N; j++) {
                        arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                    }

                    rotate(arr);
                    System.out.println(Util.print(arr));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
