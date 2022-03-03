package com.example.suanfa;

import java.util.concurrent.*;

/**
 * @author: Elliot Ji
 * @createDate: 2021-08-17
 **/
public class De {
    public static void main(String[] args)  {
        System.out.println("开始");
        ExecutorService EXECUTOR_SERVICE = De.getThreadPool();

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    int a = 10/1;
                    System.out.println("第一个方法");
                }catch (ArithmeticException e){
                    e.printStackTrace();
                    System.out.println("exception");
                }
            }).thenRun(()->{
                while (!(((ThreadPoolExecutor)EXECUTOR_SERVICE).getTaskCount() == ((ThreadPoolExecutor)EXECUTOR_SERVICE).getCompletedTaskCount())) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("第二个方法");
            });
        future.join();
        EXECUTOR_SERVICE.shutdownNow();
        System.out.println("main线程");
    }

    public static ExecutorService getThreadPool() {
        final ExecutorService executorService = new ThreadPoolExecutor(2, 50,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        return executorService;
    }

}

