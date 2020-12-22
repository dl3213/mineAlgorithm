package javaCode.sort;

import java.util.Arrays;

public class Merge {
    //缺点:需要申请额外的数组空间,导致空间复杂度提升,是典型的以空间换时间的操作

    private static Comparable[] assist;

    public static void main(String[] args) {
        Integer[] arr = {5,1,8,2,3,9,4,0,6,7};//Integer是int的包装类，int则是java的一种基本数据类型

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
    
     //排序:时间最坏O(nlogn)<O(N^2)
    public static void sort(Comparable[] arr){
        
        assist = new Comparable[arr.length];
        int lo = 0;
        int hi = arr.length - 1;
        sort(arr,lo,hi);

    }

    public static void sort(Comparable[] arr, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo+(hi-lo)/2;

        sort(arr, lo, mid);
        sort(arr, mid+1, hi);

        merge(arr,lo,mid,hi);
    }

    public static void merge(Comparable[] arr,int lo, int mid, int hi){
        int i = lo;
        int p1 = lo;
        int p2 = mid+1;

        while (p1<=mid && p2<=hi) {
            if(less(arr[p1], arr[p2])) assist[i++] = arr[p1++];
            else assist[i++] = arr[p2++];
        }

        while (p1<=mid) {
            assist[i++] = arr[p1++];
        }
        while (p2<=hi) {
            assist[i++] = arr[p2++];
        }

        for(int index = lo;index <=hi;index ++){
            arr[index] = assist[index]; 
        }
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
