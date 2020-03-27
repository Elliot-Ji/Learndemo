package com.example.concurrent.second.chapter4;

import java.util.Arrays;

/**
 * 需求: 获知程序中,多个线程执行任务过程中的线程生命周期的状态
 * Created by Elliot Ji on 2019/8/13.
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2","3"));
    }

}
