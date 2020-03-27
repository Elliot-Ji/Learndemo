package com.example.concurrent.second.chapter1;

/**
 * 常用的
 * Created by Elliot Ji on 2019/8/6.
 */
public class SingleTnstance02 {

    private SingleTnstance02(){

    }

    /**
     * 内部类
     */
    private static class InstanceHolder{
        private final static SingleTnstance02 instance = new SingleTnstance02();
    }

    public static SingleTnstance02 getInstance(){
        return InstanceHolder.instance;
    }

}
