package graph.networkflows;

/**
 * Created by Ravikanth on 5/19/2018.
 */
public class BipartiteMatching {

    public BipartiteMatching(int[][] A) {
        int app = A.length;
        int jobs = A[0].length;
        int N = 2 + app + jobs;

        int src = app + jobs;
        int t = src + 1;
        FlowNetwork ff = new FlowNetwork(N);

        for (int i = 0; i < app; i++) {
            ff.addEdge(src, i, 1);
            for (int j = 0; j < jobs; j++) {
                if (A[i][j] != 0) {
                    ff.addEdge(i, app + j, 1);
                }
            }
        }

        for (int i = 0; i < A[0].length; i++) {
            ff.addEdge(app + i, t, 1);
        }

        FordFulkerson fordFulkerson = new FordFulkerson(ff, src, t);

        System.out.println("Matched " + fordFulkerson.getMaxFlow());
    }

    public static void main(String[] args) {
        int bpGraph[][] = {{0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1}};

        BipartiteMatching matching = new BipartiteMatching(bpGraph);


    }
}
