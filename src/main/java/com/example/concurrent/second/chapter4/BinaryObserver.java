package com.example.concurrent.second.chapter4;

/**
 * Created by Elliot Ji on 2019/8/13.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
       super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String:  "+Integer.toBinaryString(subject.getState()));
    }
}
