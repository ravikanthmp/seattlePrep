package arrays.v2.rearrangements;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/2/2018.
 */
public class q9 {

    class Sequence{
        int length;
        boolean firstHalfOdSequence;

        public Sequence() {
            length = 0;
            firstHalfOdSequence = false;
        }

        void clear(int defalutLength) {
            length = defalutLength;
            firstHalfOdSequence = true;
        }

        boolean include(int[] a, int j){
            if (j == 0) return true;
            else if (firstHalfOdSequence){
                if (a[j] > a[j-1]) return true;
                else firstHalfOdSequence = false;
            }
            return a[j] < a[j-1];
        }

        void increment(){
            length++;
        }

        void clearWithRange(int l, int r){
            clear(r - l + 1);
        }

        public int getLength() {
            return length;
        }
    }

    public int maxLengthBitonicSA(int[] a){
        int maxLen = 0;
        Sequence seq = new Sequence();
        for (int i = 0; i < a.length; i++) {
            if (seq.include(a, i)){
                seq.increment();
                maxLen = Math.max(maxLen, seq.getLength());
            }else {
                seq.clearWithRange(i - 1, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            int[] arr = null;
            StringTokenizer stringTokenizer = null;
            q9 test = new q9();

            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());

                arr = new int[N];
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[j] = Integer.parseInt(stringTokenizer.nextToken());
                }

                System.out.println(test.maxLengthBitonicSA(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
