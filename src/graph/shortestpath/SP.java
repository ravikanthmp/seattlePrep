package graph.shortestpath;

import graph.Edge;

/**
 * Created by Ravikanth on 5/16/2018.
 */
public interface SP {

    public double distTo(int i);

    public boolean hasPathTo(int i);

    Iterable<Edge> pathTo(int i);

    public void printPathTo(int i );
}
