package com.example.mianshi;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 线程： ThreadLocal的使用
 * 1.基本使用
 * 2.和线程池的搭配使用产生的问题？
 *    阿里手册： 1.必须回收自定义的ThreadLocal变量，尤其在线程池场景下。在finally块中回收。
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
                        su7.salePersonal();
                    }
                    System.out.println(Thread.currentThread().getName() +"\t" + "号销售卖出： " + su7.salePersonal.get());
                }finally {
                    countDownLatch.countDown();
                    su7.salePersonal.remove();
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

    //加锁
    public synchronized void saleTotal() {
        saleTotal++;
    }

    //ThreadLocal初始化值
    ThreadLocal<Integer> salePersonal = ThreadLocal.withInitial(() -> 0);
    public void salePersonal() {
        salePersonal.set(1 + salePersonal.get());
    }
}























