package com.example.JVM.chapter2;

/**
 * @author: Elliot Ji
 * @createDate: 2023-04-24
 **/
public class AnimalTest {
    public void showAnimal(Animal animal) {
        animal.eat();//晚期绑定
    }

    public void showHunt(Huntable h) {
        h.hunt();//晚期绑定
    }

}
class Animal{
    public void eat() {
        System.out.println("动物进食");
    }
}

interface Huntable {
    void hunt();
}

class Dog extends Animal implements Huntable{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，多管闲事");
    }

}
class Cat extends Animal implements Huntable{

    public Cat(){
        super();//早期绑定
    }

    public Cat(String name) {
        this();//早期绑定
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，天经地义");
    }

}

