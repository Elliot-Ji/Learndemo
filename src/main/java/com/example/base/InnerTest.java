package com.example.base;

/**
 * java 基础:
 *    1. 内部类 --> 匿名内部类
 *               匿名内部类实质是一个带具体实现的父类或者父接口的匿名的子类对象
 *       开发中: 最常用到的内部类的就是匿名内部类,
 *       使用匿名内部类的前提: 必须继承一个父类或者实现一个父接口
 *            即一个抽象类或者一个接口,想直接调用其中的方法?
 *        格式: new 父类名或接口名 () {..........}
 *
 *    2.理解回调函数? --->设计模式中的监听器和观察者模式
 *
 * @author: Elliot Ji
 * @createDate: 2022-08-01
 **/
public class InnerTest {
    public static void main(String[] args) {
        new P() {
            public void say() {
                System.out.println("say what");
            };

            @Override
            public void speak() {
                System.out.println("my test");
            }
        }.say();

        InnerTest innerTest = new InnerTest();
        innerTest.test( new Boy(){
            @Override
            int fly() {
                return 1000;
            }

            @Override
            public String getName() {
                return "八哥";
            }
        });
    }

    public void test(Boy boy) {
        System.out.println(boy.getName() + "能说" + boy.fly() + "句话");
    }

}

interface P{
    void speak();
}

abstract class Boy {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void jump() {

    }

    abstract int fly() ;
}


