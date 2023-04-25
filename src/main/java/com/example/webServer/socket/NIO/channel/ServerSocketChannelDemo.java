package com.example.webServer.socket.NIO.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: Elliot Ji
 * @createDate: 2021-11-09
 **/
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws Exception {
        int port = 8888;
        ByteBuffer buffer = ByteBuffer.wrap("xiao didi".getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //绑定
        ssc.socket().bind(new InetSocketAddress(port));
        //设置非阻塞模式
        ssc.configureBlocking(false);
        //监听新连接进入
        while (true) {
            System.out.println(" waiting for connections");
            SocketChannel accept = ssc.accept();//如果是阻塞模式,会一直阻塞在这里,直到新连接进入才会往下执行
            if (accept == null) { //没有新连接进入
                System.out.println("null");
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from " + accept.socket().getRemoteSocketAddress());
                buffer.rewind();//指针置为0
                accept.write(buffer);
                accept.close();
            }
        }
    }
}
