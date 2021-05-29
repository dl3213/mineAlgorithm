package javaCode.graph;

import javaCode.queue.Queue;

public class BreadFirstSearch {

    public static void main(String[] args) {
        Graph graph = new Graph(13);

        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        BreadFirstSearch bfs = new BreadFirstSearch(graph, 0);
        System.out.println("0 to => " + bfs.count);

        System.out.println("0 to 5 ? => " + bfs.marked(5));
        System.out.println("0 to 7 ? => " + bfs.marked(7));

    }

    private boolean[] marked;
    private int count;
    private Queue<Integer> waitSearch;

    public BreadFirstSearch(Graph g, int s){
        this.marked = new boolean[g.V()];
        this.count = 0;
        this.waitSearch = new Queue<Integer>();
        bfs(g,s);
    }

    private void bfs(Graph g, int v) {
        marked[v] = true;
        waitSearch.enqueue(v);
        while (!waitSearch.isEmpty()) {
           Integer wait = waitSearch.dequeue();
           for (Integer w : g.adj(wait)) {
               if(!marked(w)) bfs(g, w);
           }
        }

        this.count ++;
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return this.count;
    }
}