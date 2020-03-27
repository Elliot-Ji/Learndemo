package com.example.concurrent.first.chapter2;

import java.util.Optional;
import java.util.stream.IntStream;



/**
 * join()的用法
 * Created by Elliot Ji on 2019/7/26.
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread( () -> {
            IntStream.range(1,100).forEach(i -> System.out.println(Thread.currentThread().getName()+"->"+i));
        });

        Thread t2 = new Thread( ()->{
            IntStream.range(1,100).forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Optional.of("All tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1,100).forEach(i -> System.out.println(Thread.currentThread().getName()+"->"+i));
    }

}
