package ioTest.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


public class Server {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    public Server(){
        try {

            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void listen(){
        try {
            
            while (true) {
                int count = selector.select();
                if(count > 0) {

                    Iterator<SelectionKey> iterator =
                        selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key =  iterator.next();
                        if(key.isAcceptable()){
                            SocketChannel socketChannel = 
                                listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,
                                SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress()
                                 + " online");
                            
                        }
                        if(key.isReadable()){
                            readData(key);
                        }
                        iterator.remove();
                    }
                }else{
                    System.out.println("waiting ........");
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }finally{

        }
    }

    private void readData(SelectionKey key){
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if(count >0 ){
                String msg = new String(buffer.array());
                System.out.println("from client : " + msg);
                //
                send2Others(msg, channel);
            }
        } catch (IOException e) {
            //TODO: handle exception
            try {
                System.out.println(channel.getRemoteAddress()+" offline");
                key.cancel();
                channel.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    private void send2Others(String msg, SocketChannel self) throws IOException{

        System.out.println("Server sending ......");

        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if(targetChannel instanceof SocketChannel && targetChannel != self){
                SocketChannel dest = (SocketChannel) targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(buffer);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Server server = new Server();
        server.listen();
    }
}
