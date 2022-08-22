package com.example.pattern.reflect.base;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-22
 **/
public class Reflaction02 {
    public static void main(String[] args) {

    }

    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.example.pattern.reflect.base.Person");
        Field[] fields = cls.getFields();//获取所有public修饰的属性,包含本类和父类
        Field[] declaredFields = cls.getDeclaredFields();//获取本类中所有属性
        Method[] methods = cls.getMethods();//获取本类及父类的public修饰的方法
        Method[] declaredMethods = cls.getDeclaredMethods();//获取本类中的所有方法
        Constructor<?>[] constructors = cls.getConstructors();//获取本类中public修饰的构造器
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();//获取本类中所有的构造器
    }

}

class A {
    public String hobby;

    public void hi() {

    }
}

class Person extends A{
    public String name;
    protected int age;
    String job;
    private double sal;

    public void m1() {

    }
    protected void m2() {

    }
    void m3() {

    }
    private void m4() {

    }
}
