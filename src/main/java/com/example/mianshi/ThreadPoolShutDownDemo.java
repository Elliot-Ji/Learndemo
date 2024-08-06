package com.example.mianshi;

import lombok.Getter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的优雅关闭
 * @author Elliot Ji
 * @date 2024/07/29
 */
public class ThreadPoolShutDownDemo {
    public static void main(String[] args) {
        //shutdown_Test();
        shutdownNow_Test();

        shutdown_awaitTermination_Test();

    }

    public static void m() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try{

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            /*
             * 1.初学操作，这么关闭
             * shutdown():调用之后，之前等待执行和正在执行的将继续执行，但不会接受新的任务
             *                    线程池也不会立即停止。
             * shutdownNow(): 立即终止正在执行的任务，取消等待中的任务
             *                但是正在执行的任务不一定能取消成功。
             * 上面两个方法，注意这个尚未完成的任务完成需要有时间，但它们都不会一直等待任务执行完毕，
             *          如果完成任务时间短，会等待任务完成。
             *          如果完成任务时间长，则不会等待任务执行完成，此时如何还需要等待，则使用awaitTermination
             *              如果使用awaitTermination之后，任务还未完成，则也不再等待。
             */
            threadPool.shutdown();
            threadPool.shutdownNow();

            //生产级别，关闭
            finalOK_shutdownAndAwaitTermination(threadPool);
        }
    }

    /**
     *参考官网，优雅关闭，自己封装
     * @param threadPool
     */
    private static void finalOK_shutdownAndAwaitTermination(ExecutorService threadPool) {
        if (threadPool != null && !threadPool.isShutdown()) {
            threadPool.shutdown();
            try {
                if (!threadPool.awaitTermination(120, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow();
                    if (!threadPool.awaitTermination(120,TimeUnit.SECONDS)) {
                        System.out.println("Pool did not terminate");
                    }
                }
            }catch (InterruptedException ie) {
                threadPool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void shutdown_Test(){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <=10 ; i++) {
            System.out.println("第:" + i + " 次提交");
            threadPool.execute(new Task(i));
            if(i == 5) {
                threadPool.shutdown();
            }
        }
    }

    private static void shutdownNow_Test(){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <=10 ; i++) {
            try{
                threadPool.execute(new Task(i));
            }catch (RejectedExecutionException e) {
                System.out.println("rejected,task-" + i);
            }

            if(i == 5) {
                List<Runnable> tasks = threadPool.shutdownNow();
                for (Runnable task : tasks) {
                    if(task instanceof Task) {
                        System.out.println("waiting task: " + ((Task) task).getName());
                    }
                }
            }
        }
    }

    private static void shutdown_awaitTermination_Test(){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <=10 ; i++) {
            System.out.println("第:" + i + " 次提交");
            threadPool.execute(new Task(i));
            if(i == 5) {
                threadPool.shutdown();
                System.out.println("i等于5的时候shutdown，意味着从第6次开始就不能提交新任务");
                System.out.println( );
            }
        }
        try{
            boolean isStop = threadPool.awaitTermination(4, TimeUnit.SECONDS);
            System.out.println("is pool stop:" + isStop);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------");
        System.out.println(Thread.currentThread().getName() + "\t" + "mission is over");
        System.out.println();
    }

    private static void shutdownNow_awaitTermination_Test(){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <=10 ; i++) {
            try{
                threadPool.execute(new Task(i));
            }catch (RejectedExecutionException e) {
                System.out.println("rejected,task-" + i);
            }

            if(i == 5) {
                List<Runnable> tasks = threadPool.shutdownNow();
                for (Runnable task : tasks) {
                    if(task instanceof Task) {
                        System.out.println("waiting task: " + ((Task) task).getName());
                    }
                }
            }
        }

        try{
            boolean isStop = threadPool.awaitTermination(4, TimeUnit.SECONDS);
            System.out.println("is pool stop: " + isStop );
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------");
        System.out.println(Thread.currentThread().getName() + "\t" + "all tests finished");
    }

    static class Task implements Runnable {
        @Getter
        String name = "";

        public Task(int i) {
            name = "task_" + i;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("sleep completed, " +getName());
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("interrupted," + getName());
                return;
            }
            System.out.println(getName() + " finished");
            System.out.println();
        }
    }
}
