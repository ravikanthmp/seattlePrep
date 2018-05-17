package arrays.v2.rearrangements;

/**
 * Created by Ravikanth on 4/17/2018.
 */
public class q30 {

    private int[] fillSeq(int[] a){
        int[] seq = new int[a.length];

        seq[0] = (a[0] == 0) ?  0 : 1;

        for (int i = 1; i < a.length; i++) {

            if (a[i] == 0){
                seq[i] = 0;
            }else {

                if (a[i - 1] != 0){
                    seq[i] = seq[i - 1] + 1;
                    seq[ i - seq[i] + 1] = seq[i];
                }else {
                    seq[i] = 1;
                }
            }
        }

        return seq;
    }

    public int indexOfZero(int[] a){
        int[] seq = fillSeq(a);
        int maxSoFar = 0;
        int maxIndexSoFar = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0){
                if ( getMaxSeq(seq, i - 1) + getMaxSeq(seq, i + 1) > maxSoFar){
                    maxSoFar = getMaxSeq(seq, i - 1) + getMaxSeq(seq, i + 1);
                    maxIndexSoFar = i;
                }
            }
        }

        return maxIndexSoFar;
    }

    private int getMaxSeq(int[] a, int idx){
        if (idx < 0 || idx == a.length ) return 0;
        else return a[idx];
    }

    public static void main(String[] args) {
        int    arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        q30 test = new q30();
        System.out.println(test.indexOfZero(arr));
    }
}
