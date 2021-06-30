package com.example.pattern.decorate.dd;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-30
 **/
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(3.0f);
    }
}
