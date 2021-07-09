package ioTest;

//bio:同步阻塞，一个连接一个线程，多路复用，轮询,适用：连接数目小且固定,流方式处理数据，基于字节流和字符流操作
//nio:同步非阻塞，一个线程处理多个连接，适用：连接数目多且连接短，轻操作，块方式处理，效率块>流，基于通道和缓冲操作
// aio：异步非阻塞，异步通道，proactor，适用：连接数目多且连接长，重操作
public class Main {
 
    public static void main(String[] args) {
        System.out.println("io test");
    }
}
