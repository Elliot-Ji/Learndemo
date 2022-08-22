package com.example.pattern.reflect.base;

/**
 * 获取Class对象几种方式
 * @author: Elliot Ji
 * @createDate: 2022-08-22
 **/
public class Class03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取Class类对象
        //1.Class.forName("全类名"),多用于配置文件读取类全路径,加载类;

        //2.若已知具体的类,则 Cat.class(),多用于参数传递,比如通过反射得到对应构造器对象
        Class<Cat> catClass = Cat.class;

        //3.已知某个类的实例,对象.getClass(),多用于通过创建好的对象,获取Class对象
        Cat cat = new Cat();
        Class<? extends Cat> cls2 = cat.getClass();

        //4.其他方式 ClassLoader cl = 对象.getClass().getClassLoader();
        //          Class cls = cl.loadClass("类的全类名");
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass("com.example.pattern.reflect.base.Cat");

        //5.基本数据类型获取Class对象
        Class<Integer> integerClass = int.class;

        //6.基本数据类型的包装类
        Class<Integer> type = Integer.TYPE;

    }

}
