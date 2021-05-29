package javaCode.graph;

public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return this.weight;
    }
    public int either(){
        return this.v;
    }
    public int other(int vertex){
        return vertex == this.v ? this.w:this.v;
    }

    @Override
    public int compareTo(Edge o) {
        // TODO Auto-generated method stub
        int cmp;
        if(this.weight() > o.weight()) cmp = 1;
        else if(this.weight() < o.weight()) cmp = -1;
        else cmp = 0;
        return cmp;
    }
}