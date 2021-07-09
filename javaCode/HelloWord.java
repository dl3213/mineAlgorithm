

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HelloWord {

    public static void main(String[] args) throws Exception {

        int int1 = 12;
        int int2 = 12;
        
        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer3 = new Integer(127);
        
        Integer a1 = 127; //或者写成Integer a1 = Integer.valueOf(127);
        Integer a2 = 127;//或者写成Integer a2 = Integer.valueOf(127);
        
        Integer a = 128;
        Integer b = 128;
            
        System.out.println("int1 == int2 -> " + (int1 == int2));                    
        System.out.println("int1 == integer1 -> " + (int1 == integer1));            
        System.out.println("integer1 == integer2 -> " + (integer1 == integer2));    
        System.out.println("integer3 == a1 -> " + (integer3 == a1));                
        System.out.println("a1 == a2 -> " + (a1 == a2));                            
        System.out.println("a == b -> " + (a == b));
        // 1、int1 == int2 为true，这个我就讲了，这个都知道
        //   2、int1 == integer1，Integer是int的封装类，
        // 当Integer与int进行==比较时，Integer就会拆箱成一个int类型，
        // 所以还是相当于两个int类型进行比较，这里的Integer,不管是直接赋值，
        // 还是new创建的对象，只要跟int比较就会拆箱为int类型，所以就是相等的。
        //   3、integer1 == integer2 -> false，这是两个都是对象类型，
        // 而且不会进行拆箱比较，所以不等
        //   4、integer3 == a1 -> false , integer3是一个对象类型，
        // 而a1是一个常量它们存放内存的位置不一样，所以也不等，
        // 具体存在内存的位置看以看文章：点击打开链接
        //   5、6   看起来是一模一样的为什么一个是true，
        // 一个是false，这是因为Integer作为常量时，对于-128到127之间的数，
        // 会进行缓存，也就是说int a1 = 127时,在范围之内，
        // 这个时候就存放在缓存中，当再创建a2时，java发现缓存中存在127这个数了，
        // 就直接取出来赋值给a2，所以a1 == a2的。
        // 当超过范围就是new Integer()来new一个对象了，
        // 所以a、b都是new Integer(128)出来的变量，所以它们不等。 


        // int a =100,b=50,c=a---b,d=a---b;
        // List<Integer> list = Arrays.asList(5,3,1);
        // list.add(6);
        // list.add(0,4);
        // list.remove(1);
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(6);
        // list.add(0,4);
        // list.remove(1);

        System.out.println("Hello World测试");
        // ArrayList al = new ArrayList<>();
        // test1();
        // ConcurrentHashMap

        // errFun();
        //testTrycatch();

        //System.out.println(Math.round(-1.5));
        // int key = 1;//没有break时会4，3
        // switch (key) {
        //     case 1:System.out.println(1);//break;
        //     case 2:System.out.println(2);//break;
        //     case 4:System.out.println(4);//break;//！
        //     case 3:System.out.println(3);//break;//！
        // }
        // char key2 = 'a';
        //总结：break;语句"不是必须的"。
        //如果不写，如果一旦case相应的值成功，但内部没有break语句，
        //那么将会无条件(不再进行case匹配)的继续向下执行其它case中的语句，
        //直到遇到break;语句或者到达switch语句结束。
        // switch (key2) {
        //     case 'a':System.out.println('a');//break;
        //     case 'b':System.out.println('b');//break;
        //     case 'd':System.out.println('d');//break;//！
        //     case 'c':System.out.println('c');//break;//！
        // }

        {
            //static int i =1;
            //i++;
            //System.out.println(i);
            //原因是用了public，private，static等修饰词去修饰方法内部变量，
            // 然而在java类的方法里声明变量时，
            // 只能用final修饰(only final is permitted)（或者不加修饰）。
            // 除此之外不能用其他的修饰符修饰，包括static也会报同样的错误。
            // public，private等是声明作用域的。
            // 方法内部定义的变量（只能在方法内部使用），
            // 在里面声明作用域无意义，也禁止声明。
 
        }
        
        
    }

    public static void testTrycatch(){
        int i = 1;
        // if(i == 1) return ;
        System.out.println("trying.....");
        
        try {
            System.out.println("now trying.....");
            i = i/0;
            return ;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("now catch.....");
        }finally{
            System.out.println("now finally.....");
        }
    }


    public static void errFun() throws Exception {
        HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    int finalI1 = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(String.valueOf(finalI1), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

    public static void test1() {
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        // Java 8方式：
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // Java 8之后：
        List<String> features1 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features1.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features1.forEach(System.out::println);
    }

}

class Java8Tester {
    public static void main(String args[]) {
        Java8Tester tester = new Java8Tester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
