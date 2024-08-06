package com.example.mianshi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 和线程池的搭配使用注意事项
 * @author Elliot Ji
 * @date 2024/07/25
 */
public class ThreadLocalDemoV2 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            for (int i = 1; i <= 10 ; i++) {
                int finalI = i;
                threadPool.submit(() -> {
                    try {
                        Integer beforeInt = myData.threadLocalField.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName() + " \t" + "工作窗口受理"
                                + finalI + "个客户" + "\t beforeInt:" + beforeInt + "\t afterInt:" + afterInt);
                    }finally {
                        myData.threadLocalField.remove();
                    }
                });
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }


}

class MyData{
    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(()-> 0);

    public void add() {
        threadLocalField.set(1 + threadLocalField.get());
    }

}
