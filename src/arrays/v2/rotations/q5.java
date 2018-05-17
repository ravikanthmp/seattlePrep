package arrays.v2.rotations;

/**
 * Created by Ravikanth on 3/28/2018.
 */
public class q5 {

    public int findInSortedAndRotatedArrayOnePass(int[] arr, int key) {
        return findInSortedAndRotatedArrayOnePass(arr, 0, arr.length - 1, key);
    }

    private int findInSortedAndRotatedArrayOnePass(int[] a, int lo, int hi, int key) {
        if (lo > hi) return -1;
        if (lo == hi) return a[lo] == key ? lo : -1;
        int mid = lo + (hi - lo) / 2;
        if (key == a[mid]) return mid;
        if (a[lo] < a[mid]) {
            if (isWithinRange(a, lo, mid, key)) return binarySearch(a, lo, mid, key);
            else return findInSortedAndRotatedArrayOnePass(a, mid + 1, hi, key);
        } else {
            if (isWithinRange(a, mid + 1, hi, key)) return binarySearch(a, mid + 1, hi, key);
            else return findInSortedAndRotatedArrayOnePass(a, lo, mid, key);
        }
    }

    private boolean isWithinRange(int[] a, int lo, int hi, int key) {
        if (lo > hi || a[lo] > a[hi]) return false;
        return (a[lo] <= key && key <= a[hi]);
    }


    private int findPivot(int[] a, int left, int right) {

        if (left == right) return left;

        int mid = left + (right - left) / 2;

        if (mid < right && a[mid] < a[mid + 1]) {
            return mid;
        } else if (mid > left && a[mid] < a[mid - 1]) {
            return mid - 1;
        } else if (a[left] < a[mid]) {
            return findPivot(a, mid + 1, right);
        } else
            return findPivot(a, left, mid - 1);

    }

    public int findInSortedAndRotatedArray(int[] a, int key) {
        int pivot = findPivot(a, 0, a.length - 1);
        int loc = binarySearch(a, 0, pivot, key);
        return loc != -1 ? loc : binarySearch(a, pivot + 1, a.length - 1, key);
    }

    private int binarySearch(int[] a, int lo, int hi, int key) {
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key == a[mid]) return mid;
            else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            int T = Integer.parseInt(br.readLine());
//            int[] arr = null;
//            StringTokenizer stringTokenizer = null;
//            q3 driver = new q3();
//
//            for (int i = 0; i < T; i++) {
//                stringTokenizer = new StringTokenizer(br.readLine());
//                int N = Integer.parseInt(stringTokenizer.nextToken());
//                arr = new int[N];
//                stringTokenizer = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
//                }
//                stringTokenizer = new StringTokenizer(br.readLine());
//                int d = Integer.parseInt(stringTokenizer.nextToken());
//
//                driver.rotate(arr, d);
//                System.out.println(print(arr));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        q5 test = new q5();
        int[] arr = {5, 6, 7, 8, 9, 10, -1, 0, 1, 2, 3, 4};

        int key = 50;
        for (int a : arr) {
            System.out.println(test.findInSortedAndRotatedArrayOnePass(arr, a));
        }

    }
}
