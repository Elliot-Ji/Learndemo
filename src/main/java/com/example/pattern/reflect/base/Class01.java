package com.example.pattern.reflect.base;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-22
 **/
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {

        //1. new对象时,也会进入到 ClassLoader中的
//        public Class<?> loadClass(String name) throws ClassNotFoundException {
//            return loadClass(name, false);
//        }
        Cat cat = new Cat();
       //2.反射创建对象时,也会进入到 ClassLoader中的
        //        public Class<?> loadClass(String name) throws ClassNotFoundException {
        //            return loadClass(name, false);
        //        }
        Class<?> cls = Class.forName("com.example.pattern.reflect.base.Cat");
    }
}
