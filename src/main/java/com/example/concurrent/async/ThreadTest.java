package com.example.concurrent.async;

import java.util.concurrent.*;

/**
 * 创建线程的方式:
 *    3.Callable + futureTask 实现线程
 *    4.线程池 ExecutorService ☆ (异步任务都交给线程池执行) 4.1 利用Executors 创建线程池
 *                                                      4.1 new ThreadPoolExecutor
 * @author: Elliot Ji
 * @createDate: 2022-05-18
 **/
public class ThreadTest {
    public static ExecutorService service = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable01());
        new Thread(futureTask).start();
        //service.execute(futureTask);

        Integer integer = futureTask.get();
        System.out.println("main.....end..." + integer);
        //System.out.println(getMyNumber());

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,100,10,
                                                            TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000),
                                                            Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    }


    public static class Callable01 implements Callable<Integer> {
        @Override
        public Integer call(){
            System.out.println("当前线程:" + Thread.currentThread().getId());
           // MyNumber myNumber = ThreadTest.getMyNumber();
           // System.out.println(myNumber);
            int a = 10 / 2;
            return a;
        }
    }

    public static MyNumber getMyNumber() {
        final MyNumber myNumber = new MyNumber();
        return myNumber;
    }
}

class MyNumber{
    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
