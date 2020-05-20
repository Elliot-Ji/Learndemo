package com.example.concurrent.third.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**\
 *自定义自旋锁
 * @author Elliot Ji
 * @date 2020/5/15.
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+ "\t come in");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void unMyLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+ "\t lock free");
        atomicReference.compareAndSet(thread,null);
    }


    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unMyLock();
        },"AA").start();

        Thread.sleep(1000);

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unMyLock();
        },"BB").start();

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unMyLock();
        },"CC").start();

    }

}
