package com.example.socket.NIO.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 两个通道之间的数据传输
 * @author: Elliot Ji
 * @createDate: 2021-11-09
 **/
public class FileChannelDemo3 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("d:\\002.txt", "rw");
        FileChannel fromChannel = aFile.getChannel();

        RandomAccessFile bFile = new RandomAccessFile("d:\\003.txt", "rw");
        FileChannel toChannel = bFile.getChannel();

        long position = 0;
        long size = fromChannel.size();
        toChannel.transferFrom(fromChannel,position,size);

        aFile.close();
        bFile.close();
        System.out.println("game over");
    }
}
