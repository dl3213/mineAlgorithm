package sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {

        Integer[] arr = {5,1,8,2,3,9,4,0,6,7};//Integer是int的包装类，int则是java的一种基本数据类型

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    //排序:最坏O(N^2)
    public static void sort(Comparable[] arr){
        for(int i = 0; i < arr.length - 1; i ++){//i = arr.length-1;i>0;i--
            for (int j = 0; j < arr.length - i - 1; j++) {//j=0;j<i;j++
                if(greater(arr[j], arr[j+1])) exch(arr, j, j+1);
            }
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


// 1、Integer是int的包装类，int则是java的一种基本数据类型 
// 2、Integer变量必须实例化后才能使用，而int变量不需要 
// 3、Integer实际是对象的引用，当new一个Integer时，实际上是生成一个指针指向此对象；而int则是直接存储数据值 
// 4、Integer的默认值是null，int的默认值是0
// Integer i = new Integer(100);
// Integer j = new Integer(100);
// System.out.print(i == j); //false
// Integer i = new Integer(100);
// int j = 100；
// System.out.print(i == j); //true
// Integer i = new Integer(100);
// Integer j = 100;
// System.out.print(i == j); //false
// Integer i = 100;
// Integer j = 100;
// System.out.print(i == j); //true
// Integer i = 128;
// Integer j = 128;
// System.out.print(i == j); //false