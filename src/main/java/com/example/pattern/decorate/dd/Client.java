package com.example.pattern.decorate.dd;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-30
 **/
public class Client {
    public static void main(String[] args) {
        Drink drink =  new Espresso();
        System.out.println("费用: " + drink.cost());
        System.out.println("菜单: " + drink.getDes());

        drink = new Milk(drink);
        System.out.println("加了一份牛奶费用: " + drink.cost());
        System.out.println("菜单: " + drink.getDes());

        drink = new Chocolate(drink);
        System.out.println("加了一份牛奶和一块巧克力费用: " + drink.cost());
        System.out.println("菜单: " + drink.getDes());
    }
}
