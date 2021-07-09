package ioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    public static void main(String[] args) throws IOException {
        // fun1();
        // fun2();
        // fun3();
        fun4();
    }


    private static void fun4() throws IOException {
        FileInputStream fileInputStream = 
            new FileInputStream(
                "C:\\Users\\dl3213\\Desktop\\新建文件夹/73500614.gif");
        FileChannel sourcChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("./javaCode/iotest/73500614-copy.gif");
        FileChannel targetChannel = fileOutputStream.getChannel();

        targetChannel.transferFrom(sourcChannel, 0, sourcChannel.size());

        sourcChannel.close();
        targetChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }


    //读写文件
    public static void fun3() throws IOException {
        FileInputStream fileInputStream = 
            new FileInputStream("./javaCode/iotest/a.txt");
        FileChannel inChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("./javaCode/iotest/b.txt");
        FileChannel outChannel = fileOutputStream.getChannel();
        
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        
        while (true) {
            byteBuffer.clear();//!第一次读完后的操作
            int read = inChannel.read(byteBuffer);
            System.out.println("read => " + read);
            if(read == -1) break;
            byteBuffer.flip();
            outChannel.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    //读文件
    public static void fun2() throws IOException {
        File file = new File("./javaCode/iotest/a.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        fileChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
    
    //写文件
    public static void fun1() throws IOException {
        String str = "Hello World";
        FileOutputStream fileOutputStream = new FileOutputStream("./javaCode/iotest/a.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
