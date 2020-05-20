package com.example.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 定义线程的第三种方式:
 * @author Elliot Ji
 * @date 2020/5/19.
 */
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t 执行了");
        Thread.sleep(2000);
        return 1024;
    }
}

public class CallableThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"AAA").start();

        System.out.println(Thread.currentThread().getName()+"\t 我执行了");
        int a = 100;
        while(!futureTask.isDone()){

        }
        int b = futureTask.get();
        System.out.println("==========" + (a+b));

    }

}
