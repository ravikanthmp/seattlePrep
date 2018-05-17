package arrays.v2.rearrangements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravikanth on 4/3/2018.
 */
public class q17 {

    /*You are required to complete this method*/
    int maxLen(int[] arr)
    {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, -1);
       int sumSoFar = 0;

       int maxSoFar = 0;

        for (int i = 0; i < arr.length; i++) {
            sumSoFar += arr[i] == 0 ? -1 : 1;
            if (map.containsKey(sumSoFar)){
                maxSoFar = Math.max(maxSoFar, i - map.get(sumSoFar));
            }
            map.put(maxSoFar, i);
        }

       return maxSoFar;
    }
}
