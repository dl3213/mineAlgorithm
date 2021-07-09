package sort;

public class testSort {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setUname("s1");
        s1.setAge(18);
        Student s2 = new Student();
        s2.setUname("s2");
        s2.setAge(19);

        Comparable smax =  getMax(s1, s2);
        System.out.println(smax);
    }
    
    public static Comparable getMax(Comparable c1, Comparable c2){
        int ret = c1.compareTo(c2);
        if(ret>=0) return c1;
        else return c2;
        // return null;
    }
}
