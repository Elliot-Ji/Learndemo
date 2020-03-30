package com.example.pattern.proxy;

/**
 * 静态代理: 聚合方式
 * Created by Elliot Ji on 2019/1/8.
 */
public class CarLogProxy implements Moveable {

    private Moveable moveable;

    public CarLogProxy(Moveable moveable) {
        super();
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("日志记录启动了...");
        moveable.move();
        System.out.println("日志记录结束了...");
    }
}
