package javaCode.queue;

import java.util.Iterator;

//base on linklist
public class Queue<T> implements Iterable<T> {
    
    //test
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (String string : queue) {
            System.out.println(string);
        }

        System.out.println("---------------");
        String ret = queue.dequeue();
        System.out.println("dequeu => " + ret);
        System.out.println("nowSize => " + queue.size());

    }

    private Node head;
    private Node last;
    private int N;

    private class Node{
        public T item;
        public Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void enqueue(T t){
       if(last == null) {
           last = new Node(t, null);
           head.next = last;
       }else{
           Node oldLast = last;
           last = new Node(t, null);
           oldLast.next = last;
       }

       N ++;

    }

    public T dequeue(){
        if(isEmpty()) return null;
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if(isEmpty()) last = null;
        return oldFirst.item;
    }

    //外部遍历
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub

        return new QIterator();
    }

    private class QIterator implements Iterator{
        
        private Node n;

        public QIterator() {
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