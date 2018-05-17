package stack.operations;

import stack.Stack;
import stack.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 5/2/2018.
 */
public class q3 {

    static class Interval implements Comparable<Interval>{
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }

    public Stack<Comparable> merge(Interval[] intervals) throws Exception {
        Stack<Comparable> stack = new Stack<>();

        Arrays.sort(intervals, Comparator.reverseOrder());

        for (Interval i : intervals){
            stack.push(i);
        }

        Stack<Comparable> mergedStack = new Stack<>();

        Comparable top;
        while (!stack.isEmpty()){
            top = stack.pop();

            while (!stack.isEmpty() && areIntervalsMerging(top, stack.peek())){
                top = merge(top, stack.pop());
            }

            mergedStack.push(top);
        }

        stack = new Stack<>();
        while (!mergedStack.isEmpty()){
            stack.push(mergedStack.pop());
        }
        return stack;
    }

    private boolean areIntervalsMerging(Comparable a, Comparable b){

        if (((Interval)a).start == ((Interval)b).start){
            return true;
        }else if (((Interval)a).start < ((Interval)b).start){
            return ((Interval)b).start <= ( (Interval)a).end;
        }else
            return ((Interval) a).start <= ((Interval) b).end;
    }

    private Interval merge(Comparable a, Comparable b){
        return new Interval(Math.min(((Interval) a).start, ((Interval) b).start), Math.max(((Interval) a).end, ((Interval) b).end));
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            Interval[] arr = null;
            StringTokenizer stringTokenizer = null;
            q3 driver = new q3();

            int i1, i2;
            for (int i = 0; i < T; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                arr = new Interval[N];

                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    i1 = Integer.parseInt(stringTokenizer.nextToken());
                    i2 = Integer.parseInt(stringTokenizer.nextToken());
                    arr[j] = new Interval(i1, i2);
                }

                Stack<Comparable> merge1 = driver.merge(arr);
                System.out.println(merge1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(Stack stack) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
