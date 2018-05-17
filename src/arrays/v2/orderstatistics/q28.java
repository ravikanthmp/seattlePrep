package arrays.v2.orderstatistics;

import arrays.Util;

import java.util.Stack;

/**
 * Created by Ravikanth on 4/23/2018.
 */
public class q28 {

    public void max3lis(int[] a){
        Util.LIS stacks = Util.lis(a);
        if (a==null || stacks.h < 3){
            try {
                throw new Exception("vgrwf");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int ans = 1;
        for (int i = stacks.h , j = 0; j < 3  ; j++, i--) {
            ans *= stacks.stacks[i].lastElement();
        }

        System.out.println(ans);

    }

    public static void main(String[] args) {
        q28 test = new q28();
        int[] arr  = {1, 5, 10, 8, 9};
        test.max3lis(arr);
    }
}
