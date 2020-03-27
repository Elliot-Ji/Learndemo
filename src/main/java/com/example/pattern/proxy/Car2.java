package com.example.pattern.proxy;

/**
 * 静态代理:继承的方式
 * Created by Elliot Ji on 2019/1/8.
 */
public class Car2 extends Car {

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车启动了...");
        super.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车停止..., 行驶时间为"+(endtime-starttime)+"毫秒");
    }
}
