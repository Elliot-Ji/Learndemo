package com.example.concurrent.second.chapter6;

/**
 * 读写锁设计模式
 * Created by Elliot Ji on 2019/10/31.
 */
public class ReadWriteLock {

    private int readingReaders = 0;//当前有几个线程正在进行读的操作
    private int waitingReaders = 0;//当前有几个线程排队等待读的操作
    private int writingWriters = 0;//当前有几个线程正在写操作(最多只有一个)
    private int waitingWriters = 0;//当前有几个线程排队等待写的操作
    private boolean preferWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    /**
     * 获取读锁
     * @throws InterruptedException
     */
    public synchronized  void readLock() throws InterruptedException {
        this.waitingReaders ++;
        try {
            while (writingWriters > 0 ||(preferWriter && waitingWriters>0)) {//当前线程进到读锁,发现有别的线程正在写操作,就不能就行读操作
                this.wait();
            }
            this.readingReaders ++;//当前线程获取到读锁,进行工作
        }finally{
            this.waitingReaders --;
        }
    }

    /**
     * 释放读锁
     */
    public synchronized void readUnlock(){
        this.readingReaders --;
        this.notifyAll();
    }

    /**
     * 获取写锁
     * @throws InterruptedException
     */
    public synchronized void writeLock() throws InterruptedException {
        this.waitingWriters ++;// 线程即将进入阻塞状态
        try{
            while(readingReaders>0||writingWriters>0){//当前线程发现有别的线程正在进行读操作或者写操作时,进入阻塞状态
                 this.wait();
            }
            this.writingWriters++;
        }finally{
            this.waitingWriters --;//线程退出阻塞状态
        }
    }

    /**
     * 释放写锁
     */
    public synchronized void writeUnlock(){
        this.writingWriters--;
        this.notifyAll();
    }
}
