package graph.networkflows;

/**
 * Created by Ravikanth on 5/17/2018.
 */
public class FlowEdge {

    int u, v;
    int c, f;

    public FlowEdge(int u, int v, int c) {
        this.u = u;
        this.v = v;
        this.c = c;
    }

    public int from(){
        return u;
    }

    public int to(){
        return v;
    }

    public double capacity(){
        return c;
    }

    public int residualCapacityTo(int x){
        if (x == v){
            return c - f;
        }else  {
            return f;
        }
    }

    public void addResidualFlowTo(int x, int val){
        if (x == u){
            f += val;
        }else {
            f -= val;
        }
    }
}
