package com.example.webServer.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by Elliot Ji on 2019/4/10.
 */
public class NIOClient {

    public static void main(String[] args) {
        //远程地址创建
        InetSocketAddress remote = new InetSocketAddress("localhost",9999);
        SocketChannel channel = null;

        //定义缓存
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try {
            //开启通道
            channel = SocketChannel.open();
            //连接远程服务器
            channel.connect(remote);
            Scanner reader = new Scanner(System.in);
            while(true){
                System.out.println("put message for send to server --> ");
                String line = reader.nextLine();
                if(line.equals("exit")){
                   break;
                }
                //将控制台输入的数据写入缓存中
                buffer.put(line.getBytes(StandardCharsets.UTF_8));
                //重置游标
                buffer.flip();
                //将数据发送给服务器
                channel.write(buffer);
                //清空缓存数据.
                buffer.clear();

                //读取服务器返回的数据
                int readerLength = channel.read(buffer);
                if(readerLength == -1){
                    break;
                }
                buffer.flip();
                byte[] datas = new byte[buffer.remaining()];
                //读取数据到字节数组
                buffer.get(datas);
                //打印读取到的数据
                System.out.println("from server: "+ new String(datas, StandardCharsets.UTF_8));
                //清空缓存
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(null != channel){
                    channel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
