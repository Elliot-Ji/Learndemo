package com.example.pattern.reflect.base;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射机制学习
 * @author: Elliot Ji
 * @createDate: 2022-08-19
 **/
public class ReflectionQuestion {

    public static void main(String[] args) throws Exception {

        //1.使用Properties类,读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\workspace\\Learndemo\\src\\main\\java\\com\\example\\pattern\\reflect\\base\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + method);

        //2.利用反射,创建对象
        //2.1 加载类,返回Class类型的对象
        Class<?> cls = Class.forName(classfullpath);
        //2.2 通过cls,得到你加载的类,cat的对象实例
        Object o = cls.newInstance();
        System.out.println("o的类型:" + o.getClass());
        //2.3 获取加载类的方法对象(根据方法名称)
        Method method1 = cls.getMethod(method);
        //2.4 通过method1调用方法:即通过方法对象实现调用方法
        method1.invoke(o);//方法.invoke(对象)

        //获取属性值,不能得到私有的属性,
        Field name = cls.getField("name");
        Object o1 = name.get(o);

        //获取构造器方法
        Constructor<?> constructor = cls.getConstructor();//无参构造器



    }

}
