package com.example.concurrent.first.chapter4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;



/**
 * Created by Elliot Ji on 2019/7/30.
 */
public class BooleanLock implements Lock {

    //initValue is true indicated the lock have be get
    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while(initValue){
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();

    }

    @Override
    public void lock(long mills) throws TimeOutException, InterruptedException {
        if(mills<0)
            lock();

        long hasRemaining = mills;
        long endTime = System.currentTimeMillis()+mills;
        while(initValue){
            if(hasRemaining <=0){
                 throw  new TimeOutException("Time out");
            }
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = endTime - System.currentTimeMillis();
        }

        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        if(Thread.currentThread() == currentThread){
            this.initValue = false;
            Optional.of(Thread.currentThread() + " release the lock monitor . ").ifPresent(System.out::println);
            this.notifyAll();
        }

    }

    @Override
    public Collection<Thread> getBlockedThread() {
        //防止blockedThreadCollection被修改
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
