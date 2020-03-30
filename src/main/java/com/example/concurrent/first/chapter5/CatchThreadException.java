package com.example.concurrent.first.chapter5;

/**
 * 线程中不能直接抛出异常,只能通过日志或其它途经来查看程序出现的问题
 * 故可利用其提供的API,
 * Created by Elliot Ji on 2019/7/30.
 */
public class CatchThreadException {

    private static final int A= 10;
    private static final int B = 0;

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(5_000);
                int result = A/B ;
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.setUncaughtExceptionHandler((thread,e)->{
            System.out.println(e);
            System.out.println(thread);
        });

        t.start();
    }

}
