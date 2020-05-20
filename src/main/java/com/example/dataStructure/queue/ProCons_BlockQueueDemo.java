package com.example.dataStructure.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程下:
 *     生产者消费者模式  为true时,实现生产一个,消费一个, 为false时,取消生产和消费
 * @author Elliot Ji
 * @date 2020/5/19.
 */
public class ProCons_BlockQueueDemo {

    public static void main(String[] args) throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        ShareData shareData = new ShareData(blockingQueue);

        new Thread(()->{
            try {
                shareData.myPro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            try {
                shareData.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        Thread.sleep(5000);
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5秒时间到,main线程叫停");
        shareData.stop();
    }

}

class ShareData{
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public ShareData(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myPro() throws InterruptedException {
        String value = "";
        boolean retValue;
        while(FLAG){
            value = String.valueOf(atomicInteger.incrementAndGet());
            retValue = blockingQueue.offer(value,2l,TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+ "\t 插入队列"+value+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+ "\t 插入队列"+value+"失败");
            }
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName()+"\t " + "接到消息,生产停止");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while(FLAG){
            result = blockingQueue.poll(2l, TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没有取到,消费退出");
                System.out.println();
                System.out.println();
               return;
            }
            System.out.println(Thread.currentThread().getName() + "\t "+ "消费队列"+ result+ "成功");
        }
    }

    public void stop() throws Exception{
        this.FLAG = false;
    }

}
