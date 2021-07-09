package graph;

import queue.Queue;

public class EdgeWeightedGraph {
    
    private final int V;
    private int E;
    private Queue<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        this.E ++;
    }

    public Queue<Edge> adj(int v){
        return adj[v];
    }

    public Queue<Edge> edges(){
        Queue<Edge> allEdges = new Queue<Edge>();
        for (int v = 0; v < this.V; v++) {
            for (Edge edge : adj(v)) {
                if(edge.other(v) < v) allEdges.enqueue(edge);
            }
        }
        return allEdges;
    }

    
}