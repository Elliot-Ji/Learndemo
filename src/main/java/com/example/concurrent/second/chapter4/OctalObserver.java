package com.example.concurrent.second.chapter4;

/**
 * Created by Elliot Ji on 2019/8/13.
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String:  "+Integer.toOctalString(subject.getState()));
    }
}
