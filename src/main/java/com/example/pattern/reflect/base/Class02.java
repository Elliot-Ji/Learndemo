package com.example.pattern.reflect.base;

import java.lang.reflect.Field;

/**
 * Class类常用方法
 * @author: Elliot Ji
 * @createDate: 2022-08-22
 **/
public class Class02 {
    public static void main(String[] args) throws Exception {
        String classPath = "com.example.pattern.reflect.base.Cat";
        Class<?> cls = Class.forName(classPath);
        //Class常用方法
        System.out.println(cls);//哪个类的Class对象
        System.out.println(cls.getClass());//输出cls运行类型
        System.out.println(cls.getPackage().getName());//包名
        System.out.println(cls.getName());//全类名
        //创建对象实例
        Cat cat = (Cat)cls.newInstance();
        System.out.println(cat);
        //获取属性值,Field,此时只能获取public修饰的属性,私有的会报错
        Field name = cls.getField("name");
        System.out.println(name.get(cat));
        //给属性赋值
        name.set(cat,"蓝猫");
        System.out.println(name.get(cat));
        //获取所有属性(public修饰的)
        Field[] fields = cls.getFields();
        for (Field f : fields ) {
            System.out.println(f.getName());
        }
    }
}
