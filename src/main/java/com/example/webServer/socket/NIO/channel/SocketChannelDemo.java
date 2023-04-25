package com.example.webServer.socket.NIO.channel;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author: Elliot Ji
 * @createDate: 2021-11-09
 **/
public class SocketChannelDemo {
    public static void main(String[] args) throws Exception {
        //创建SocketChannel
        SocketChannel open = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));

        //设置阻塞模式和非阻塞模式

    }
}
