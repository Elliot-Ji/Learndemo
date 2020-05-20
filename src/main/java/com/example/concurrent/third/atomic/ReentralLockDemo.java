package com.example.concurrent.third.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Elliot Ji
 * @date 2020/5/15.
 */
public class ReentralLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMNS();
        },"t1").start();

        new Thread(()->{
            phone.sendMNS();
        },"t2").start();

        Thread.sleep(1000);
        System.out.println("###############################");


        Thread t3 = new Thread(phone,"t3");
        Thread t4 = new Thread(phone,"t4");
        t3.start();
        t4.start();


    }


}

class Phone implements Runnable {
    public synchronized void sendMNS(){
        System.out.println(Thread.currentThread().getName()+"\t sendMNS");
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\t ########sendEmail");
    }

    @Override
    public void run() {
         get();
    }
    Lock lock = new ReentrantLock();


    public void get(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t get()");
            set();
        }finally {
            lock.unlock();
        }

    }

    public void set(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t set()");
        }finally {
            lock.unlock();
        }

    }
}
