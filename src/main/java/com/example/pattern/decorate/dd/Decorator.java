package com.example.pattern.decorate.dd;

/**
 * 装饰者类
 * @author: Elliot Ji
 * @createDate: 2021-06-30
 **/
public class Decorator extends Drink {
    private Drink obj;//被装饰者

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    public String getDes(){
        return des + " "+ getPrice()+ "&&"+ obj.getDes();
    }
}
