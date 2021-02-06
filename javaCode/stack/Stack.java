package javaCode.stack;

import java.util.Iterator;

//base on linklist

public class Stack<T> implements Iterable<T> {

    //test
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for(String item : stack){
            System.out.println(item);
        }
        System.out.println("------------------");

        System.out.println("now zise =>  " + stack.size());
        String ret = stack.pop();
        System.out.println("pop => " + ret);
        System.out.println("now zise =>  " + stack.size());
    }

    private Node head;
    private int N;

    private class Node{
        public T item;
        public Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        Node oldFirst = head.next;//找到首结点指向的第一个结点
        Node newNode = new Node(t,null);//创建新结点
        head.next = newNode;//让首结点指向新结点
        newNode.next = oldFirst;//新结点指向原首结点
        N++;//+1
    }

    public T pop(){
        Node oldFirst = head.next;//找到首结点指向的第一个结点
        if(oldFirst == null) return null;
        head.next = oldFirst.next;//首结点指向原第一个结点的下一个结点
        N --;//-1
        return oldFirst.item;
    }

    //外部遍历
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub

        return new SIterator();
    }

    private class SIterator implements Iterator{
        
        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return n.next != null;
        }

        @Override
        public Object next() {
            // TODO Auto-generated method stub
            n = n.next;
            return n.item;
        }

       
        
    }
    
}