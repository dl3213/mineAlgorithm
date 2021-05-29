package javaCode.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javaCode.queue.Queue;

public class Graph {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(
            new FileReader(new File("javaCode\\tree\\roadProject.txt")));
        
        int cityNum = Integer.parseInt(br.readLine());
        System.out.println("citys => " + cityNum);
        Graph graph = new Graph(cityNum);
        int roadNum = Integer.parseInt(br.readLine());
        System.out.println("roads => " + roadNum);

        for (int i = 1; i <= roadNum; i++) {
            String line = br.readLine();
            System.out.println("get => " + line);
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            graph.addEdge(v, w);
            
        }

        DepthFirstSearch dfs = new DepthFirstSearch(graph, 9);
        System.out.println("9 to 8 => " + dfs.marked(8));
        System.out.println("9 to 10 => " + dfs.marked(10));
    }

    private final int V;//顶点数
    private int E;//边数
    private Queue<Integer>[] adj;//邻接表

    public Graph(int V){
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
        adj[w].enqueue(v);
        this.E ++;
    }

    public Queue<Integer> adj(int v){
        return adj[v];
    }
}