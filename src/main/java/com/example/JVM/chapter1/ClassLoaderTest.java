package com.example.JVM.chapter1;

import com.example.JVM.MyNN;
import org.junit.Test;

/**
 * @author: Elliot Ji
 * @createDate: 2023-04-12
 **/
public class ClassLoaderTest {

    @Test
    public void test1(){
        //获取系统类加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);

        //获取扩展类加载器
        ClassLoader parent = loader.getParent();
        System.out.println(parent);

        //获取启动类加载器（为null，使用C/C++写的）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    @Test
    public void test2(){
        //用户自定义的类使用的是系统类加载器加载的
        Class<MyNN> clazz1 = MyNN.class;
        ClassLoader loader = clazz1.getClassLoader();
        System.out.println(loader);
    }

}
