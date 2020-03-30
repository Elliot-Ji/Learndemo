package com.example.annotation;

/**
 * Created by Elliot Ji on 2018/12/21.
 */
@Description("I am class annotation")
public class Child implements Person {
    @Override
    @Description("I am method annotation")
    public String name() {
        return "cat";
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }

    public static void main(String[] args) {
        Person p = new Child();
        System.out.println(p.name());
    }
}
