package string.basics;

/**
 * Created by Ravikanth on 5/20/2018.
 */
public class CountingSort {

    int R;

    public CountingSort(int r) {
        R = r;
    }

    public void sort(char[] chars){

        // init count array
        int[] count = new int[R +  1];

        // set ctr
        for (int i = 0; i < chars.length; i++) {
            count[ chars[i] + 1]++;
        }

        // cumulative sum
        for (int i = 1; i < count.length ; i++) {
            count[i] += count[i - 1];
        }

        char[] aux = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            aux[ count[chars[i]]++] = chars[i];
        }

        for (int i = 0; i < aux.length; i++) {
            chars[i] = aux[i];
        }


    }

    public static void main(String[] args) {
        CountingSort csort = new CountingSort(256);
        String s = "halamney moyeh!";
        char[] chars = s.toCharArray();
        csort.sort(chars);
        String s2 = new String(chars);
        System.out.println(s2);
    }
}
