package javaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maptest {
    
    public static void main(String[] args) {
        System.out.println(3+2+"1");//51
        System.out.println("3"+2+1);//321
        // List<String> list = new ArrayList<>();
        // list.add("a");
        // list.add("b");
        // list.add("a");
        // Set<String> list2 = new HashSet<>();
        // list2.add("a");
        // list2.add("b");
        // list2.add("a");

        // String str = "Admin";
        // System.out.println("adim" == str);

        // int i,sum=0;
        // for(i=0;i<10;i++,sum+=i){}
        // System.out.println(i);



        // String str = "good";
        // char[] ch = {'t','e','s','t'};
        // ch(str, ch);
        // System.out.println(str + "   " + ch.toString());

        // for (int i = 0; i <1;) {
        //     break;
        // }
        // System.out.println("123");
       

        // Integer[] arr = {0,0,4,2,5,0,3,0};
        // List<Integer> aslist = Arrays.asList(arr);
        // List<Integer> list = new ArrayList<>(aslist);
        // int k=0;
        // Integer a=0;
        // while (k<list.size()) {
        //     if(list.get(k).equals(a)) list.remove(k);
        //     k++;
        // }
        // System.out.println(list.toString());
    }

    public static void ch(String str,char[] ch){
        str = "bad";
        ch[0] = 'b';
    }
}
class p{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        p p1 = new p();
        String name = p1.getName();
        if(name.equals("helloworld")) System.out.println("1");//err    
    }
    
}

class a{
    static{
        System.out.println("A");
    }
    public a(){
        System.out.println("a");
    }
}
class b extends a{

    static{
        System.out.println("B");
    }
    public b(){
        System.out.println("b");
    }

    public static void main(String[] args) {
        a ab = new b();
        ab = new b();//ABabab
    }
}

class x{
    y y1 = new y();
    public x(){
        System.out.println("x");
    }
}
class y{

    public y(){
        System.out.println("y");
    }
}
class z extends x{
    y y2 = new y();
    public z(){
        System.out.println("z");
    }
    public static void main(String[] args) {
        new z();
    }
}