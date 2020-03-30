package com.example.concurrent.second.chapter4;

/**
 * Created by Elliot Ji on 2019/8/13.
 */
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();

}
