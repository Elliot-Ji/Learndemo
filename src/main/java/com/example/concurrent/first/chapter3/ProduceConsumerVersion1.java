package com.example.concurrent.first.chapter3;

/**
 * 线程间的通讯问题
 * Created by Elliot Ji on 2019/7/29.
 */
public class ProduceConsumerVersion1 {

    private int i = 1;

    private final Object LOCK = new Object();

    public void produce(){
        synchronized (LOCK){
            System.out.println("P->"+(i++));
        }
    }

    public void consumer(){
        synchronized (LOCK){
            System.out.println("C->"+i);
        }
    }

    /**
     * 线程之间没有通讯,造成生产者不断在生产数据,而消费者只读了最新的生产的数据
     * @param args
     */
    public static void main(String[] args) {
        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    pc.produce();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    pc.consumer();
                }
            }
        }.start();
    }

}
