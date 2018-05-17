package arrays.v1.rearrangement.rotation;

import arrays.Util;

/**
 * Created by Ravikanth on 2/22/2018.
 */
public class Rotation {

    private static void rotate(int[] arr, int startingPos, int leftSize, int rightSize){
        if (leftSize == rightSize) {
            swapBlock(arr, startingPos, startingPos + leftSize, leftSize);
            return;
        }else if (leftSize > rightSize){
            swapBlock(arr, startingPos, startingPos + leftSize, rightSize);
            rotate(arr, startingPos + rightSize, leftSize - rightSize, rightSize);
        }else {
            swapBlock(arr, startingPos, startingPos + leftSize, leftSize);
            rotate(arr, startingPos + leftSize, leftSize, rightSize - leftSize);
        }
    }

    private static void swapBlock(int[] arr, int left, int right, int size){
        int temp;
        for (int i = 0; i < size; i++) {
            temp = arr[left + i];
            arr[left + i] = arr[right + i];
            arr[right + i] = temp;
        }
    }

    public static void rotate(int[] arr, int k){
        rotate(arr, 0, k % arr.length, (arr.length - k) % arr.length);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        rotate(a, 2 );
        System.out.println(Util.print(a));
    }
}
