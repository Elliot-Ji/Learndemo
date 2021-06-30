package com.example.pattern.decorate.dd;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-30
 **/
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(4.0f);
    }
}
