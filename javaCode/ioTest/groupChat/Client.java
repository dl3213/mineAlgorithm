package ioTest.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Client {

    private final String HOST = "127.0.0.1";
    private final int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String uname;
    
    public Client() throws IOException{
        selector =  Selector.open();
        socketChannel = socketChannel.open(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        uname = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(uname + " is ok...");
    }

    public void sendMsg(String msg){
        msg = uname + " say:" + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));

        } catch (IOException e) {
            //TODO: handle exception
        }
    }

    public void readMsg(){
        try {
            int readChannel = selector.select();
            if( readChannel>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        SocketChannel socketChannel =
                            (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(2014);
                        socketChannel.read(buffer);
                        String m =  new String(buffer.array());
                        System.out.println(m.trim());
                    }

                }
                iterator.remove();
            }else{
                // System.out.println("no channel...");
                
            }
        } catch (Exception e) {
            //TODO: handle exception 
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        
        Client client =  new Client();
        new Thread(){
            public void run(){
                while (true) {
                    client.readMsg();
                    try {
                        Thread.currentThread().sleep(3000);

                    } catch (Exception e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            client.sendMsg(s);
        }
    }
}
