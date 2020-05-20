package com.example.concurrent;

/**
 * @author Elliot Ji
 * @date 2020/5/20.
 */
public class DeadLockDemo implements Runnable{
    private String lockA;
    private String lockB;

    public DeadLockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有锁"+lockA+ "\t 尝试获取锁"+lockB);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有锁" +lockB+ "\t 尝试获取锁"+lockA);
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new DeadLockDemo(lockA,lockB),"Thread AA").start();
        new Thread(new DeadLockDemo(lockB,lockA),"Thread BB").start();
    }

}
