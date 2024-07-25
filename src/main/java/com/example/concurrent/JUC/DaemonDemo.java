package com.example.concurrent.JUC;

import java.util.concurrent.TimeUnit;

/**
 * @author Elliot Ji
 * @date 2024/05/30
 */
public class DaemonDemo {
    //判断线程是用户线程还是守护线程
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " 开始运行，"
                    + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            while (true) {

            }
        },"t1");
        t1.setDaemon(true);//设置当前线程为守护线程
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " -----end 主线程");

    }

}
