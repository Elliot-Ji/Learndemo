package com.example.lambda.data;


import lombok.Data;

/**
 * Created by Elliot Ji on 2019/10/9.
 */
@Data
public class Person {

    private String name;
    private int age;

    public Person() {
        System.out.println("Person的无参构造方法运行了");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person的有参构造方法运行了");
    }
}
