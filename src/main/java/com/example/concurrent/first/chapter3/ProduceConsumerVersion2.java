package com.example.concurrent.first.chapter3;

/**
 *单个线程执行生产者和消费者
 * Created by Elliot Ji on 2019/7/29.
 */
public class ProduceConsumerVersion2 {

    private int i = 0;
    private final Object LOCK = new Object();
    private volatile boolean isProduced = false;

    public void produce(){
        synchronized (LOCK){
            if(isProduced){
                try {
                    System.out.println("p: 我睡了");
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                i++;
                System.out.println("P->"+i);
                LOCK.notify();//不释放锁,等代码块执行完,再释放
                isProduced = true;
            }
        }
    }

    public void consumer(){
        synchronized (LOCK){
            if(isProduced){
                System.out.println("C->"+i);
                LOCK.notify();
                isProduced = false;
            }else{
                try {
                    System.out.println("C: 我睡了");
                    LOCK.wait();//释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("P: "+Thread.currentThread().getName());
                    pc.produce();//syn代码块执行完之后,释放锁;或者在该代码块中调用了wait()方法会立即释放锁;
                    //走下面的循环是因为CPU时间片还没走完,继续执行
                   /* for(int a = 0;a<500;a++){
                        System.out.print(a+" ");
                    }*/
                }

            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("C: "+Thread.currentThread().getName());
                    pc.consumer();
                }

            }
        }.start();
    }

}
