package com.example.dataStructure.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列: FIFO 先进先出原则
 * @author Elliot Ji
 * @date 2020/5/19.
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        /*
         * 1.默认给定初始大小
         * 2.以下方法调用会直接抛出异常
         */
        BlockingQueue<String> blockingQueueDemo = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueueDemo.add("a"));
        System.out.println(blockingQueueDemo.add("b"));
        System.out.println(blockingQueueDemo.add("c"));
        //System.out.println(blockingQueueDemo.add("d"));

        System.out.println(blockingQueueDemo.element());

        System.out.println(blockingQueueDemo.remove());
        System.out.println(blockingQueueDemo.remove());
        System.out.println(blockingQueueDemo.remove());
        //System.out.println(blockingQueueDemo.remove());

        /*
         * 3.以下方法调用不会出异常
         */
        //offer(),poll(),peek();

        /*
         *4. put(),take()
         */

        /*
         *5.插入给定时间,以防一致阻塞
         */
    }

}
