package com.example.lambda.syntax;

import com.example.lambda.data.Person;

/**
 * Created by Elliot Ji on 2019/10/9.
 */
public class Syntax4 {

    public static void main(String[] args) {
        //构造方法的引用
        PersonCreate personCreate1 = () -> new Person();
        Person p1 = personCreate1.getPerson();

        PersonCreate personCreate2 = Person :: new;
        Person p2 = personCreate2.getPerson();

        PersonCreate2 personCreate2l = Person::new;
        Person p3 = personCreate2l.getPerson("zhangshan",20);

    }

}

interface PersonCreate{
    Person getPerson();
}

interface PersonCreate2{
    Person getPerson(String name,int age);
}
