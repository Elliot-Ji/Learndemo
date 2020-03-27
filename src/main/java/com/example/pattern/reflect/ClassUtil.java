package com.example.pattern.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Elliot Ji on 2018/10/12.
 */
public class ClassUtil {


    public static void main(String[] args) throws IllegalAccessException {
        String ss = "abc";
        String sscopy = "abc";
        String replace = "123";
        Field[] fields = ss.getClass().getDeclaredFields();
        System.out.println("ss的hashcode"+ss.hashCode()+",replace的hashcode"+replace.hashCode());
        for(Field field :fields){
            System.out.println(field.getName());
            if("value".equals(field.getName())){
                field.setAccessible(true); //为true强行越过private修饰符
                char[] value = (char[])field.get(ss);
                for(int i=0;i<value.length;i++){
                    value[i] = replace.toCharArray()[i];
                }

            }

        }

        System.out.println(ss);
    }


    public static void printClassMessage(Object obj){
         //要获取类的信息,首先要获取类的类类型
        Class c = obj.getClass();//传递的是哪个子类对象,c 就是该子类的类类型
        //获取类的名称
        System.out.println("类的名称是:"+c.getName());

        /**
         * 类中的成员变量,成员函数(成员方法)也都是对象
         * Method类,方法的对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数,包括父类继承而来的
         * */
        Method[] ms = c.getMethods();


        /**
         *成员变量也是对象
         * java.lang.reflect.Field
        * Field类封装了关于成员变量的操作
         * */
        Field[] fs = c.getFields();
    }


}
