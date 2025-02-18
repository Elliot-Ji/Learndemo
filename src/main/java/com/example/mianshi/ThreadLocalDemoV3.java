package com.example.mianshi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal  VS InheritableThreadLocal VS  TransmittableThreadLocal
 * @author Elliot Ji
 * @date 2024/07/26
 */
@Slf4j
public class ThreadLocalDemoV3 {
    public static void main(String[] args) {
        m1();
        //m2();
        //m3();
        //m4();
        //m5();
    }

    /*
      *ThreadLocal可以在当前线程中共享数据，set/get需要再同一个线程中执行才行，别人的取不到
      */
    public static void  m1() {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> null);
        threadLocal.set(Thread.currentThread().getName() + "-Java");
        log.info("major: {}", threadLocal.get());
        System.out.println();

        //新建线程1
        new Thread( () -> {
            log.info("major: {}" ,threadLocal.get());
            threadLocal.set(Thread.currentThread().getName() + "-Vue");
            log.info("major: {}" ,threadLocal.get());
        },"thread1").start();
        System.out.println();
        //线程暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //新建线程2
        new Thread( () -> {
            log.info("major: {}" ,threadLocal.get());
            threadLocal.set(Thread.currentThread().getName() + "-Flink");
            log.info("major: {}" ,threadLocal.get());
        },"thread2").start();
        System.out.println();

        //新建线程3
        CompletableFuture.supplyAsync(() -> {
            log.info("major: {}" ,threadLocal.get());
            threadLocal.set(Thread.currentThread().getName() + "-mysql");
            log.info("major: {}" ,threadLocal.get());
            return null;
        });
        System.out.println();

        //线程暂停几秒钟
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void  m2() {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->null);
        threadLocal.set(Thread.currentThread().getName()+"-Java");
        log.info("major:{}",threadLocal.get());

        new Thread(()->{
            log.info("major:{}",threadLocal.get());
        },"thread1").start();

    }
    public static void  m3() {
        //子线程获取主线程中的变量
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set(Thread.currentThread().getName()+ "-Java");
        log.info("major:{}",inheritableThreadLocal.get());

        new Thread(()->{
            log.info("major:{}",inheritableThreadLocal.get());
        },"thread1").start();

        new Thread(()->{
            log.info("major:{}",inheritableThreadLocal.get());
        },"thread2").start();

        new Thread(()->{
            log.info("major:{}",inheritableThreadLocal.get());
        },"thread3").start();


    }
    public static void  m4() {
        //InheritableThreadLocal 遇到线程池会有问题
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set(Thread.currentThread().getName()+ "-Java");
        log.info("major:{}",inheritableThreadLocal.get());

        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(()->{
            log.info("threadPool第一次获取 major:{}",inheritableThreadLocal.get());
        });
        //线程暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        //在主线程修改放入了Vue，线程池复用后不好使，获取不到主线程的变量
        inheritableThreadLocal.set(Thread.currentThread().getName()+"_Vue修改了");
        log.info("major:{}",inheritableThreadLocal.get());

        threadPool.execute(()->{
            log.info("threadPool第二次获取 major:{}",inheritableThreadLocal.get());
        });
        //线程暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void  m5() {
        //TransmittableThreadLocal  需要导入阿里的Jar包
        /**
         * <>com.alibaba</>
         * <>transmittable-thread-local</>
         * <>2.14.3</>
         */


    }
}
























