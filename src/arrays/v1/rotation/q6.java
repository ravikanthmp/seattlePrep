package arrays.v1.rearrangement.rotation;

/**
 * Created by Ravikanth on 2/21/2018.
 */
public class q6 {

    private int findPivot(int[] a, int lo, int hi){
        if (lo >= hi) return -1;

        int mid = lo + (hi - lo)/2;

        if (mid > lo && a[mid - 1] > a[mid]) return mid - 1;
        if (mid < hi && a[mid] > a[mid + 1]) return mid;

        return (a[lo] < a[mid]) ? findPivot(a, mid + 1, hi) : findPivot(a, lo, mid - 1);
    }

    private int binarySearch(int[] a, int lo, int hi, int key){
        int mid;
        while (lo <= hi){
            mid = lo + (hi - lo)/2;
            if (key == a[mid]){
                return mid;
            }else if (key < a[mid]){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private void findSumPairs(int[] a, int sum){
        int pivot = findPivot(a, 0, a.length - 1);

        int s1, idx;

        StringBuilder sb = new StringBuilder();

        for (int i = pivot + 1; i < a.length; i++) {
            s1 = a[i];
            idx = binarySearch(a, i + 1, a.length - 1, sum - s1);
            if (idx == - 1){
                idx = binarySearch(a, 0, pivot - 1, sum - s1);
            }
            if (idx != -1){
                sb.append("(" + s1 + ", " + a[idx] + ")").append(" ");
            }
        }

        for (int i = 0; i <= pivot; i++){
            s1 = a[i];
            idx = binarySearch(a, i + 1, pivot, sum - s1);
            if (idx != -1){
                sb.append("(" + s1 + ", " + a[idx] + ")").append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        q6 test = new q6();
        int[] a = {11, 15, 26, 38, 5, 7, 9, 10};
        test.findSumPairs(a, 16);
    }
}
