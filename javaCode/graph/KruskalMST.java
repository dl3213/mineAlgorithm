package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import  heap.MinPriorityQueue;
import  queue.Queue;
import  tree.UnionFindTree3;

public class KruskalMST{

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

        KruskalMST kruskalMST = new KruskalMST(g);
        Queue<Edge> edges = kruskalMST.edges();
        for (Edge e : edges) {
            int v = e.either();
            int w = e.other(v);
            double wei = e.weight();
            System.out.println( v +"-" + w + " :: " + wei);
        }
    }

    private Queue<Edge> mst;//保存最小生成树的所有边
    private UnionFindTree3 uf;//索引代表顶点，使用uf.connect(v,w)可以判断两顶点是否在同一棵树，uf.union可以把两顶点的树合并
    private MinPriorityQueue pq;//存图中所有的边

    public KruskalMST(EdgeWeightedGraph g){
        this.mst = new Queue<Edge>();
        this.uf = new UnionFindTree3(g.V());
        this.pq = new MinPriorityQueue<>(g.E()+1);

        for (Edge e : g.edges()) {
            pq.insert(e);
        }

        while (!pq.isEmpty() && mst.size() < g.V() - 1) {
            Edge e = (Edge) pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Queue<Edge> edges(){
        return this.mst;
    }
    
}