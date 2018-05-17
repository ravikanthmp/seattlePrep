package graph;

/**
 * Created by Ravikanth on 5/14/2018.
 */
public class Edge implements Comparable<Edge>{

    int u, v;
    double w;

    public Edge(int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int other(int u){
        if (this.u == u) return this.v;
        else return this.u;
    }

    public int either(){
        return Math.random() < 0.5 ? u : v;
    }

    public double weight(){
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(w, o.w);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }

    public int from(){
        return u;
    }

    public int to(){
        return v;
    }
}
