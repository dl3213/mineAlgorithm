package tree;

import queue.Queue;

//base on linkedlist
public class BinaryTree<Key extends Comparable<Key>,Value> {

    public static void main(String[] args) {
        // BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        // binaryTree.put(1,"a");
        // binaryTree.put(2,"b");
        // binaryTree.put(3,"c");
        // System.out.println("tree size => " + binaryTree.size());
        // System.out.println("key=2,val=" + binaryTree.get(2));
        // binaryTree.delete(2);
        // System.out.println("tree size => " + binaryTree.size());
        // System.out.println("key=2,val=" + binaryTree.get(2));

        BinaryTree<String, String> binaryTree = new BinaryTree<String, String>();
        binaryTree.put("E","5");
        binaryTree.put("B","2");
        binaryTree.put("G","7");
        binaryTree.put("A","1");
        binaryTree.put("D","4");
        binaryTree.put("F","6");
        binaryTree.put("H","8");
        binaryTree.put("C","3");
        // Queue<String> keys = binaryTree.layerErgodic();
        // for (String string : keys) {
        //     System.out.println(string + " => " + binaryTree.get(string));
        // }
        System.out.println(" maxDepth => " + binaryTree.maxDepth());
    }

    private Node root;
    private int N;
    
    public int size(){
        return N;
    }

    public void put(Key key, Value value){
        root = put(root,key,value);
    }

    private Node put(Node x, Key key, Value value){
        //若x为空，
        if( x == null){
            N ++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo((Key) x.key);
        //若x不为空，
        //比较x结点的键和key的大小：  
        if(cmp>0){
            //若<,找x的右
            x.right = put( x.right, key, value);
        }else if(cmp<0){
            //若<,找x的左
            x.left = put( x.left, key, value);
        }else{//若=，则替换
            x.value = value;
        }
             
        return x;
    }

    public Value get(Key key){

        return get(root, key);
    }

    public Value get(Node x, Key key){
        //x==null
        if( x == null) return null;

        //x!=null
        //比较key和结点键的大小
        int cmp = key.compareTo((Key) x.key);
        //若x不为空，
        //比较x结点的键和key的大小：  
        if(cmp>0){
            //若<,找x的右
            return get(x.right,key);
        }else if(cmp<0){
            //若<,找x的左
            return get(x.left,key);
        }else{//若=，则找到键=key,返回value
            return (Value) x.value;
        }
    }

    public void delete(Key key){
        delete(root, key);
    }

    public Node delete(Node x, Key key){
        //x==null
        if(x==null) return null;
        //x!=null
        int cmp = key.compareTo((Key) x.key);
        if(cmp>0){
            //若<,找x的右
            x.right = delete(x.right,key);
        }else if(cmp<0){
            //若<,找x的左
            x.left =  delete(x.left,key);
        }else{
            N --;

            //若=，则找到键=key,完成删除x
            
            //找到右子树中最左的（最小的）,
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //并删除
            Node n = x.right;
            while (n.left != null) {
                if(n.left.left == null) n.left = null;
                else n = n.left;
            }

            //minNode.left = x.left
            minNode.left = x.left;
            //minNode.right = x.right
            minNode.right = x.right;
            //minNode = x的父结点
            x = minNode;
        }
        return x;
    }

    public Key min(){
        return (Key) min(root).key;
    }
    public Node min(Node x){
        if(x.left != null) return min(x.left);
        else return x;
    }

    public Key max(){
        return (Key) max(root).key;
    }
    public Node max(Node x){
        if(x.right != null) return max(x.right);
        else return x;
    }


    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue();
        preErgodic(root, keys);
        return keys;
    }
    private void preErgodic(Node x, Queue<Key> keys){
        if(x == null) return;
        //把x的key放入keys中
        keys.enqueue((Key) x.key);
        //递归遍历x的左
        if(x.left != null){
            preErgodic(x.left,keys);
        }
        //递归遍历x的右
        if(x.right != null){
            preErgodic(x.right,keys);
        }

    }

    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue();
        midErgodic(root, keys);
        return keys;
    }
    private void midErgodic(Node x, Queue<Key> keys){
        if(x == null) return;//null处理

        //递归遍历x的左
        if(x.left != null){
            midErgodic(x.left,keys);
        }

        //把x的key放入keys中
        keys.enqueue((Key) x.key);

        //递归遍历x的右
        if(x.right != null){
            midErgodic(x.right,keys);
        }

    }

    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue();
        afterErgodic(root, keys);
        return keys;
    }
    private void afterErgodic(Node x, Queue<Key> keys){
        if(x == null) return;//null处理

        //递归遍历x的左
        if(x.left != null){
            afterErgodic(x.left,keys);
        }

        //递归遍历x的右
        if(x.right != null){
            afterErgodic(x.right,keys);
        }

        //把x的key放入keys中
        keys.enqueue((Key) x.key);
    }

    public Queue<Key> layerErgodic(){
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        
        //默认放根
        nodes.enqueue(root);

        while (!nodes.isEmpty()) {
            //弹出一个结点，key入keys
            Node n = (Node) nodes.dequeue();
            keys.enqueue((Key) n.key);
            //判断当前有无左，有则入nodes
            if(n.left != null) nodes.enqueue(n.left);
            //判断当前有无右，有则入nodes
            if(n.right != null) nodes.enqueue(n.right);
        }
        return keys;
    }

    public int maxDepth(){
        return maxDepth(root);
    }
    private int maxDepth(Node x){
        if(x == null) return 0;
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        //x的左最大深度
        if(x.left != null) maxL = maxDepth(x.left);
        //x的右最大深度
        if(x.right != null) maxR = maxDepth(x.right);
        //比较
        max = maxL > maxR ? maxL + 1: maxR + 1;
        return max;
    }


    private class Node<Key,Value> {

        public Key key;
        private Value value;
        public Node left;
        public Node right;
    
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }   
    }
}