package arrays.v1.rearrangement.rotation;

/**
 * Created by Ravikanth on 2/21/2018.
 */
public class q7 {

    private int maxRotatingSum(int[] a){
        int T = 0, S = 0;
        for (int i = 0; i < a.length; i++) {
            T+= a[i];
            S+= i*a[i];
        }

        int maxSoFar = S;

        for (int i = 1; i < a.length; i++) {
            S = S - T + (a.length)*a[i - 1];
            maxSoFar = Math.max(maxSoFar, S);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        q7 test = new q7();
        int[] a = {1, 20, 2, 10};
        System.out.println(test.maxRotatingSum(a));
    }
}
