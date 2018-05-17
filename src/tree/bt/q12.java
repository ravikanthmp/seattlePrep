package tree.bt;

import tree.Node;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ravikanth on 5/11/2018.
 */
public class q12 {
    Map<Integer, Map<Integer, StringBuilder>> map;
    int minCol ;

    public q12() {
        map = new TreeMap<>();
        minCol = Integer.MAX_VALUE;
    }

    public void printDiagonal(Node root) {
        printDiagonal(root, 0, 0);
        for (int c = 0; c >= minCol; c--){
            
        }
    }

    private void printDiagonal(Node node, int r, int c) {
        if (node != null) {
            put(node, r, c);
            printDiagonal(node.left, r - 1, c - 1);
            printDiagonal(node.right, r + 1, c + 1);
        }
    }

    private void put(Node node, int r, int c) {
        if (!map.containsKey(c)) map.put(c, new TreeMap<>());
        Map<Integer, StringBuilder> rowMap = map.get(c);
        if (!rowMap.containsKey(r)) rowMap.put(r, new StringBuilder());
        rowMap.get(r).append(node.data).append(" ");
        minCol = Integer.min(minCol, c);
    }
}
