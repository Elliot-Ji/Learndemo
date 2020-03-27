package com.example.socket.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 入门案例
 * 服务器端的业务处理类
 * Created by Elliot Ji on 2019/11/5.
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override//读取数据事件
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Server: "+ctx);
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("客户端发来的消息: "+ buf.toString(CharsetUtil.UTF_8));
    }

    @Override//数据读取完毕事件
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("俺就是没钱",CharsetUtil.UTF_8));
    }

    @Override//异常发生事件
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
