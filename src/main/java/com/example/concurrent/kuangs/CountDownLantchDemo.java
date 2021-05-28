package com.example.concurrent.kuangs;

import java.util.concurrent.CountDownLatch;

/**
 * JUC中的三个辅助类的使用  CountDownLatch : 计数器
 * @author: Elliot Ji
 * @createDate: 2021-05-28
 **/
public class CountDownLantchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " : Get Out !");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("Close Door");
    }

}
