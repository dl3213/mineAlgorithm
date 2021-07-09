package  graph;

import  queue.Queue;

public class Digraph {

    private final int V;
    private int E;
    private Queue<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    public int V(){
        return this.V;
    }
    public int E(){
        return this.E;
    }

    public void addEdge(int v, int w){
        adj[v].enqueue(w);
        //adj[w].enqueue(v);
        this.E ++;
    }

    public Queue<Integer> adj(int v){
        return adj[v];
    }

    private Digraph reverse(){
        Digraph r = new Digraph(this.V);
        for (int i = 0; i < this.V; i++) {
            for (Integer w : adj[i]) {
                r.addEdge(w, i);
            }
        }
        return r;
    }
    
}