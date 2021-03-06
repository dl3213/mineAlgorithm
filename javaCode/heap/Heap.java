package heap;

public class Heap<T extends Comparable<T>> {
    
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        String temp = null;
        while ((temp = heap.delMax())!=null) {
            System.out.print(temp+" ");
        }
    }

    private T[] items;
    private int N;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
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
            if(less(k/2,k)) exch(k/2, k);
            k = k/2;
        }
    }

    public T delMax(){
        T max = items[1];
        //交换索引1和最大索引的元素，让完全二叉树中最右侧的元素变为临时根结点
        exch(1, N);
        //最大索引处元素删除
        items[N]= null;
        //元素个数-1
        N--;
        //通过下沉让堆重新有序
        sink(1);
        return max;
    }

    private void sink(int k){
        while (2*k<=N) {
            int max;
            if(2*k+1 <= N){
                if(less(2*k,2*k+1)){
                    max = 2*k+1;
                }else{
                    max = 2*k;
                }
            }else{
                max = 2*k;
            }
            if(!less(k, max)) break;
            exch(k, max);
            k = max;
        }
    }
}