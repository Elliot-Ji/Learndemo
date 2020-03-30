package com.example.socket.NIO.chat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 聊天程序客户端
 * Created by Elliot Ji on 2019/11/5.
 */
public class ChatClient {
    private final static String HOST ="127.0.0.1";//服务器地址
    private static final int PORT = 9999;//服务器端口
    private SocketChannel socketChannel;//网络通道
    private String userName;//聊天用户名

    public ChatClient() throws IOException{
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress(HOST,PORT);
        //4.连接服务器端,如果连不上要一直请求连接
        if(!socketChannel.connect(address)){
            while(!socketChannel.finishConnect()){ //nio 作为非阻塞式的优势
                System.out.println("Client:连接服务器端的同时,还可以做别的事.");
            }
        }
        //5.得到客户端ip地址作为聊天用户名
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println("------------Client( "+userName+" ) is ready------------------" );
    }

    /**
     * 向服务端发送数据
     * @param msg
     */
     public void sendMsg(String msg)throws Exception{
        if(msg.equalsIgnoreCase("bye")){
            socketChannel.close();
            return;
        }
        msg = userName+" 说: "+msg;
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        socketChannel.write(buffer);
     }

    /**
     * 从服务端接受数据
     */
    public void receiveMsg()throws Exception{
       ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(buffer);
        if(read>0){
           String msg = new String(buffer.array());
            System.out.println(msg.trim());
        }
    }


}
