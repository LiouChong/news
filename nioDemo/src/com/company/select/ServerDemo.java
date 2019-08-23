package com.company.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/8/21 10:33
 */
public class ServerDemo {

    private ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocateDirect(1024);
    private Selector selector;

    public ServerDemo() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8080));
        System.out.println("listening on port 8080");

        this.selector = Selector.open();
        serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
    }

    private void start() throws IOException {
        while (true) {
            this.selector.select();
            // 获取所有select注册内的通道
            Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
            // 获取可以遍历通道的迭代器
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 移除本次处理了的事件，不然下次别的端口再次发送什么信息，会导致再处理该消息。
                iterator.remove();

                // 新连接
                if (selectionKey.isAcceptable()) {
                    System.out.println("isAcceptable");
                    ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();

                    // 新注册channel
                    SocketChannel socketChannel = server.accept();
                    if (socketChannel == null) {
                        continue;
                    }

                    socketChannel.configureBlocking(false);
                    // 注册读事件（服务端一般不注册， 可写事件）
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                    buffer.put("hi new channel".getBytes());
                    buffer.flip();
                    int writeBytes = socketChannel.write(buffer);
                }

                // 服务端关心的可读，意味着有数据从client传来了数量
                if (selectionKey.isReadable()) {
                    System.out.println("isReadable");
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

                    readBuffer.clear();
                    socketChannel.read(readBuffer);
                    readBuffer.flip();

                    String receiveData = Charset.forName("UTF-8").decode(readBuffer).toString();
                    System.out.println("receiveData:" + receiveData);

                    // 这里将受到的数据发回给客户端
                    writeBuffer.clear();
                    writeBuffer.put(receiveData.getBytes());
                    writeBuffer.flip();
                    while (writeBuffer.hasRemaining()) {
                        // 防止写缓冲区满，需要检测是否完全写入
                        System.out.println("写入数据：" + socketChannel.write(writeBuffer));
                    }
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {
        new ServerDemo().start();
    }
}
