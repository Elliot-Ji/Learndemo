package com.example.concurrent.second.chapter5;

/**
 * Created by Elliot Ji on 2019/10/31.
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baobao","Beijing",gate);
        User sh = new User("ShangLao","ShangHai",gate);
        User gz = new User("GuangLao","GuangZhou",gate);

        bj.start();
        sh.start();
        gz.start();
        /*
          出现线程安全问题:
                    (1)要素:共享资源,临界值,发生争抢
          解决方法: 在临界值的方法上放置锁Synchronized
          多线程读之间可以不用加锁
          故:如何实现读写锁分离?
         */
    }

}
