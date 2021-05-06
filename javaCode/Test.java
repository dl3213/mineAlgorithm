package javaCode;


public class Test {

    public static void main(String[] args) {
        // System.out.println(factorial(5));
        //double a ;//= 25 / 2;
        Object object = new Object();
        System.out.println(object);
    }

    public static long factorial(int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }

}
