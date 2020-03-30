package com.example.concurrent.second.chapter4;

/**
 * Created by Elliot Ji on 2019/8/13.
 */
public class ObserverClient {

    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("======================");
        subject.setState(10);
        System.out.println("======================");
        subject.setState(10);
        System.out.println("======================");
        subject.setState(20);
    }

}
