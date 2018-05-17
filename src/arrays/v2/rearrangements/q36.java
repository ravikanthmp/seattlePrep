package arrays.v2.rearrangements;

import arrays.Util;

/**
 * Created by Ravikanth on 4/18/2018.
 */
public class q36 {

    private void exch(int[] A, int[] B, int i, int j) {
        exch(A, i, j);
        exch(B, i, j);
    }

    private void exch(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public void reorder(int[] a, int[] indexArr) {
        for (int i = 0; i < a.length; i++) {
            fix(a, indexArr, i);
        }
    }

    private void fix(int[] A, int[] B, int i) {

        int srcIndex = i;

        int nextIdx = B[i], nextElement;
        int currentEl = A[i], currentIdx = i;

        do{
            nextElement = A[B[currentIdx]];
            nextIdx = B[B[currentIdx]];
            A[B[currentIdx]] = currentEl;
            B[B[currentIdx]] = B[i];

            currentEl = nextElement;
            currentIdx = nextIdx;
        }while (currentIdx != srcIndex);

        A[srcIndex] = currentEl;
        B[srcIndex] = currentIdx;
    }


    public static void main(String[] args) {
        q36 test = new q36();
        int arr[] = {50, 40, 70, 60, 90};
        int index[] = {3,  0,  4,  1,  2};

        test.reorder(arr, index);

        System.out.println(Util.print(arr));
    }
}
