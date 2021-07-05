package javaCode.hashmap;

import java.util.HashMap;

public class HashMapTest {
    
    public static void main(String[] args) {
        // HD, Figure 3-1
        // i |= (i >>  1);
        // i |= (i >>  2);
        // i |= (i >>  4);
        // i |= (i >>  8);
        // i |= (i >> 16);
        // return i - (i >>> 1);
        //左移一位=原×2
        System.out.println(2>>1);//(10>>1);//(1<<4);//16//("3213".hashCode());//1.hascode()2.hash%.length
        System.out.println(Integer.highestOneBit(15));//<=2的次方

        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, "a");
        hashMap.put(2, "b");
        System.out.println(hashMap.put(2, "b"));
        System.out.println(hashMap.put(2, "c")); 

    }

    
}