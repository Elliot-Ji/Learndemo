package com.example.concurrent.first.chapter4;

import java.util.Collection;

/**
 * 自定义Lock锁,
 * Created by Elliot Ji on 2019/7/30.
 */
public interface Lock {

    class TimeOutException extends  Exception{
        public TimeOutException(String message){
            super(message);
        }
    }

    void lock () throws InterruptedException;

    void lock(long mills) throws InternalError, TimeOutException, InterruptedException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
