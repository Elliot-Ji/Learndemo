package com.example.webServer.socket.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 网络服务器端
 * Created by Elliot Ji on 2019/11/4.
 */
public class NioServer {

    public static void main(String[] args)throws Exception {
        //1.得到有个ServerSocketChannel 对象 --->老大
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.得到Selector对象  --->间谍
        Selector selector = Selector.open();
        //3.绑定一个端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //4.设置阻塞方式
        serverSocketChannel.configureBlocking(false);
        //5.把selector 对象注册到serverSocketChannel对象中
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        //6.干活
        while(true){
            //6.1监控客户端,有没有客户端链接我
            if(selector.select(2000)==0){
                System.out.println("Server:没有客户端搭理我,我干别的事去了.");
                continue;
            }
            //6.2得到selectionKey,判断通道里的事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while(keyIterator.hasNext()){
                 SelectionKey key  = keyIterator.next();
                 if(key.isAcceptable()){//客户端连接请求事件
                     System.out.println("OP_ACCEPT");
                     SocketChannel socketChannel = serverSocketChannel.accept();
                     socketChannel.configureBlocking(false);
                     socketChannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));//连接成功后要监听读取事件
                 }
                 if(key.isReadable()){//读取客户端数据事件
                     SocketChannel channel = (SocketChannel)key.channel();//获取监听的通道
                     ByteBuffer buffer  =(ByteBuffer)key.attachment();//获取数据缓冲区
                     channel.read(buffer);//通道读取数据放入缓冲区中
                     System.out.println("客户端发来的数据: "+ new String(buffer.array()));
                 }
                 //6.3 手动从集合中移除当前key,防止重复处理
                keyIterator.remove();
            }

        }
    }

}
