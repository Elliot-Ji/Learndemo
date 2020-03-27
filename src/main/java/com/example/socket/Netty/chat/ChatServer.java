package com.example.socket.Netty.chat;

import com.example.socket.Netty.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 聊天程序服务器端
 * Created by Elliot Ji on 2019/11/6.
 */
public class ChatServer {

    private int port;//服务器端口号

    public ChatServer(int port) {
        this.port = port;
    }

    public void run()throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            ChannelPipeline pipeline = sc.pipeline();
                            //往pipeline链中添加解码器
                            pipeline.addLast("decoder",new StringDecoder());
                            //往pipeline链中添加编码器
                            pipeline.addLast("encoder",new StringEncoder());
                            //往pipeline链中添加自定义handler(业务处理类)
                            pipeline.addLast(new ChatServerHandler());
                        }
                    });
            System.out.println("Netty Chat Server 启动.......");
            ChannelFuture cf = b.bind(port).sync();
            cf.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            System.out.println("Netty Chat Server 关闭........");
        }
    }

    public static void main(String[] args) throws Exception {
        new ChatServer(9999).run();
    }
}
