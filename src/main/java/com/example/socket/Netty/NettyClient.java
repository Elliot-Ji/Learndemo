package com.example.socket.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 网络客户端
 * Created by Elliot Ji on 2019/11/5.
 */
public class NettyClient {
    public static void main(String[] args) throws Exception {
        //1.创建一个线程组
        EventLoopGroup group = new NioEventLoopGroup();
        //2.创建客户端的启动助手,完成相关的参数配置
        Bootstrap b = new Bootstrap();
        b.group(group)//3.设置 线程组
         .channel(NioSocketChannel.class) //4.设置客户端通道的实现类
         .handler(new ChannelInitializer<SocketChannel>() { //5.创建一个通道初始化对象
             @Override
             protected void initChannel(SocketChannel socketChannel) throws Exception {
                 socketChannel.pipeline().addLast(new NettyClientHandler()); //6.往pipeline链中添加自定义handler
             }
         });
        System.out.println("----------Client is ready------------");
        //7.启动客户端去连接服务端(异步非阻塞)
        ChannelFuture cf = b.connect("127.0.0.1", 9999).sync();
        //8.关闭连接
        cf.channel().closeFuture().sync();
    }
}
