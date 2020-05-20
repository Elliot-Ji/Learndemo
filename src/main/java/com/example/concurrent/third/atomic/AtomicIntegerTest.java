package com.example.concurrent.third.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 作用:
 * 可见性
 * 有序性
 * 原子性
 * @author Elliot Ji
 * @date 2020/5/13.
 */
public class AtomicIntegerTest {

    private volatile int num = 0;
    private static Set set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger value = new AtomicInteger();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while(x<500){
                    int v = value.getAndIncrement();
                    set.add(v);
                    System.out.println(Thread.currentThread().getName()+":"+v);
                    x++;
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while(x<500){
                    int v = value.getAndIncrement();
                    set.add(v);
                    System.out.println(Thread.currentThread().getName()+":"+v);
                    x++;
                }
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while(x<500){
                    int v = value.getAndIncrement();
                    set.add(v);
                    System.out.println(Thread.currentThread().getName()+":"+v);
                    x++;
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println(set.size());

    }

}
