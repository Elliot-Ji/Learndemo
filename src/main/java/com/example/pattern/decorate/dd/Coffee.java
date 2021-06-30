package com.example.pattern.decorate.dd;

/**
 * 被装饰者
 * @author: Elliot Ji
 * @createDate: 2021-06-30
 **/
public class Coffee extends Drink {

    @Override
    public float cost() {
        return  super.getPrice();
    }
}
