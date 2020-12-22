package javaCode.list;

import java.util.Iterator;

//=java.LinkList
public class LinkList<T> implements Iterable<T> {

    public static void main(String[] args) {
        {// test1
         LinkList<String> sl = new LinkList<String>();
         sl.insert("test1");
         sl.insert("test2");
         sl.insert("test3");
         sl.insert("test4");
         sl.insert(1, "test02");
         for(String s : sl){
         System.out.println(s);
         }
         System.out.println("--------------------");
         sl.reverse();
         for(String s : sl){
            System.out.println(s);
        }
        System.out.println("get mid => " + sl.getMid(sl.head));
        //  String getone = sl.get(1);
        //  System.out.println("now get => " + getone);
        //  String remone = sl.remove(0);
        //  System.out.println("now remove => " + remone);
        //  sl.clear();
        //  System.out.println("after clear => " + sl.length());
        }

    }
    public Node getEnter(Node first){
        Node fast = first;
        Node slow = fast;
        Node temp = null;
        while (fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                temp = first;
                continue;
            }
            if(temp != null) {
                temp = temp.next;
                if(temp.equals(slow)) break;
            }
        }
        return temp;
    }
    public boolean isCircle(Node first){
        Node fast = first;
        Node slow = fast;
        while (fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)) return true;
        }
        return false;
    }

    public T getMid(Node first){
        Node fast = first;
        Node slow = fast;
        while (fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    public void reverse(){
        if(isEmpty()) return;
        reverse(head.next);
    }
    public Node reverse(Node cur){
        if(cur.next == null) {
            head.next = cur;
            return cur;
        }
        Node pre = reverse(cur.next);
        pre.next = cur;
        cur.next = null;
        return cur;
    }

    private Node head;
    private int N;

    private class Node{
        public T item;
        public Node next;
        public Node (T item, Node next){
            this.item = item;
            this.next = next;
        }
    }


    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
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
        for (int j = 0; j <= i-1; j++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        Node newNode = new Node(t, cur);
        pre.next = newNode;
        N++;
    }

    public void insert(T t) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        this.N ++;
    }

    public T remove(int i) {
        Node pre = head;
        for (int j = 0; j <= i-1; i++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        Node nNode = cur.next;
        pre.next = nNode;
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

    private class LIntertor implements Iterator {
        private Node n;

        public LIntertor() {
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

        return new LIntertor();
    }

}