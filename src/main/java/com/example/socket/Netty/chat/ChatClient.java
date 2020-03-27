package com.example.socket.Netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * 聊天程序客户端
 * Created by Elliot Ji on 2019/11/6.
 */
public class ChatClient {
    private final String host;//服务器ip地址
    private final int port;//服务器端口号

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run(){
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            ChannelPipeline pipeline = sc.pipeline();
                            //往pipeline链中添加解码器
                            pipeline.addLast("decoder",new StringDecoder());
                            //往pipeline链中添加编码器
                            pipeline.addLast("encoder",new StringEncoder());
                            //往pipeline链中添加自定义handler(业务处理类)
                            pipeline.addLast(new ChatClientHandler());
                        }
                    });
            ChannelFuture cf = bootstrap.connect(host,port).sync();//connect方法是异步的,sync方法是同步的
            Channel channel = cf.channel();
            System.out.println("-------"+channel.localAddress().toString().substring(1)+"--------");

            //开始聊天,发送信息
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                String s = scanner.nextLine();
                channel.writeAndFlush(s+"\r\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args)throws Exception {
        new ChatClient("127.0.0.1",9999).run();
    }
}
