package com.example.socket.NIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO操作文件IO
 * Created by Elliot Ji on 2019/11/4.
 */
public class TestFileNIO{

    @Test //往本地文件中写数据
    public void test1()throws Exception{
        //1.创建输出流
        FileOutputStream fos = new FileOutputStream("basic.txt");
        //2.从流中得到通道,通道是建立在流的基础之上的!
        FileChannel channel = fos.getChannel();
        //3.提供一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4.往缓冲区中存数据
        String str = "hello,my dear";
        buffer.put(str.getBytes());
        //5.翻转缓冲区,缓冲区的指针要重置归零
        buffer.flip();
        //6.把缓冲区写到通道中,通道会将数据写到文件中
        channel.write(buffer);
        //7.关闭
        fos.close();
    }

    @Test //从本地文件中读取数据
    public void test2() throws Exception{
        File file = new File("basic.txt");
        //1.创建输入流
        FileInputStream fis = new FileInputStream(file);
        //2.从流中得到通道
        FileChannel channel = fis.getChannel();
        //3.提供一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        //4.通道从本地文件中读取数据到缓冲区
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        //5.关闭
        fis.close();
    }

    @Test //复制文件
    public void test3() throws Exception{
        //1.创建两个流
        FileInputStream fis = new FileInputStream("basic.txt");
        FileOutputStream fos = new FileOutputStream("d:/myfile/basic.txt");

        //2.创建两个通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        //3.复制
        fosChannel.transferFrom(fosChannel,0,fisChannel.size());

        //4.关闭流
        fos.close();
        fis.close();
    }
}
