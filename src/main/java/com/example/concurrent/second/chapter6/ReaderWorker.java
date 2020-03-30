package com.example.concurrent.second.chapter6;

/**
 * Created by Elliot Ji on 2019/10/31.
 */
public class ReaderWorker extends Thread{
    private final SharedData data;

    public ReaderWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while(true){
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(readBuf));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
