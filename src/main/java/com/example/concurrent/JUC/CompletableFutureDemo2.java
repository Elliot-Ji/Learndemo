package com.example.concurrent.JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * FutureTask 和 线程池的搭配使用
 *     缺点：1.get()阻塞方法，所以要放在程序的后面
 *          2.isDone()方法，轮询。
 *         对结果的获取不是很友好
 * @author Elliot Ji
 * @date 2024/05/30
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        FutureTask<String> task1 = new FutureTask<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1 over ";
        });
        threadPool.submit(task1);

        FutureTask<String> task2 = new FutureTask<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2 over ";
        });
        threadPool.submit(task2);


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();

    }

}
