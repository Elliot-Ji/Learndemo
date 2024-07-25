package com.example.concurrent.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 异步编程：
 *    Future接口，为主线程开一个分支任务(开一个异步线程)
 *          实现类： FutureTask
 *        Runnable接口
 *        Callable接口
 *        Future接口
 *
 * @author Elliot Ji
 * @date 2024/05/30
 */
public class CompletableFutureDemo1 {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            String s = futureTask.get();//获取异步线程执行后的结果
            System.out.println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("----come in call() ");
        return "hello callabel";
    }
}

































