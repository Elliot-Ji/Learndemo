package com.example.concurrent.first.chapter2;

/**
 * Created by Elliot Ji on 2019/7/29.
 */
public class TestSyn {

    private final Object LOCK = new Object();
    private static int  i = 1;
    private static int MAX= 500;

    public void num(){
        while(i<MAX){
            synchronized (LOCK){
                if(i>MAX){
                    return;
                }else{
                    i++;
                    System.out.println(i);
                }
            }
        }

    }

    public static void main(String[] args) {
        TestSyn ts = new TestSyn();

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                ts.num();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                ts.num();
            }
        }.start();
    }

}
