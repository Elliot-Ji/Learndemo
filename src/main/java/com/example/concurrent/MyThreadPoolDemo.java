package com.example.concurrent;

import java.util.concurrent.*;

/**
 * 创建线程的第四种方式: 线程池
 *
 * @author Elliot Ji
 * @date 2020/5/19.
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(2,5,1L,
                                   TimeUnit.SECONDS,
                                   new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),
                                   new ThreadPoolExecutor.AbortPolicy());

        try{
            for (int i = 1; i <= 4; i++) {
                executorService.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }


    }

    public void ThreadPoolDemo(){
        //ExecutorService executorService = Executors.newSingleThreadExecutor(); //一池1个线程
        //ExecutorService executorService = Executors.newFixedThreadPool(5);  //一池固定数量的线程
        ExecutorService executorService = Executors.newCachedThreadPool();  //一池n个线程

        try{
            for (int i = 0; i < 10; i++) {
                executorService.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

}
