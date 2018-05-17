package graph.mst;

import graph.Edge;

/**
 * Created by Ravikanth on 5/15/2018.
 */
public interface MST {

    public Iterable<Edge> edges();

    public double weight();
}
