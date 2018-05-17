package arrays.v2.orderstatistics;

/**
 * Created by Ravikanth on 4/19/2018.
 */
public class q8 {

    public void elementsWithTwoGreater(int[] a){
        elementsWithTwoGreater(a, 0, a.length - 1);
    }

    private void elementsWithTwoGreater(int[] a, int lo, int hi) {

        int k = a.length - 3;
        int p = partition(a, lo, hi);

        while (p != k) {
            if (p > k) {
                p = partition(a, lo, p - 1);
            }else{
                p = partition(a, p + 1, hi);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = lo; i <= p ; i++) {
            sb.append(a[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo + 1, j = lo, pivot = a[lo];
        while (i <= hi) {
            if (a[i] < pivot) exch(a, ++j, i++);
            else i++;
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        q8 test = new q8();
        int[] a = {2, 8, 7, 1, -9, 81, 5};
        test.elementsWithTwoGreater(a);
    }
}
