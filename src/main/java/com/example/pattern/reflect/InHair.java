package com.example.pattern.reflect;

import com.example.pattern.reflect.Hair;

/**
 * Created by Elliot Ji on 2018/10/15.
 */
public class InHair implements Hair {
    @Override
    public void draw() {
        System.out.println("----------中分发型-----------");
    }
}
