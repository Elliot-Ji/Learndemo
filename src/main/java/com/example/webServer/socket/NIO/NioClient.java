package com.example.webServer.socket.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO 客户端
 * Created by Elliot Ji on 2019/11/4.
 */
public class NioClient {

    public static void main(String[] args)throws Exception {
        //1.得到一个网络通道
        SocketChannel channel = SocketChannel.open();

        //2.设置阻塞方式
        channel.configureBlocking(false);

        //3.提供服务器端的ip地址和端口号
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",9999);

        //4.连接服务器端,如果连不上要一直请求连接
        if(!channel.connect(address)){
            while(!channel.finishConnect()){ //nio 作为非阻塞式的优势
                System.out.println("Client:连接服务器端的同时,还可以做别的事.");
            }
        }

        //5.得到一个缓冲区存入数据
        String msg = "hello,server";
        ByteBuffer writeBuf = ByteBuffer.wrap(msg.getBytes());
        channel.write(writeBuf);

        //6.临时措施
        System.in.read();

    }

}
