package com.example.pattern.strategy;

/**
 * 策略模式:
 * 抽象类,所有的鸭子都要继承此类,
 * 抽象了鸭子的行为:显示和鸣叫
 * Created by Elliot Ji on 2019/1/7.
 */
public abstract class Duck {

    private FlyingStrategy flyingStrategy;

    public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
        this.flyingStrategy = flyingStrategy;
    }

    /**
     * 通用行为:鸭子发出叫声
     * */
    public void quack(){
        System.out.println("嘎嘎嘎嘎嘎... ... !");
    }

    /**
     * 显示鸭子的外观,
     * 而外观各不相同,声明为abstract
     *
     * */
    public abstract void display();


    public void fly(){
        flyingStrategy.performFly();
    }



}
