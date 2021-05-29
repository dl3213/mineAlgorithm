package javaCode.graph;


public class DepthFirstSearch {

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

        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        System.out.println("0 to => " + dfs.count);

        System.out.println("0 to 5 ? => " + dfs.marked(5));
        System.out.println("0 to 7 ? => " + dfs.marked(7));

    }

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s){
        this.marked = new boolean[g.V()];
        this.count = 0;
        dfs(g,s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if(!marked[w]) dfs(g, w);
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