package com.example.webServer.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Created by Elliot Ji on 2019/4/10.
 *
 * 重点理解下: Buffer的应用固定逻辑
 *
 * 写操作顺序
 * 1.clear();
 * 2.put();  -->写操作
 * 3.flip()  -->重置游标
 * 4.SocketChannel.write(buffer) --->将缓存数据发送到网络另一端
 * 5.clear();
 *
 * 读操作顺序
 *  1.clear();
 *  2.SocketChannel.read(buffer)  --->从网络中读取数据;
 *  3.buffer.flip() --->重置游标
 *  4.buffer.get()  -->读取数据
 *  5.buffer.clear()
 *
 */
public class NIOServer implements Runnable {
    //多路复用器,选择器,用于注册通道的;
    private Selector selector;
    //定义两个缓存,分别用于读和写.
    private final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public NIOServer(int port){
        init(port);
    }


    public static void main(String[] args) {
        new Thread(new NIOServer(9999)).start();
    }


    private void init(int port){
        try {
            System.out.println("starting server at port "+port+"...");
            //开启多路复用器
            this.selector = Selector.open();
            //开启服务通道
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            //非阻塞,如果传递参数为true,则为阻塞
            serverChannel.configureBlocking(false);
            //绑定端口
            serverChannel.bind(new InetSocketAddress(port));
            //注册,并标记当前服务通道状态
            /*
            * register(Selector,int)
            * int 状态码
            * OP_ACCEPT:连接成功的标记
            * OP_READ:  可以读取数据的标记
            * OP_WRITE:  可以写入数据的标记
            * OP_CONNECT: 连接建立后的标记
            */
            serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("server started...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                //阻塞方法,当至少一个通道被选中,此方法返回
                //通道是否选择,由注册到多路复用器中的通道标记决定
                this.selector.select();
                //返回选中的通道标记集合,集合中保存的是通道的标记.相当于通道的ID.
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while(keys.hasNext()){
                    SelectionKey key = keys.next();
                    //将本次要处理的通道从集合中删除,下次循环根据新的通道列表再次执行必要的业务逻辑
                    keys.remove();
                    //通道是否有效
                    if(key.isValid()){
                        //阻塞状态
                        try{
                            if(key.isAcceptable()){
                                accept(key);
                            }
                        }catch(CancelledKeyException cke){
                            //出现异常,断开连接
                            key.cancel();
                        }
                        //可读状态
                        try{
                            if(key.isReadable()){
                                read(key);
                            }
                        }catch (CancelledKeyException cke){
                            key.cancel();
                        }
                        //可写状态
                        try{
                            if(key.isWritable()){
                                write(key);
                            }
                        }catch(CancelledKeyException cke){
                            key.cancel();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void accept(SelectionKey key){
        try {
            //此通道为init方法中注册到Selector上的ServerSockerChannel
            ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
            //阻塞方法,当客户端发起请求后返回.此通道和客户端一一对应
            SocketChannel channel = serverChannel.accept();
            channel.configureBlocking(false);
            //设置对应客户端的通道标记,此通道为读取数据使用的.
            channel.register(this.selector,SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private  void read(SelectionKey key){
        try {
            //清空缓存
            this.readBuffer.clear();
            //获取通道
            SocketChannel channel = (SocketChannel) key.channel();
            int readLength = channel.read(readBuffer);
            if(readLength ==-1){
                //关闭通道
                key.channel().close();
                //关闭连接
                key.cancel();
                return;
            }
            /*
            * flip, NIO 中最复杂的操作就是Buffer的控制.
            * Buffer中有一个游标.游标信息在操作后不会归零,如果直接访问Buffer的话,数据有不一致的可能;
            * flip是重置游标的方法. NIO 编程中,flip是常用方法
            * */
            this.readBuffer.flip();
            //字节数组,保存具体数据的,Buffer.remaining()-->是获取Buffer中有效数据长度的方法
            byte[] datas = new byte[readBuffer.remaining()];
            //是将Buffer中有效数据保存到字节数组中
            readBuffer.get(datas);
            System.out.println("from "+channel.getRemoteAddress()+" client: "+new String(datas, StandardCharsets.UTF_8));
            //注册通道,标记为写操作.
            channel.register(this.selector,SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                key.channel().close();
                key.cancel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void write(SelectionKey key){
        try {
            this.writeBuffer.clear();
            SocketChannel channel = (SocketChannel) key.channel();
            Scanner reader = new Scanner(System.in);
            System.out.println("put message for send to client");
            String line = reader.nextLine();
            //将控制台输入的数据写入Buffer中,写入的数据是一个字节数组
            writeBuffer.put(line.getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();
            channel.write(writeBuffer);
            channel.register(this.selector,SelectionKey.OP_READ);
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}









































