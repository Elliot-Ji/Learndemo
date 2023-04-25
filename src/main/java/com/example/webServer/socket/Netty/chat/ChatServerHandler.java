package com.example.webServer.socket.Netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义服务器端业务处理类
 * Created by Elliot Ji on 2019/11/6.
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {
    public List<Channel> channels = new ArrayList<>();//存放已经连接成功,通道就绪的通道

    @Override //通道就绪
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();//获取远程客户端连接成功的通道
        channels.add(channel);
        System.out.println("[Server]: "+channel.remoteAddress().toString().substring(1)+" 上线了......");
    }

    @Override //通道未就绪
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.remove(channel);
        System.out.println("[Server]: "+channel.remoteAddress().toString().substring(1)+" 离线了......");
    }

    @Override //读取数据
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel inChannel = ctx.channel();//s 即为客户端发来的消息
        for(Channel channel:channels){
            if(channel!=inChannel){
                channel.writeAndFlush("[ "+inChannel.remoteAddress().toString().substring(1)+"]"+"说: "+s+"\n");
            }
        }
    }

}
