package javaCode.tree;

public class RedBlackTree<Key extends Comparable<Key>,Value> {

    public static void main(String[] args) {
        RedBlackTree<String,String> tree = new RedBlackTree<>();
        tree.put("1","a");
        tree.put("2","b");
        tree.put("3","c");
        System.out.println(tree.get("1") + " " + tree.get("2") + " " +tree.get("3"));
    }

    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node<Key,Value> {

        public Key key;
        private Value value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public int siez(){
         return N;
    }

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
        root.color = BLACK;
    }
    public Node put(Node h, Key key, Value val){
        if(h == null){
            N++;
            return new Node(key,val,null,null,RED);
        } 
        int cmp = key.compareTo((Key) h.key);
        if(cmp<0){
            h.left = put(h.left,key,val);
        }else if(cmp>0){
            h.right = put(h.right,key,val);
        }else{
            h.value = val;
        }
        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }

    public Value get(Key key){
        return get(root, key);
    }
    public Value get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo((Key) x.key);
        if(cmp<0){
            return get(x.left,key);
        }else if(cmp>0){
            return get(x.right,key);
        }else{
            return (Value) x.value;
        }
    }
}