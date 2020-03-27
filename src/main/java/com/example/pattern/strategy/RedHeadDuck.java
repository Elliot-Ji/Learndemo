package com.example.pattern.strategy;

import com.example.pattern.strategy.impl.FlyingWithWing;

/**
 * Created by Elliot Ji on 2019/1/7.
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck(){
        super();
        super.setFlyingStrategy(new FlyingWithWing());
    }

    @Override
    public void display() {
        System.out.println("我的头是红色的!");
    }

    public static void main(String[] args) {
        Duck duck = new RedHeadDuck();
        duck.quack();
        duck.display();
        duck.fly();
    }
}
