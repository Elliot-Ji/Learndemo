package com.example.pattern.proxy;

/**
 * 静态代理: 聚合方式
 * Created by Elliot Ji on 2019/1/8.
 */
public class CarTimeProxy implements Moveable {

    private Moveable moveable;

    public CarTimeProxy(Moveable moveable) {
        super();
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车启动了...");
        moveable.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车停止..., 行驶时间为"+(endtime-starttime)+"毫秒");
    }
}
