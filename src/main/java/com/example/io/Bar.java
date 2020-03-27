package com.example.io;

/**
 * Created by Elliot Ji on 2019/3/6.
 */
public class Bar<T> {

    public void getName (T t){
        System.out.println(t.toString());
    }

    public <T> void getFr(T t){
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        Bar<Fruit> bar = new Bar();
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Dog dog = new Dog();
        bar.getFr(fruit);
        bar.getFr(apple);
        bar.<Dog>getFr(dog);

        System.out.println("##################");
        bar.getName(fruit);
        bar.getName(apple);
        //bar.getName(dog);
    }

}

class Fruit{
     public  String  toString(){
        return "fruit";
    }
}

class Apple extends Fruit{
    public String toString(){
        return "apple";
    }
}

class Dog{
    public String toString(){
        return "dog";
    }
}
