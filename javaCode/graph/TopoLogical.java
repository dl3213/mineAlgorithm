package javaCode.graph;

import javaCode.stack.Stack;

public class TopoLogical {

    public static void main(String[] args) {
        Digraph g = new Digraph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);

        TopoLogical topoLogical = new TopoLogical(g);
        Stack<Integer> order = topoLogical.order;
        for (Integer integer : order) {
            System.out.print(integer + "->");
        }
        
    }

    private Stack<Integer> order;

    public TopoLogical(Digraph g){
        DirectedCycle directedCycle = new DirectedCycle(g);
        if(!directedCycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(g);
            order = depthFirstOrder.reversePost();
        }
    }

    private boolean isCycle(){
        return order == null;
    }

    public Stack<Integer> order(){
        return this.order;
    }

}