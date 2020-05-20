package com.example.dataStructure.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 同步队列
 * @author Elliot Ji
 * @date 2020/5/19.
 */
public class SychronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> b = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t " + "put 1");
                b.put("1");

                System.out.println(Thread.currentThread().getName()+"\t " + "put 2");
                b.put("2");

                System.out.println(Thread.currentThread().getName()+"\t " + "put 3");
                b.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
               Thread.sleep(5000);
               System.out.println(Thread.currentThread().getName()+"\t " +b.take());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"\t " +b.take());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"\t " +b.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
    }

}
