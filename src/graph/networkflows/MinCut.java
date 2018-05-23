package graph.networkflows;

/**
 * Created by Ravikanth on 5/18/2018.
 */
public class MinCut {

    FlowNetwork G;
    int src, tgt;

    public MinCut(FlowNetwork graph, int s, int t) {
        G = graph;
        src = s;
        tgt = t;
        printMinCutVertices();
    }


    public void printMinCutVertices() {
        FordFulkerson ff = new FordFulkerson(G, src, tgt);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < ff.getVisited().length; i++) {
            if (ff.getVisited()[i]) sb.append(i).append(" ");
            else sb2.append(i).append(" ");
        }

        System.out.println("Cut 1 : " + sb.toString());
        System.out.println("Cut 2 : " + sb2.toString());

    }

    public static void main(String[] args) {
        int[][] matrix =
                { {0, 16, 13, 0, 0, 0},
                        {0, 0, 10, 12, 0, 0},
                        {0, 4, 0, 0, 14, 0},
                        {0, 0, 9, 0, 0, 20},
                        {0, 0, 0, 7, 0, 4},
                        {0, 0, 0, 0, 0, 0}
                };

        FlowNetwork graph = new FlowNetwork(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0){
                    graph.addEdge(i, j, matrix[i][j]);
                }
            }
        }

        MinCut minCut = new MinCut(graph, 0, 5);

    }

}
