package arrays.v2.orderstatistics;

import java.util.TreeSet;

/**
 * Created by Ravikanth on 4/21/2018.
 */
public class q21 {

    public void findMinDistance(int[] a, int x1, int x2){
        System.out.println(findMinDistanceInternal(a, x1, x2));

    }
    public int findMinDistanceInternal(int[] a, int x1, int x2){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x2){
                set.add(i);
            }
        }

        int floor, ceil, min = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x1){
                floor  = floor(set, i);
                ceil = ceil(set, i);
                min = Math.min(min, Math.abs(Math.min(floor - i, ceil - i)));
            }
        }

        return min;
    }

    private int floor(TreeSet<Integer> set, int x){
        int ans = Integer.MAX_VALUE;
        try {
            ans = set.floor(x);
        }catch (Exception e){

        }
        return ans;
    }

    private int ceil(TreeSet<Integer> set, int x){
        int ans = Integer.MAX_VALUE;
        try {
            ans = set.ceiling(x);
        }catch (Exception e){

        }
        return ans;
    }

    public static void main(String[] args) {
        q21 test = new q21();
        int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        test.findMinDistance(arr, 3, 6);
    }
}
