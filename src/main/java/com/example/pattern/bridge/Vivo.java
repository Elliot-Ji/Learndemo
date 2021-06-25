package com.example.pattern.bridge;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-25
 **/
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("vivo手机打电话");
    }
}
