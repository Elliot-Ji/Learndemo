package com.example.pattern.decorate.dd;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-30
 **/
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(8.0f);
    }
}
