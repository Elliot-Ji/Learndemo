package com.example.concurrent.second.chapter1;

/**
 * 利用枚举,创建单例
 * Created by Elliot Ji on 2019/8/6.
 */
public class SingleInstance3 {

    private SingleInstance3(){

    }

    private enum Singleton{
        INSTANCE;

        private final SingleInstance3 instance;

        Singleton(){
            instance = new SingleInstance3();
        }

        public SingleInstance3 getInstance(){
            return instance;
        }
    }

    public static SingleInstance3 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

}
