package arrays.v1.rearrangement;

import arrays.Util;

/**
 * Created by Ravikanth on 2/23/2018.
 */
public class q2 {

    private static void reverse(int[] a){
        for (int i = 0; i < a.length / 2; i++) {
            Util.swap(a, i, a.length - 1 -i);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};

        reverse(a);
        System.out.println(Util.print(a));
    }
}
