package com.example.pattern.strategy;

import com.example.pattern.strategy.impl.FlyingWithWing;

/**
 *
 * Created by Elliot Ji on 2019/1/7.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        super();
        super.setFlyingStrategy(new FlyingWithWing());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色的!");
    }


    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.quack();
        duck.fly();
        duck.display();
    }
}
