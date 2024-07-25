package com.example.mianshi;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 线程： ThreadLoacl的使用
 * @author Elliot Ji
 * @date 2024/07/25
 */
public class ThreadLocalDemoV1 {
    public static void main(String[] args) throws InterruptedException {
        SU7 su7 = new SU7();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 1; i <= 3 ; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= new Random().nextInt(3) + 1; j++) {
                        su7.saleTotal();
                    }
                }finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t" + "销售总数量： " + su7.getSaleTotal());
    }
}

class SU7{
    @Getter
    private int saleTotal;

    public synchronized void saleTotal() {
        saleTotal++;
    }
}
