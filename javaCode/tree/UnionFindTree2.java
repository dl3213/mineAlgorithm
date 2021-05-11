package javaCode.tree;

import java.util.Scanner;

public class UnionFindTree2 {
    
    public static void main(String[] args) {
        UnionFindTree2 uf = new UnionFindTree2(5);
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
    private int count;

    public UnionFindTree2(int N) {
        this.count = N;
        this.eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
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
        eleAndGroup[pRoot] = qRoot;
        this.count --;

    }
    
}