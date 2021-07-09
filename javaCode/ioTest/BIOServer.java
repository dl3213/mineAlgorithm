package ioTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    
    public static void main(String[] args) throws IOException {
        
        ExecutorService threadPool =  Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(6666);
        System.out.println("servering ......");
        while (true) {
            System.out.println("client:id="+Thread.currentThread().getId()
                +" name=" + Thread.currentThread().getName());
            System.out.println("waiting .......");
            final Socket socket = server.accept();
            System.out.println("new client .......");
            threadPool.execute(new Runnable(){
                public void run(){
                    handler(socket);
                }
            }); 
        }
    }

    public static void handler(Socket socket){
        
        try {
            System.out.println("client:id="+Thread.currentThread().getId()
                +" name=" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                System.out.println("client:id="+Thread.currentThread().getId()
                +" name=" + Thread.currentThread().getName());
                System.out.println("reading ......");
                int read = inputStream.read(bytes);
                if(read!=-1){
                    System.out.println("from client => " + new String(bytes, 0, read));
                }else{
                    break;
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("closing conneting....");
            try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
