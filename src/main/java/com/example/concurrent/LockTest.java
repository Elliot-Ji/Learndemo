package com.example.concurrent;

/**
 * Created by Elliot Ji on 2019/5/15.
 */
public class LockTest {

    Lock lock = new Lock();

    public void a() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlocked();
    }

    public void doSomething() throws InterruptedException {
        lock.lock();
        //.........
        lock.unlocked();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        lockTest.a();
        //lockTest.doSomething();
    }
}

class Lock{
    private static boolean isLocked = false;
    private static int countNum = 0 ;
    private Thread thread = null;

    //使用锁
    public synchronized void  lock() throws InterruptedException {
        while(isLocked){
            System.out.println("0");
            wait();
        }
        isLocked = true;
    }

    //释放锁
    public synchronized   void unlocked(){
        isLocked = false;
        notify();
    }
}
