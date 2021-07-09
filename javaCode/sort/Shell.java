package sort;

import java.util.Arrays;

public class Shell {

    public static void main(String[] args) {
        Integer[] arr = {5,1,8,2,3,9,4,0,6,7};//Integer是int的包装类，int则是java的一种基本数据类型

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
    
     //排序:最坏O(N^2)
     public static void sort(Comparable[] arr){

        int h = 1;//初始增长量
        while (h < arr.length/2) {
            h = 2*h +1;

        }

        while (h>=1) {
            
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if(greater(arr[j-h], arr[j]))
                        exch(arr, j-h, j);
                    else break;
                }
            }

            h /= 2;
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
