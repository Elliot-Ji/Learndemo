package com.example.socket.Netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义客户端业务处理类
 * 使用SimpleChannelInboundHandler<String>该类是为了编码解码方便
 * Created by Elliot Ji on 2019/11/6.
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override //接受服务器端广播发来的信息
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s.trim());
    }
}
