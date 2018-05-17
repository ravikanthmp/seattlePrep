package uf;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class UnionFind {

    int[] ids;
    int[] size;

    public UnionFind(int N) {
        ids = new int[N];
        size = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
            size[i] = 1;
        }
    }

    public void union(int i, int j) {
        int idOfI = root(i);
        int idOfJ = root(j);

        if (size[idOfI] >= size[idOfJ]) {
            ids[idOfJ] = idOfI;
            size[idOfI] += size[idOfJ];
        } else {
            ids[idOfI] = idOfJ;
            size[idOfJ] += size[idOfI];
        }
    }

    public boolean find(int i, int j) {
        return root(i) == root(j);
    }

    private int root(int i) {
        while (ids[i] != i) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        System.out.println(uf.find(1, 3));

        uf.union(1, 3);
        ;
        System.out.println(uf.find(1, 3));
    }
}
