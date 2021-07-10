package ioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class BufferTest {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        serverSocketChannel.socket().bind(inetSocketAddress);
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel socketChannel = serverSocketChannel.accept();
        int msgLength = 8;
        while (true) {
            int byteRead = 0;
            while (byteRead < msgLength) {
                long l = socketChannel.read(byteBuffers);
                byteRead += l;
                System.out.println("byteRead=" + byteRead);
                Arrays.asList(byteBuffers).stream()
                        .map(buffer -> "postion=" + buffer.position() + " limit=" + buffer.limit())
                        .forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());
            long byteWrite = 0;
            while (byteWrite < msgLength) {
                long l = socketChannel.write(byteBuffers);
                byteWrite += l;

            }
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());
            System.out.println("byteRead=" + byteRead + " byteWrite=" + byteWrite + " msgLen=" + msgLength);
        }

        // RandomAccessFile randomAccessFile =
        // new RandomAccessFile("a.txt","rw");
        // //MappedByteBuffer:让文件直接在内存修改（堆外内存），操作系统不需要拷贝一次
        // FileChannel fileChannel = randomAccessFile.getChannel();
        // MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0,
        // 5);//5的大小
        // buffer.put(0,(byte)'Z');
        // buffer.put(3,(byte)'1');
        // randomAccessFile.close();
        // System.out.println("done");

        // ByteBuffer buffer = ByteBuffer.allocate(64);
        // for (int i = 0; i < 64; i++) {
        // buffer.put((byte)i);

        // }
        // buffer.flip();
        // ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        // System.out.println(readOnlyBuffer.getClass());//class
        // java.nio.HeapByteBufferR
        // while (readOnlyBuffer.hasRemaining()) {
        // System.out.println(readOnlyBuffer.get());
        // }
        // readOnlyBuffer.put((byte)100);//java.nio.ReadOnlyBufferException

        // ByteBuffer buffer = ByteBuffer.allocate(64);
        // buffer.putInt(123);
        // buffer.putLong(12);
        // buffer.putChar('测');
        // buffer.putShort((short)123);
        // buffer.flip();
        // System.out.println(buffer.getInt());
        // System.out.println(buffer.getLong());
        // System.out.println(buffer.getChar());
        // // System.out.println(buffer.getShort());
        // System.out.println(buffer.getLong());//java.nio.BufferUnderflowException

        // IntBuffer buffer = IntBuffer.allocate(7);

        // for (int i = 0; i < buffer.capacity(); i++) {
        // buffer.put(i);
        // }
        // buffer.flip();//
        // while (buffer.hasRemaining()) {
        // System.out.println(buffer.get());
        // }

    }
}
