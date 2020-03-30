package com.example.concurrent.first.chapter3;

import java.util.*;

/**
 * 需求:
 * 目前需要采集10台机器中的数据,在将10台机器全部采集完后,做统一处理?
 * 思路:多线程处理(不使用线程池)
 * 1.根据服务器性能运行5个线程,其他线程处于wait状态,等待被唤醒;
 * 2.要判断工作线程是否超过5,超过即wait;
 * 3.等10台机器全部处理完,主线程再集中处理,需使用jion();
 * Created by Elliot Ji on 2019/7/30.
 */
public class CaptureService {

    private final static LinkedList<Control> CONTROLS = new LinkedList<>();
    private final static int MAX_WORKER = 5;

    public static void main(String[] args) {

        List<Thread> worker = new ArrayList<>();//用来存放线程
        //处理10台机器
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10").stream()
                .map(CaptureService::createCaptureThread)
                .forEach(t->{
                    t.start();
                    worker.add(t);
                });

        worker.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of capture work finished").ifPresent(System.out::println);//等上面所有的线程运行结束,再执行
    }

    /**
     * 创建线程
     * @param name
     * @return
     */
    private static Thread createCaptureThread(String name){
        return new Thread( ()->{
           Optional.of("The worker ["+Thread.currentThread().getName()+"] BEGIN capture data .").ifPresent(System.out::println);
           synchronized (CONTROLS){
               while(CONTROLS.size() > MAX_WORKER){
                   try {
                       CONTROLS.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               CONTROLS.addLast(new Control());
           }

            Optional.of("The worker ["+Thread.currentThread().getName()+"] is working . . .").ifPresent(System.out::println);

            //模拟线程需要的工作内容
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //当前线程任务运行结束后
            synchronized (CONTROLS){
                Optional.of("The worker ["+Thread.currentThread().getName()+"] END capture data .").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }

        }, name);
    }

    private static class  Control{

    }
}
