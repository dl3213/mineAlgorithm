package javaCode.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javaCode.heap.IndexMinPriorityQueue;
import javaCode.queue.Queue;

public class DijkstraSP {

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(
            new FileReader(new File("javaCode\\graph\\minRoute.txt")));
        
        int points = Integer.parseInt(br.readLine());
        System.out.println("points => " + points);
        EdgeWeightedDirectedGraph g = new EdgeWeightedDirectedGraph(points);
        int roadNum = Integer.parseInt(br.readLine());
        System.out.println("roads => " + roadNum);

        for (int i = 1; i <= roadNum; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);
            g.addEdge(new DirectedEdge(v, w, weight));
            
        }

        DijkstraSP sp = new DijkstraSP(g,0);
        Queue<DirectedEdge> edges = sp.path2(6);
        for (DirectedEdge e : edges) {
            int v = e.from();
            int w = e.to( );
            double wei = e.weight();
            System.out.println( v +"-" + w + " :: " + wei);
        }
    }
    
    private DirectedEdge[] edge2;//索引代表顶点，值代表从顶点s到当前顶点的最短路径上的最后一条边
    private double[] dist2;//索引代表顶点，值代表从顶点s到当前顶点的最短路径的总权重
    private IndexMinPriorityQueue<Double> pq;//存放树中顶点与非顶点之间的有效横切边

    public DijkstraSP(EdgeWeightedDirectedGraph g, int s){
        this.edge2 = new DirectedEdge[g.V()];
        this.dist2 = new double[g.V()];
        for (int i = 0; i < dist2.length; i++) {
            dist2[i] = Double.POSITIVE_INFINITY;
        }
        this.pq = new IndexMinPriorityQueue<>(g.V());
        dist2[s] = 0.0;
        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            relax(g,pq.delMin());
        }
    }

    private void relax(EdgeWeightedDirectedGraph g, int v) {
        for (DirectedEdge edge : g.adj(v)) {
            int w = edge.to();
            if(dist2(v) + edge.weight() < dist2(w)){
                dist2[w] = dist2[v] + edge.weight();
                edge2[w] = edge;
                if(pq.contains(w)) pq.changeItem(w, dist2(w));
                else pq.insert(w, dist2(w));
            }


        }
    }

    public double dist2(int v) {
        return dist2[v];
    }

    public boolean hasPahts2(int v){
        return dist2(v)<Double.POSITIVE_INFINITY;
    }

    public Queue<DirectedEdge> path2(int v){
        if(!hasPahts2(v)) return null;

        Queue<DirectedEdge> all = new Queue<>();
        while (true) {
            DirectedEdge e = edge2[v];
            if(e == null) break;
            all.enqueue(e);
            v = e.from();
        }
        return all; 
    }

}