package com.example.concurrent.first.chapter4;

import java.util.Optional;
import java.util.stream.Stream;

/**
 *自定义Lock锁
 * Created by Elliot Ji on 2019/7/30.
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {

        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1","T2","T3","T4")
                .forEach(name ->
                    new Thread(() -> {
                        try {
                            booleanLock.lock();
                            Optional.of(Thread.currentThread().getName()+" have the lock Monitor").ifPresent(System.out::println);
                            work();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            booleanLock.unlock();
                        }
                    },name).start()
                );
        //Thread.sleep(10);
        //booleanLock.unlock();//此时会出现bug,出现main线程释放锁!!!!!!!如何修改
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName()+" is working ...").ifPresent(System.out::println);
        Thread.sleep(5_000);

    }

}
