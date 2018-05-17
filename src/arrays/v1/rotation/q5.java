package arrays.v1.rearrangement.rotation;

/**
 * Created by Ravikanth on 2/20/2018.
 */
public class q5 {

    public static void main(String[] args) {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            int T = Integer.parseInt(br.readLine());
//            int[] arr = null;
//            StringTokenizer stringTokenizer = null;
//            for (int i = 0; i < T; i++) {
//                stringTokenizer = new StringTokenizer(br.readLine());
//                int N = Integer.parseInt(stringTokenizer.nextToken());
//                int X = Integer.parseInt(stringTokenizer.nextToken());
//                arr = new int[N];
//                stringTokenizer = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
//                }
//                int ans = find(arr, X);
//
//                if (ans!= -1){
//                    System.out.println(ans);
//                }else {
//                    System.out.println("OOPS! NOT FOUND");
//                }
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        int[] a = {1, 2, 3, 0};
        System.out.println(findPivot(a));
    }

    private static int find(int[] a, int key) {
        return find(a, key, 0, a.length - 1);
    }

    private static int find(int[] a, int key, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;

        if (key == a[mid]) return mid;

        if (a[mid] > a[left]) {
            if (a[left] < key && key < a[mid])
                return bin_search(a, left, mid, key);
            else
                return find(a, key, mid + 1, right);
        } else {
            if (a[mid] < key && key < a[right]) {
                return bin_search(a, mid, right, key);
            } else {
                return find(a, key, left, mid - 1);
            }
        }

    }

    private static int bin_search(int[] a, int lo, int hi, int key) {
        int mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }


    /*
     * Method 2
     * a) Find pivot
     * b) Do binary search on the appropriate area
     */

    private static int findPivot(int[] a) {
        return findPivot(a, 0, a.length - 1);
    }

    private static int findPivot(int[] a, int lo, int hi) {
        if (lo >= hi) return -1;

        if (hi - lo == 1) {
            if (a[hi] < a[lo]) {
                return lo;
            } else return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (mid < hi) {
            if (a[mid] > a[mid + 1]) return mid;
        }

        if (mid > lo) {
            if (a[mid - 1] > a[mid]) return mid - 1;
        }

        if (a[mid] > a[lo]) return findPivot(a, mid + 1, hi);
        else return findPivot(a, lo, mid - 1);
    }
}
