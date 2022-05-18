package com.example.concurrent.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture: 异步编排
 * @author: Elliot Ji
 * @createDate: 2022-05-18
 **/
public class TestCompletableFuture {

    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        //无返回值
        CompletableFuture.runAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果: " + i);
        },executor);

        //有返回值, 方法执行完成后的结果感知, => whenComplete() 和 exceptionally() 方法
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 2;
            return i;
        }, executor).whenComplete((result,exception) -> { //计算完成时回调方法,whenComplete*()方法;虽能得到异常信息,但是没法修改返回数据
            System.out.println("上面的异步任务完成了...结果是: " + result + "; 异常是: " + exception);
        }).exceptionally( exception -> { //获取上面异步任务的异常,做处理,然后返回默认值
            int temp = 10;
            return temp;
        });

        //有返回值,方法执行完成后的处理 ==> handler()方法
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 2;
            return i;
        }, executor).handle((result,exception) -> {
            if (result != null) {
                return result * 2;
            }
            if (exception != null) {
                return 0;
            }
            return -1;
        });

        /**
         *  线程串行化方法
         *  1).thenRun*(): 不能获取到上一步的执行结果,且无返回值
         *  2).thenAccept*(): 能获取到上一步的执行结果,且无返回值
         *  3).thenApply*(): 能获取到上一步的执行结果,且有返回值
         */
        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 2;
            return i;
        }, executor).thenRunAsync(() -> {
            System.out.println("任务2启动执行......");
        }, executor);

        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 2;
            return i;
        }, executor).thenAcceptAsync((result) -> {
            System.out.println("任务2启动执行......,上一步的处理结果:" + result);
        }, executor);

        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getId());
            int i = 10 / 2;
            return i;
        }, executor).thenApplyAsync((result) -> {
            System.out.println("任务2执行....上一步结果为: " + result);
            return "Hello" + result;
        }, executor);

        /**
         * 两任务组合,都要完成,再触发下一个任务
         * 1).thenCombine*(): 组合两个future,获取两个future的返回结果,并返回当前任务的返回值, 有返回值;
         * 2).thenAcceptBoth*(): 组合两个future,获取两个future的返回结果,然后处理任务,无返回值;
         * 3).runAfterBoth*(): 组合两个future,不需要获取future的结果,只需两个future处理完任务后,处理该任务,无返回值;
         */
        CompletableFuture<Integer> future01 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1线程: " + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("任务1结束...");
            return i;
        }, executor);

        CompletableFuture<String> future02 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2线程: " + Thread.currentThread().getId());
            System.out.println("任务2结束...");
            return "Hello future02";
        }, executor);

        future01.runAfterBothAsync(future02, () -> {
            MyNumber myNumber = new MyNumber();
            myNumber.setId(5566);
            myNumber.setName("狂风");
            System.out.println("任务3开始...");
        }, executor);



        //System.out.println(future.get());//阻塞方法,获取返回结果
        System.out.println("wo shi main 线程: " + Thread.currentThread().getId());

    }

}
