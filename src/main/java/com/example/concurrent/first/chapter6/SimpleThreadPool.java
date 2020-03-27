package com.example.concurrent.first.chapter6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义线程池
 * Created by Elliot Ji on 2019/8/5.
 */
public class SimpleThreadPool {

    private final int size;

    /**
     * 线程池默认大小
     */
    private final static int DEFAULT_SIZE = 10;

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    /**
     * 线程集合
     */
    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();
    /**
     * 任务队列
     */
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    public SimpleThreadPool(){
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    /**
     * 初始化,此时没有任务,处于wait状态
     */
    private void init(){
        for(int i=0; i<size; i++){
            createWorkTask();
        }

    }

    /**
     * 对外提供的接口,放置任务
     * @param runnable
     */
    public void submit(Runnable runnable){
        synchronized (TASK_QUEUE){
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private void createWorkTask(){

         WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX+(seq++));
         task.start();
         THREAD_QUEUE.add(task);
    }

    private enum TaskState{
        FREE,RUNNING,BLOCKED,DEAD
    }

    private static class WorkerTask extends Thread{
        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group,String name){
            super(group,name);
        }

        @Override
        public void run() {
            //OUTER 表示一个线程进入wait时,被打断,则重新进入outer下一行,
            OUTER:
            while(this.taskState != TaskState.DEAD){
                Runnable runnable;
                 synchronized (TASK_QUEUE){
                     while(TASK_QUEUE.isEmpty()){
                         try {
                             taskState = TaskState.BLOCKED;
                             TASK_QUEUE.wait();
                         } catch (InterruptedException e) {
                             break OUTER;
                         }
                     }
                     runnable = TASK_QUEUE.removeFirst();
                 }
                if(runnable!=null){
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public TaskState getTaskState(){
            return this.taskState;
        }

        public void close(){
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) {
        SimpleThreadPool threadPool = new SimpleThreadPool();//创建线程池
        /**
         * 有四十个任务要去执行,
         * 调用线程池执行任务分析(调用线程池的API):
         * 思路:1.将要执行的任务提交到线程池中--->这些任务是实现Runnable接口的,将任务存放到任务队列中
         *     2.线程池初始化时,创建线程
         *
         */
//        for(int i = 0; i < 15;i++){
//            threadPool.submit(()->{
//                System.out.println("The runnable:  "+Thread.currentThread()+"started...");
//                try {
//                    Thread.sleep(1_000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("The runnable:  "+Thread.currentThread()+"finished...");
//            });
//        }

        for(int i=0;i<16;i++){
            Runnable runnable = new A();
            threadPool.submit(runnable);
        }

    }

    public static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("A The runnable:  "+Thread.currentThread()+"started...");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A The runnable:  "+Thread.currentThread()+"finished...");
        }
    }
}
