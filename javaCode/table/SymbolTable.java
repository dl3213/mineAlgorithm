package table;

public class SymbolTable<Key,Val> {
    
    public static void main(String[] args) {
        SymbolTable<Integer,String> table = new SymbolTable<>();
        table.put(1,"a");
        table.put(2,"b");
        table.put(3,"c");

        System.out.println("nowSize => " + table.size());
        table.put(2,"d");
        System.out.println("nowSize => " + table.size());

        System.out.println("nowget 2 => " + table.get(2));

        table.delete(2);
        System.out.println("nowSize => " + table.size());
    }

    private Node head;
    private int N;

    private class Node{
        public Key key;
        public Val val;
        public Node next;

        public Node(Key key, Val val, SymbolTable<Key, Val>.Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SymbolTable(){
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public void put(Key key, Val val){
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if(n.key.equals(key)) {
                n.val = val;
                return;
            }
        }

        Node newNode = new Node(key, val, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;
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