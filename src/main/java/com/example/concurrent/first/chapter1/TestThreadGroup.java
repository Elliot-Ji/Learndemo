package com.example.concurrent.first.chapter1;

import java.util.Arrays;

/**
 * Created by Elliot Ji on 2020/1/17.
 */
public class TestThreadGroup {

    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
//        System.out.println(t.getName());
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup());
//        System.out.println(t.getThreadGroup());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        Arrays.asList(threads).forEach(System.out::println);

    }

}
