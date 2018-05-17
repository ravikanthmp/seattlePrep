package arrays.v1.rearrangement.rotation;

/**
 * Created by Ravikanth on 2/21/2018.
 */
public class q8 {

    private static int findPivot(int[] a){
        return findPivot(a, 0, a.length -1 );
    }

    private static int findPivot(int[] a, int lo, int hi) {
        if (lo >= hi ) return 0;
        int mid = lo + (hi - lo)/2;

        if (lo < mid && a[mid - 1] > a[mid]){
            return mid;
        }

        if (mid < hi && a[mid] > a[mid + 1]){
            return mid + 1;
        }

        if (a[lo] < a[mid]){
            return findPivot(a, mid + 1, hi);
        }else {
            return findPivot(a, lo, mid - 1);
        }
    }

    public static void main(String[] args) {
        q8 test = new q8();
        int[] a ={7, 9, 11, 12, 15} ;
        System.out.println(q8.findPivot(a));;
    }
}
