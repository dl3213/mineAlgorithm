package heap;

public class MinPriorityQueue<T extends Comparable<T>> {
    
    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        
        while (!queue.isEmpty()) {
            String max = queue.delMin();
            System.out.print(max+" ");
        }
    }

    private T[] items;
    private int N;

    public MinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }
    public int size(){
        return N; 
    }
    public boolean  isEmpty(){
        return N==0;
    }
    private boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }

    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //上浮算法，使得索引k的值处于正确位置
    private void swim(int k){
        //循环比较当前结点的值和父结点的值
        while (k>1) {
            if(less(k,k/2)) exch(k, k/2);
            k = k/2;
        }
    }

    public T delMin(){
        T min = items[1];
        //交换索引1和最大索引的元素，让完全二叉树中最右侧的元素变为临时根结点
        exch(1, N);
        //最大索引处元素删除
        //items[N]= null;
        //元素个数-1
        N--;
        //通过下沉让堆重新有序
        sink(1);
        return min;
    }

    private void sink(int k){
        while (2*k<=N) {
            int min;
            if(2*k+1 <= N){
                if(less(2*k,2*k+1)){
                    min = 2*k;
                }else{
                    min = 2*k + 1;
                }
            }else{
                min = 2*k;
            }
            if(less(k, min)) break;
            exch(k, min);
            k = min;
        }
    }
}