package com.example.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Created by Elliot Ji on 2018/12/21.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    String value();

//    String author();
//
//    int age () default 18;


}
