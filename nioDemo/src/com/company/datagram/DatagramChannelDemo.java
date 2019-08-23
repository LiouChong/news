package com.company.datagram;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/8/22 13:37
 */
public class DatagramChannelDemo {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadRev()).start();
        Thread.sleep(100);
        new Thread(new ThreadSend()).start();


    }

}

class ThreadRev implements Runnable {

    @Override
    public void run() {
        try {
            DatagramChannel channel = DatagramChannel.open();

            channel.socket().bind(new InetSocketAddress(8082));
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            channel.receive(buf);

            buf.flip();
            CharBuffer charBuffer = Charset.forName("UTF-8").decode(buf);
            System.out.println(charBuffer);

            charBuffer.clear();
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ThreadSend implements Runnable {

    @Override
    public void run() {
        DatagramChannel channel = null;
        try {
            channel = DatagramChannel.open();

            channel.socket().bind(new InetSocketAddress(9999));
            String newData = "New String to write to file";
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());
            buf.flip();
            int byteSent = channel.send(buf, new InetSocketAddress(InetAddress.getLocalHost(), 8082));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("发送完毕");
        }
    }
}
