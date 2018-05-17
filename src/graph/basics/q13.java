package graph.basics;

import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class q13 {

    private boolean[][] visited;

    public q13(int[][] A) {
        this.visited = new boolean[A.length][A[0].length];
        int components = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (!visited[i][j]){
                    components++;
                    dfsUtil(A, new Position(i, j));
                }
            }
        }
        System.out.println(components);
    }

    class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void dfsUtil(int[][] A, Position src){
            visited[src.x][src.y] = true;
            for (Position pos : neighbours(A, src)){
                if (!visited[pos.x][pos.y]){
                    dfsUtil(A, pos);
                }
            }
    }


    private List<Position> neighbours(int[][] A, Position pos){
        int m = A.length;
        int n = A[0].length;

        List<Position> positions  = new LinkedList<>();

        if (pos.y > 0 && A[pos.x][pos.y-1] <= A[pos.x][pos.y]){
            positions.add(new Position(pos.x, pos.y - 1));
        }

        if (pos.y < n - 1 && A[pos.x][pos.y+1] <= A[pos.x][pos.y]){
            positions.add(new Position(pos.x, pos.y + 1));
        }
        if (pos.x > 0 && A[pos.x-1][pos.y] <= A[pos.x][pos.y]){
            positions.add(new Position(pos.x-1, pos.y ));
        }
        if (pos.y < m - 1 && A[pos.x][pos.y+1] <= A[pos.x][pos.y]){
            positions.add(new Position(pos.x, pos.y + 1));
        }
        return positions;
    }

    public static void main(String[] args) {
        int adj[][] = {{3, 3},
            {1, 1}};
        q13 test = new q13(adj);

    }
}
