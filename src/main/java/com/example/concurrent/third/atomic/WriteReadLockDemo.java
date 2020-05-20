package com.example.concurrent.third.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试案例
 * @author Elliot Ji
 * @date 2020/5/15.
 */
public class WriteReadLockDemo {
    public static void main(String[] args) {
        Source source = new Source();
        for (int i = 1; i <= 5 ; i++) {
            final int v = i;
            new Thread(()->{
                try {
                    source.put(String.valueOf(v),String.valueOf(v));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5 ; i++) {
            final int v = i;
            new Thread(()->{
                try {
                    source.get(String.valueOf(v));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}

class Source{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object o) throws InterruptedException {
        try{
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "正在写入" + key);
            Thread.sleep(300);
            map.put(key,o);
            System.out.println(Thread.currentThread().getName() +"写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) throws InterruptedException {
        try{
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "正在读取");
            Thread.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成 :" + result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}