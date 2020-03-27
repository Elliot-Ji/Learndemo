package com.example.pattern.decorate;

/**
 * Created by Elliot Ji on 2019/3/14.
 */
public class DecorateTest02 {

    public static void main(String[] args) {
        Drink drink = new Coffe();

        Drink milk = new Milk(drink);

        Drink suger = new Suger(drink);

        System.out.println(milk.info());
        System.out.println(milk.cost());
        System.out.println(suger.cost());
        System.out.println(suger.info());

        Drink mix = new Milk(suger);

        System.out.println(mix.cost());
        System.out.println(mix.info());

    }


}

//抽象组件
interface Drink{
    double cost();
    String info();
}

//具体组件
class Coffe implements Drink{

    private String name = "原味咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }


}

//装饰抽象类,
 abstract  class Decorate implements Drink{
    //对抽象组件的引用
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}


//具体装饰类
class Milk extends Decorate{

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加入牛奶";
    }
}

class Suger extends Decorate{

    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"加入蔗糖";
    }
}
