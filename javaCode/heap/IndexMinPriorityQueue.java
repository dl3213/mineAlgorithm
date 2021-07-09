package heap;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"F");

        queue.changeItem(2, "B");
        
        while (!queue.isEmpty()) {
            int index = queue.delMin();
            System.out.print(index+" ");
        }
    }

    private T[] items;
    private int[] pq;
    private int[] qp;
    private int N;

    public IndexMinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;

        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }
    public int size(){
        return N; 
    }
    public boolean  isEmpty(){
        return N==0;
    }
    private boolean less(int i, int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    private void exch(int i, int j){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
    public boolean contains(int k){
        return qp[k] != -1;
    }
    public int minIndex(){
        return pq[1];
    }

    public void insert(int i,T t){
        if(contains(i)) return;

        N++;
        items[i] = t;
        pq[N] = i;
        qp[i] = N;
        swim(N);
    }

    public int delMin(){
        int minIndex = pq[1];
        exch(1, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[minIndex] = null;
        N --;
        sink(1);
        return minIndex;
    }

    public void delete(int i){
        int k = qp[i];
        exch(k, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[k] = null;
        N --;
        sink(k);
        swim(k);
    }

    public void changeItem(int i, T t){
        items[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }

    //上浮算法，使得索引k的值处于正确位置
    private void swim(int k){
        //循环比较当前结点的值和父结点的值
        while (k>1) {
            if(less(k,k/2)) exch(k, k/2);
            k = k/2;
        }
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