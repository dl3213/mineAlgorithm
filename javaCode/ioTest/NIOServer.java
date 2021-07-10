package ioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        
        Selector selector = Selector.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            if(selector.select(1000) == 0) {
                System.out.println("waiting 1s => no connet");
                continue;
            }
            
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            System.out.println("size of selectionkeys => "
                 + selectedKeys.size());

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();


            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if(key.isAcceptable()){

                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("client conneted => " + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ,
                        ByteBuffer.allocate(1024));

                    System.out.println("after connet size of keys => "
                         + selector.keys().size());
                }
                if(key.isReadable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from client => " 
                        + new String(buffer.array()));
                    
                }
                keyIterator.remove();//!
            }
        }

    }
}
