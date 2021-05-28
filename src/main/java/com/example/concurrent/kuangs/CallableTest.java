package com.example.concurrent.kuangs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: Elliot Ji
 * @createDate: 2021-05-28
 **/
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        M m = new M();
        FutureTask futureTask = new FutureTask(m);
        new Thread(futureTask).start();
        String o = (String)futureTask.get();
        System.out.println(o);
    }

}

class M implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "callable的使用";
    }
}
