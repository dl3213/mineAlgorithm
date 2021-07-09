package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import stack.Stack;

public class DepthFirstPath {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader(new File("javaCode\\graph\\road2.txt")));
        
        int points = Integer.parseInt(br.readLine());
        System.out.println("points => " + points);
        Graph graph = new Graph(points);
        int roadNum = Integer.parseInt(br.readLine());
        System.out.println("roads => " + roadNum);

        for (int i = 1; i <= roadNum; i++) {
            String line = br.readLine();
            //System.out.println("get => " + line);
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            graph.addEdge(v, w);
            
        }

        DepthFirstPath dfs = new DepthFirstPath(graph, 0);
        Stack<Integer> path = dfs.path2(4);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : path) {
            sb.append(integer + "-");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }

    private boolean[] marked;
    private int s;//起点
    private int[] edge2;

    public DepthFirstPath(Graph g, int s){
        this.marked = new boolean[g.V()];
        this.s = s;
        this.edge2 = new int[g.V()];
        dfs(g,s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if(!marked[w]){
                edge2[w] = v;
                dfs(g, w);
            }
        }

    }

    public boolean hasPahts2(int v){
        return marked[v];
    }

    public Stack<Integer> path2(int v){
        if(!hasPahts2(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edge2[x]) {
            path.push(x);

        }
        path.push(s);
        return path;
    }
}