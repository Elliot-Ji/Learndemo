package com.example.pattern.strategy.impl;

import com.example.pattern.strategy.FlyingStrategy;

/**
 * Created by Elliot Ji on 2019/1/7.
 */
public class FlyingWithWing implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("我是用翅膀飞行的!");
    }
}
