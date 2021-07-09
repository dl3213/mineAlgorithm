package sort;

import java.util.Arrays;

public class Quick{

    public static void main(String[] args) {
        Integer[] arr = {5,1,8,2,3,9,4,0,6,7,99,77,12,34};//Integer是int的包装类，int则是java的一种基本数据类型

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
    
     //排序:时间最优O(nlogn)最坏O(N^2) 平均:O(nlogn)
    public static void sort(Comparable[] arr){
        
        int lo = 0;
        int hi = arr.length-1;
        sort(arr, lo, hi);

    }

    public static void sort(Comparable[] arr, int lo, int hi){

        if(hi<=lo) return;

        int partition = partition(arr, lo, hi);//位置变化后的索引

        sort(arr, lo,partition-1);
        sort(arr, partition+1, hi);


    }

    public static int partition(Comparable[] arr,int lo, int hi){

        Comparable key = arr[lo];
        int left = lo;
        int right = (hi+1);

        while (true) {
            while (less(key, arr[--right])) {
                if(right == lo) break;
            }

            while (less(arr[++left], key)) {
                if(left == hi) break;
            }

            if(left>=right) break;
            else exch(arr, left, right);
        }

        exch(arr, lo, right);//交换分界值
        return right;//left会有越界风险
    }

    //比较:返回大
    private static boolean less(Comparable c1, Comparable c2){
        return c1.compareTo(c2)<0;
    } 

    //交换
    private static void exch(Comparable[] arr, int i, int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
