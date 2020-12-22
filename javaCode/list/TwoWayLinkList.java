package javaCode.list;

import java.util.Iterator;

//查询操作多=>顺序表
// 增删操作多=>链表

//=java.LinkedList
public class TwoWayLinkList<T> implements Iterable<T> {

    public static void main(String[] args) {
        {// test1
         TwoWayLinkList<String> sl = new TwoWayLinkList<String>();
         sl.insert("test1");
         sl.insert("test2");
         sl.insert("test3");
         sl.insert(1, "test02");
         for(String s : sl){
         System.out.println(s);
         }
         System.out.println("--------------------");
         System.out.println("first => " + sl.getFirst());
         System.out.println("last => " + sl.getLast());

         String getone = sl.get(1);
         System.out.println("now get 1 => " + getone);
         String remone = sl.remove(0);
         System.out.println("now remove => " + remone);
         

         sl.clear();
         System.out.println("after clear => " + sl.length());

         System.out.println("first => " + sl.getFirst());
         System.out.println("last => " + sl.getLast());
        }

    }

    private Node last;
    private Node head;
    private int N;

    private class Node{
        public T item;
        public Node pre;
        public Node next;
        public Node (T item, Node pre, Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }


    public TwoWayLinkList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;   
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T getFirst(){
        if(isEmpty()) return null;

        return head.next.item;
    }

    public T getLast(){
        if(isEmpty()) return null;

        return last.item;
    }

    public T get(int i) {
        Node n = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(int i, T t) {
        Node pre = head;
        for (int j = 0; j < i; j++) {
            pre=pre.next;
        }
        Node cur = pre.next;
        Node newnode = new Node(t, pre, cur);
        pre.next = newnode;
        cur.pre = newnode;
        N++; 
    }

    public void insert(T t) {
       if(isEmpty()) {
           Node n1 = new Node(t, head, null);
           last = n1;
           head.next = last;
       }else{
        Node oldlast = last;
        Node n2 = new Node(t, oldlast, null);
        oldlast.next = n2;
        last = n2;

       }

       N++;
    }

    public T remove(int i) {
        Node pre = head;
        for (int j = 0; j <= i-1; i++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        Node nNode = cur.next;
        pre.next = nNode;
        nNode.pre = pre;
        N--;
        return cur.item;

    }

    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if(n.item.equals(t)) return i;
        }

        return -1;
    }

    public void resize(int newSize){
       
    }

    private class TIntertor implements Iterator {
        private Node n;

        public TIntertor() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub

        return new TIntertor();
    }

}