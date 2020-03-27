package com.example.concurrent.second.chapter6;

/**
 * Created by Elliot Ji on 2019/10/31.
 */
public class SharedData {
    private final char[] buffer;

    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for(int i=0;i<size;i++){
            this.buffer[i]= '*' ;
        }
    }

    /**
     * 读操作
     * @return
     * @throws InterruptedException
     */
    public char[] read() throws InterruptedException {
        try{
            lock.readLock();
            return this.doRead();
        }finally{
            lock.readUnlock();
        }
    }

    /**
     * 写操作
     * @throws InterruptedException
     */
    public void write(char c) throws InterruptedException {
        try{
            lock.writeLock();
            this.doWrite(c);
        }finally{
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for(int i=0;i<buffer.length;i++){
            buffer[i] = c;
            slowly( 10);
        }
    }

    private char[] doRead() {
        char[] newBuffer = new char[buffer.length];
        for(int i =0;i<buffer.length;i++){
            newBuffer[i] = buffer[i];
        }
        slowly(50);
        return newBuffer;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}
