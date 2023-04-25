package com.example.JVM.chapter2;

/**
 * @author: Elliot Ji
 * @createDate: 2023-04-24
 **/
public class DynamicLinkingTest {
    int num = 10;

    public void methodA() {
        System.out.println("methodA().....");
    }

    public void methodB() {
        System.out.println("methodB().....");
        methodA();
        num++;
    }

}
