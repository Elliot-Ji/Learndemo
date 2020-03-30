package com.example.socket.Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty入门案例
 * Created by Elliot Ji on 2019/11/5.
 */
public class NettyServer {
    public static void main(String[] args) throws Exception{
        //1.创建一个线程组: 接受客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2.创建一个线程组: 处理网络操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //3.创建服务器端启动助手来配置参数
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup,workerGroup) //4.设置两个线程组
                .channel(NioServerSocketChannel.class) //5.使用NioServerSocketChannel作为服务器端通道的实现
                .option(ChannelOption.SO_BACKLOG,128) //6.设置线程队列中等待连接的个数
                .childOption(ChannelOption.SO_KEEPALIVE,true) //7.保持活动连接状态
                .childHandler(new ChannelInitializer<SocketChannel>() { //8.创建一个通道初始化对象
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception { //9.往Pipeline链中添加自定义的handler对象
                        sc.pipeline().addLast(new NettyServerHandler());
                    }
                });
        System.out.println("--------Server is ready-----------");
        ChannelFuture cf = b.bind(9999).sync();//10.绑定端口  非阻塞
        System.out.println("--------Server is starting--------");

        //11.关闭通道,关闭线程组
        cf.channel().closeFuture().sync(); //异步
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
