package com.example.base;

/**
 * Created by Elliot Ji on 2018/10/12.
 * 关键人物线程
 */
public class KeyPersonThread extends Thread {

    public void  run(){
        System.out.println(Thread.currentThread().getName()+"开始了战斗!");
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"左突右杀,攻击隋军...");
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗!");
    }
}
