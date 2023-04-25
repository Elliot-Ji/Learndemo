package com.example.webServer.socket.NIO.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过filechannel 读取数据到buffer中
 * @author: Elliot Ji
 * @createDate: 2021-11-09
 **/
public class FileChannelDemo1 {
    public static void main(String[] args) throws Exception {
        //创建fileChannel
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:\\my.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取数据到buffer中
        int read = channel.read(buffer);
        while (read != -1) {
            System.out.println("读取了" + read);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        randomAccessFile.close();
        System.out.println("结束了!");
    }
}
