package javaCode.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UnionFindTree3 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader(new File("javaCode\\tree\\roadProject.txt")));
        
        int cityNum = Integer.parseInt(br.readLine());
        System.out.println("citys => " + cityNum);
        UnionFindTree3 uf = new UnionFindTree3(cityNum);
        int roadNum = Integer.parseInt(br.readLine());
        System.out.println("roads => " + roadNum);

        for (int i = 1; i <= roadNum; i++) {
            String line = br.readLine();
            System.out.println("get => " + line);
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            uf.union(p, q);
            
        }

        int roads = uf.count()-1;
        System.out.println("need => " + roads);
    }

    public static void main2(String[] args) {
        UnionFindTree3 uf = new UnionFindTree3(5);
        System.out.println("start now => " + uf.count());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 => ");
            int p = sc.nextInt();
            System.out.println("2 => ");
            int q = sc.nextInt();
            if(uf.connected(p, q)){
                System.out.println("same group");
                continue;
            }
            uf.union(p, q);
            System.out.println("now => " + uf.count());
        }
    }

    private int[] eleAndGroup;
    private int[] sz;
    private int count;

    public UnionFindTree3(int N) {
        this.count = N;
        this.eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        this.sz = new int[N];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }
    public int count(){
        return count;
    }
    public int find(int p){
        while (true) {
            if(p == eleAndGroup[p]) return p;
            p = eleAndGroup[p];
        }
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public void union(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        if(sz[pRoot]<sz[qRoot]){
             eleAndGroup[pRoot] = qRoot;
             sz[qRoot] += sz[pRoot];
        }
        else{
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } 
        this.count --;

    }
    
}