package arrays.v2.rearrangements;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Ravikanth on 4/3/2018.
 */
public class q18 {

    private void subset(int[] a){
        Arrays.sort(a);
        int sum = Arrays.stream(a).parallel().sum();
        
    }
}
