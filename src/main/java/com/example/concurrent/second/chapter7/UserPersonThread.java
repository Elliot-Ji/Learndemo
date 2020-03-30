package com.example.concurrent.second.chapter7;

/**
 * 不可变对象设计模式
 * Created by Elliot Ji on 2019/10/31.
 */
public class UserPersonThread extends Thread {
    private Person person;

    public UserPersonThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+" print "+person.toString());
        }
    }
}
