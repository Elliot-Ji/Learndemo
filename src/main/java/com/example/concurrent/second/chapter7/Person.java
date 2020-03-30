package com.example.concurrent.second.chapter7;

/**
 * 用final修饰的属性
 * 不可变对象一定是线程安全的
 * 不可变对象:所有的属性都是有final和private修饰的
 *          没有setter方法
 *          该对象不能被继承
 * Created by Elliot Ji on 2019/10/31.
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
