package com.example.concurrent.thread;

/**
 * Created by Elliot Ji on 2018/12/26.
 */
public class DisappearRequest1 implements Runnable{
   static DisappearRequest1 d = new DisappearRequest1();

    static int i = 0;
    /**
     * 在不做并发处理时,程序输出的结果
     * */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for(int j = 0;j<100000;j++){
            i++;
        }
    }
}
