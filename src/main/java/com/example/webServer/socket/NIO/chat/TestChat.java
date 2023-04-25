package com.example.webServer.socket.NIO.chat;

import java.util.Scanner;

/**
 * 启动聊天程序客户端
 * Created by Elliot Ji on 2019/11/5.
 */
public class TestChat {
    public static void main(String[] args) throws Exception {
        ChatClient client = new ChatClient();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        client.receiveMsg();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            client.sendMsg(s);
        }
    }

}
