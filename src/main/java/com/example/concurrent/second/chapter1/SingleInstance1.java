package com.example.concurrent.second.chapter1;

/**
 * Created by Elliot Ji on 2019/8/6.
 */
public class SingleInstance1 {

    private static volatile SingleInstance1 instance;

    private SingleInstance1(){

    }

    /**
     * 在多线程模式下,会出现问题,解决方式如下:
     * 也可以直接在该方法上加synchronized,但是会影响性能
     * @return
     */
    public static SingleInstance1 getInstance(){
        if(null == instance){
            synchronized (SingleInstance1.class){
                if(null == instance){
                    instance = new SingleInstance1();
                }
            }
        }
        return SingleInstance1.instance;
    }

}
