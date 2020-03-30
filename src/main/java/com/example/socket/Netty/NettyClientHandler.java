package com.example.socket.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 客户端业务 处理类
 * Created by Elliot Ji on 2019/11/5.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override//通道就绪事件
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client: "+ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("老板,还钱吧",CharsetUtil.UTF_8));//向服务器发送信息
    }

    @Override//读取数据事件
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("服务器端发来的信息: "+buf.toString(CharsetUtil.UTF_8));
    }
}
