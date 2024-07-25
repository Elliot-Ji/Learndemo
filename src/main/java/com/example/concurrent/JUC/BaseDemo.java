package com.example.concurrent.JUC;

/**
 * JUC
 *  https://www.bilibili.com/video/BV1ar4y1x727?p=3&vd_source=b5f8254ef4878b9fdd7d9b9213accf9d
 * @author Elliot Ji
 * @date 2024/05/20
 */
public class BaseDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

        },"t1");
        t1.start();
    }

}
