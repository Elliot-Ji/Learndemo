package com.example.concurrent.first.chapter3;

import java.util.stream.Stream;

/**
 *多个线程执行生产者和消费者,notify()方法的局限性就产生了,该方法只唤醒处于wait()状态的多个线程中的一个线程(随机的);
 * 故此处要使用notifyAll()方法, if判断改成while()多判断一次
 * Created by Elliot Ji on 2019/7/29.
 */
public class ProduceConsumerVersion4 {

    private int i = 0;
    private final Object LOCK = new Object();
    private volatile boolean isProduced = false;

    public void produce(){
        synchronized (LOCK){
            while(isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            i++;
            System.out.println("P->"+i);
            LOCK.notifyAll();//不释放锁,等代码块执行完,再释放
            isProduced = true;

        }
    }

    public void consumer(){
        synchronized (LOCK){
            while(!isProduced){
                try {
                    LOCK.wait();//释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println("C->"+i);
                LOCK.notifyAll();
                isProduced = false;



        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion4 pc = new ProduceConsumerVersion4();

        Stream.of("P1","P2","P3").forEach(n ->
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    System.out.println(Thread.currentThread().getName());
                    pc.produce();
                }

            }
        }.start()
        );

        Stream.of("C1","C2","C3","C4").forEach(n ->
        new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    pc.consumer();
                }

            }
        }.start()
        );
    }

}
