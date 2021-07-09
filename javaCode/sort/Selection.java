package sort;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        Integer[] arr = {5,1,8,2,3,9,4,0,6,7};//Integer是int的包装类，int则是java的一种基本数据类型

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
    
     //排序:最坏O(N^2)
     public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length - 2; i++) {
            int minIndex = i;//当前
            for (int j = i + 1; j < arr.length; j++) {
                if(greater(arr[minIndex], arr[j])) 
                    minIndex = j;
            }
            if(i != minIndex) 
                exch(arr, i, minIndex);
        }
    }

    //比较:返回大
    private static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2)>0;
    } 

    //交换
    private static void exch(Comparable[] arr, int i, int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
