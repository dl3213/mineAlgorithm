package javaCode.graph;

public class DirectedCycle {
    
    private boolean[] marked;//索引代表顶点，表示当前顶点是否已经被搜索
    private boolean hasCycle;
    private boolean[] onStack;//索引代表顶点，记录当前顶点有没有已经处于正在搜索的有向路径上

    public DirectedCycle(Digraph g){

        this.marked = new boolean[g.V()];
        this.hasCycle = false;
        this.onStack = new boolean[g.V()];

        for (int v = 0; v < g.V(); v++) {
            if(!marked[v]) dfs(g,v);
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (Integer w : g.adj(v)) {
            if(!marked[w]) dfs(g, w);
            if(onStack[w]){
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return this.hasCycle;
    }
}