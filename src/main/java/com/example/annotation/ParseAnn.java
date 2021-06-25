package com.example.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 注解起作用的 核心就是通过: 反射机制来对应实现相应的功能;
 * Created by Elliot Ji on 2018/12/21.
 */
public class ParseAnn {

    /**
     * 注解解析
     * */
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.example.annotation.Child");
            Boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist){
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.value());
            }
            //获取方法上的注解
            Method[] ms = c.getMethods();
            for(Method m : ms){
                boolean b = m.isAnnotationPresent(Description.class);
                if(b){
                    Description ds = (Description) m.getAnnotation(Description.class);
                    System.out.println(ds.value());
                }
            }
            //另外一种解析方法
            for(Method m : ms){
               Annotation[] a =  m.getAnnotations();
                for(Annotation s : a ){
                     if(s instanceof Description){
                         Description d = (Description)s;
                         System.out.println(d.value());
                     }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
