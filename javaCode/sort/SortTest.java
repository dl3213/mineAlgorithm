package javaCode.sort;

import java.io.*;
import java.util.ArrayList;


//排序的稳定性:相等的元素排行后位置不变=>稳定

public class SortTest {

    public static void main(final String[] args) throws Exception {

        String fileName = "data2text.txt";
        makeDate(fileName);

        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader reader =  new BufferedReader(new InputStreamReader(
            SortTest.class.getClassLoader().getResourceAsStream(fileName)));

            String line = null;
            while ((line = reader.readLine()) != null) {
                int i = Integer.parseInt(line);
                list.add(i);
            }

            reader.close();

            Integer[] arr = new Integer[list.size()];
            list.toArray(arr);

            shellTest(arr);
            insertTest(arr);
            test(arr);

    }

    public static void test(Integer arr[]){

        long start = System.currentTimeMillis();

        Quick.sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("test => " + (end - start) + "ms");
    }

    public static void shellTest(Integer arr[]){

        long start = System.currentTimeMillis();

        Shell.sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("shell => " + (end - start) + "ms");
    }

    public static void insertTest(Integer arr[]){
        long start = System.currentTimeMillis();

        Insertion.sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("insertion => " + (end - start) + "ms");
    }

    public static void makeDate(String fileName){
        try {
            // String fileName = "data4test.txt";
            File dirFile = new File(fileName);

            if (!dirFile.exists()) {// 判断目录是否存在，不存在创建
                // dirFile.mkdir();
                dirFile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                for (int i = 100000; i >= 0; i--) {
                    if(i != 0)
                        writer.write(i + "\r\n");// 写入文件
                    // else writer.write(0);
                }
                writer.flush();// 清空缓冲区数据
                writer.close();// 关闭读写流
                System.out.println("写入成功");
            }

        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
