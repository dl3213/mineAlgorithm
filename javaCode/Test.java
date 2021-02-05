package javaCode;


public class Test {

    public static void main(String[] args) {
        // System.out.println(factorial(5));
        double a = 25 / 2;
        System.out.println(a);
    }

    public static long factorial(int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }

}
