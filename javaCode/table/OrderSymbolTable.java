package table;

public class OrderSymbolTable<Key extends Comparable<Key>,Val> {
    
    public static void main(String[] args) {
        OrderSymbolTable<Integer,String> table = new OrderSymbolTable<>();
        table.put(1,"a");
        table.put(2,"b");
        table.put(4,"c");
        table.put(7,"d");

        table.put(3,"ee");
    }

    private Node head;
    private int N;

    private class Node{
        public Key key;
        public Val val;
        public Node next;

        public Node(Key key, Val val, OrderSymbolTable<Key, Val>.Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public OrderSymbolTable(){
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public void put(Key key, Val val){
        Node cur = head.next;
        Node pre = head;
        while (cur != null && key.compareTo(cur.key) > 0) {
            pre = cur;
            cur = cur.next;
        }

        if(cur != null && key.compareTo(cur.key) == 0){
            cur.val = val;
            return;
        }

        Node newNode = new Node(key, val, cur);
        pre.next = newNode;

        N ++;
    }

    public void delete(Key key){
        Node n = head;
        while (n.next != null) {
            if(n.next.key.equals(key)){
                n.next = n.next.next;
                N --;
                return;
            }

            n = n.next;
        }
    }

    public Val get(Key key){
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if(n.key.equals(key)){
                return n.val;
            }
        }
        return null;
    }
}