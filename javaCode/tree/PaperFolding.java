package javaCode.tree;

import javaCode.queue.Queue;

//折纸问题
public class PaperFolding {
    public static void main(String[] args) {
        Node<String> tree = createTree(2);
        printTree(tree);
    }

    public static Node<String> createTree(int N){

        Node<String> root = null;

        for (int i = 0; i < N; i++) {
            //第一次对折
            if(i == 0){
                root = new Node("down",null,null);
                continue;
            }

            //非第一次对折
            //辅助队列，层次遍历，找叶子结点
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);

            while (!queue.isEmpty()) {
                //弹出
                Node<String> tmp = queue.dequeue();
                //若有左，则放入队列
                if(tmp.left != null ) queue.enqueue(tmp.left);
                //若有右，则放入队列
                if(tmp.right != null ) queue.enqueue(tmp.right);
                //若同时没有左右，则其是叶子结点，只需给其添加左右
                if(tmp.left == null && tmp.right == null){
                    tmp.left = new Node<String>("down",null,null);
                    tmp.right = new Node<String>("up",null,null);
                }
            }
        }
        return root;
    }

    public static void printTree(Node<String> root){
        if(root == null) return;//null处理

        //递归遍历root的左
        if(root.left != null){
            printTree(root.left);
        }

        //root
        System.out.print(root.item + " ");

        //递归遍历root的右
        if(root.right != null){
            printTree(root.right);
        }
    }

    private static class Node<T> {

        public T item;
        public Node left;
        public Node right;
    
        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }   
    }
}