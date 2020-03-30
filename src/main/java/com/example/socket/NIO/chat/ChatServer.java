package com.example.socket.NIO.chat;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * 聊天程序服务端
 * Created by Elliot Ji on 2019/11/5.
 */
public class ChatServer {
    private ServerSocketChannel listenerChannel;//监听通道,老大
    private Selector selector;//选择器对象,间谍
    private static final int PORT = 9999;//服务器端口号

    public ChatServer(){
        try{
            listenerChannel = ServerSocketChannel.open();
            selector = Selector.open();
            listenerChannel.bind(new InetSocketAddress(PORT));
            listenerChannel.configureBlocking(false);
            listenerChannel.register(selector,SelectionKey.OP_ACCEPT);
            printInfo("Chat Server is ready...");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //6.开始干活
    public void start()throws Exception{
        try{
            while(true){//不停监控
                if(selector.select(2000)==0){
                    System.out.println("Server:没有客户端搭理我,我干别的事去了.");
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){ //客户端连接请求事件
                        SocketChannel sc = listenerChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);
                        System.out.println(sc.getRemoteAddress().toString().substring(1)+" 上线了...");
                    }
                    if(key.isReadable()){//读取客户端数据事件
                        readMsg(key);
                    }

                    iterator.remove();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 读取客户端发来的消息并广播出去
     * @param key
     */
    public void readMsg(SelectionKey key)throws Exception {
        SocketChannel channel =(SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if(read>0){
            String msg = new String(buffer.array());
            printInfo(msg);
            //发广播
            broadCast(channel,msg);
        }
    }

    /**
     * 给所有的客户端发广播
     * @param except
     * @param msg
     */
    public void broadCast(SocketChannel except,String msg) throws Exception {
        System.out.println("服务器发送了广播!");
        for(SelectionKey key :selector.keys()){//通过监听器获取所有已经连接了的通道
            Channel targetChannel = key.channel();
            if(targetChannel instanceof SocketChannel && targetChannel!=except){
                SocketChannel destChannel = (SocketChannel)targetChannel;
                ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                destChannel.write(wrap);
            }
        }
    }

    private void printInfo(String info){
        SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[ "+sft.format(new Date())+" ] -> "+ info);
    }

    public static void main(String[] args) throws Exception{
        new ChatServer().start();
    }
}
