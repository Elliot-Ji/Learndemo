package com.example.concurrent.second.chapter2;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 关于wait set
 * 1.所有的对象都会有一个wait set ,用来存放调用了wait方法之后进入block状态的线程
 * 2.线程被notify之后,不一定立即执行
 * 3.线程从wait set 中被唤醒之后执行顺序不一定是FIFO
 * 4.线程被唤醒后,必须重新获取锁
 * Created by Elliot Ji on 2019/8/12.
 */
public class WaitSet {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {

        IntStream.rangeClosed(1,10).forEach(i->
             new Thread(String.valueOf(i)){
                 @Override
                 public void run() {
                     synchronized (LOCK){
                         try {
                             Optional.of(Thread.currentThread().getName()+" will come to wait set").ifPresent(System.out::println);
                             LOCK.wait();
                             Optional.of(Thread.currentThread().getName()+" will leave wait set").ifPresent(System.out::println);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }.start()
        );
        Thread.sleep(3000);

        IntStream.rangeClosed(1,10).forEach(i->
             {
                 synchronized (LOCK){
                     LOCK.notify();
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
        }
        );

       /* synchronized (LOCK){
            LOCK.notifyAll();
        }
*/
    }

}
