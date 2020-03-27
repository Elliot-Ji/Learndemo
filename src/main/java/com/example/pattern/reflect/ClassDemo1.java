package com.example.pattern.reflect;

/**
 * Created by Elliot Ji on 2018/10/12.
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        //Foo类的实例对象如何表示?
        //即创建Foo类的实例对象foo1
        Foo foo1 = new Foo();

        //Foo这个类 本身就是一个实例对象,因为Java语言中万事万物皆对象
       //那Class类的实例对象如何表示
        //任何一个类都是Class的实例对象,这个实例对象有三种表示方式:

        //第一种方式--->说明任何一个类都有一个隐含的静态变量
        Class c1 = Foo.class;

        //第二种方法:已知该类的对象
        Class c2 = foo1.getClass();

        /**
         * c1 , c2 表示了Foo类的类类型(class type)
         * 类也是对象,是Class类的实例对象
         * 这个对象我们称之为该类的类类型
         * */
       //第三种方式:
        Class c3 = null;
        try {
            c3 = Class.forName("com.example.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //不管c1 or c2 or c3 都代表了Foo类的类类型,而一个类只可能是Class类的一个实例对象
        System.out.println( c1==c2);//true
        System.out.println(c2==c3);//true

        //此时我们完全可以通过该类的类类型来创建该类的实例对象--------->通过c1 or c2 or c3 来创建Foo类的实例对象
        try {
            Foo foo = (Foo)c1.newInstance();//前提是Foo类有无参数的构造方法
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}

class Foo{

    void print(){
        System.out.println("Foo的方法");
    }
}
