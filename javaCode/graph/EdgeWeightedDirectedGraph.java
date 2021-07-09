package  graph;

import  queue.Queue;

public class EdgeWeightedDirectedGraph {
    
    private final int V;
    private int E;
    private Queue<DirectedEdge>[] adj;

    public EdgeWeightedDirectedGraph(int v) {
        V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].enqueue(e);
        this.E ++;
    }

    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Queue<DirectedEdge> edges(){
        Queue<DirectedEdge> all = new Queue<>();
        for (int v = 0; v < this.V; v++) {
            for (DirectedEdge e : adj[v]) {
                all.enqueue(e);
            }
        }
        return all;
    }
}