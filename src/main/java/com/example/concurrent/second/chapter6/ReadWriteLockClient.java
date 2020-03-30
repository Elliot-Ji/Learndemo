package com.example.concurrent.second.chapter6;

/**
 * Created by Elliot Ji on 2019/10/31.
 */
public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData data = new SharedData(10);
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();

        new WriterWorker(data,"abcdefghigk").start();
        new WriterWorker(data,"ABCDEFGHIGK").start();
    }

}
