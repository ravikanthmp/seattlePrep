package arrays.v2.rearrangements;

import arrays.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by Ravikanth on 4/2/2018.
 */
public class q8 {

    public void rearrange(int[] a){
       Arrays.sort(a);
       int[] aux = new int[a.length];
       System.arraycopy(a, 0, aux, 0, a.length);

       int i = 0, j = a.length - 1, k = 0;
       boolean isLeftsTurn = false;

       while (i <= j){
           a[k++] = isLeftsTurn ? aux[i++] : aux[j--];
           isLeftsTurn = !isLeftsTurn;
       }
    }

    public static void main(String[] args) {
      int  arr[] = {1, 2, 3, 4, 5, 6, 7};
      q8 test = new q8();
      test.rearrange(arr);
        System.out.println(print(arr));
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }
}
