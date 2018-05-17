package arrays.v2.orderstatistics;

/**
 * Created by Ravikanth on 4/20/2018.
 */
public class q15 {

    public void smallestMissingNumber(int[] a) {
        int ans = find(a);
        if (ans == -1) {
            System.out.println("Soory dude!");
        } else {
            System.out.println(ans);
        }
    }

    private int find(int[] a) {
        int lo = 0, hi = a.length - 1, mid, ans = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] == mid) {
                lo = mid + 1;
            } else {
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        q15 test = new q15();
        int arr[] = {0, 1, 2, 3};
        test.smallestMissingNumber(arr);
    }
}
