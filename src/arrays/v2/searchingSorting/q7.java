package arrays.v2.searchingSorting;

/**
 * Created by Ravikanth on 4/23/2018.
 */
public class q7 {

    private int differByK(int[] a, int k, int key){
        return differByK(a, k, 0, a.length - 1, key);
    }

    int differByK(int[] a, int k, int lo, int hi, int key){
        if (lo > hi) return -1;
        if (lo == hi){
            return a[lo] == key ? lo : -1;
        }else {
            int mid = lo + (hi - lo)/2;

            if (a[mid] == key) return mid;
            int diff = Math.abs(key - a[mid]);
            int jump = (int) Math.ceil((diff * 1.0) / k);
            int left = differByK(a, k, lo, mid - jump, key);
            if (left == -1){
                return differByK(a, k, mid + jump, hi, key);
            }else return left;
        }
    }

    public static void main(String[] args) {
        int arr[] = {20, 40, 50, 70, 70, 60};
        int k = 20;
        int key = 60;

        q7 test = new q7();
        System.out.println(test.differByK(arr, k, key));
    }
}
