package javaCode.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javaCode.heap.IndexMinPriorityQueue;
import javaCode.queue.Queue;

public class PrimMST {

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(
            new FileReader(new File("javaCode\\graph\\tree4primmst.txt")));
        
        int points = Integer.parseInt(br.readLine());
        System.out.println("points => " + points);
        EdgeWeightedGraph g = new EdgeWeightedGraph(points);
        int roadNum = Integer.parseInt(br.readLine());
        System.out.println("roads => " + roadNum);

        for (int i = 1; i <= roadNum; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);
            g.addEdge(new Edge(v, w, weight));
            
        }

        PrimMST primMST = new PrimMST(g);
        Queue<Edge> edges = primMST.edges();
        for (Edge e : edges) {
            int v = e.either();
            int w = e.other(v);
            double wei = e.weight();
            System.out.println( v +"-" + w + " :: " + wei);
        }
    }
    
    private Edge[] edge2;//索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private double[] dist2;//索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private boolean[] marked;//索引代表顶点，顶点在树中ture，否则false
    private IndexMinPriorityQueue<Double> pq;//存放顶点和非树中顶点之间的有效横切边

    public PrimMST(EdgeWeightedGraph g) {
        this.edge2 = new Edge[g.V()];
        this.dist2 = new double[g.V()];
        for (int i = 0; i < dist2.length; i++) {
            dist2[i] = Double.POSITIVE_INFINITY;
        }
        this.marked = new boolean[g.V()];
        this.pq = new IndexMinPriorityQueue<Double>(g.V());

        dist2[0] = 0.0;
        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(g,pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.weight() < dist2[w]){
                edge2[w] = e;
                dist2[w] = e.weight();
                if(pq.contains(w)) pq.changeItem(w, e.weight());
                else pq.insert(w, e.weight());
            }
        }
    }

    public Queue<Edge> edges(){
        Queue<Edge> allEdges = new Queue<Edge>();
        for (int i = 0; i < edge2.length; i++) {
           if(edge2[i] != null) allEdges.enqueue(edge2[i]);
        }
        return allEdges;
    }

}