package com.example.socket.NIO.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel 写数据
 * @author: Elliot Ji
 * @createDate: 2021-11-09
 **/
public class FileChannelDemo2 {
    public static void main(String[] args) throws Exception {
        //打开fileChannel
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:\\002.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        //创建buffer对象
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String newData = "My Dear 馨!";
        buffer.clear();
        //写入内容: 1. 将数据写入到buffer中
        buffer.put(newData.getBytes());
        buffer.flip();

        //fileChannel 写入数据到文件中
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        //关闭channel
        channel.close();

    }
}
