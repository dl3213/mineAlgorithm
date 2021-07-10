package ioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    
    public static void main(String[] args) throws Exception {
        
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = 
            new InetSocketAddress("127.0.0.1", 6666);

        if(!socketChannel.connect(inetSocketAddress)){
            System.out.println("conneting");
            while (!socketChannel.finishConnect()) {
                System.out.println("now?????");
            }
        }

        String str = "hello world";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        // socketChannel.configureBlocking(false);
        socketChannel.write(buffer);
        System.in.read();
    }
}
