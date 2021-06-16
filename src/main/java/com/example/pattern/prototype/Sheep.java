package com.example.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 原型模式 利用Object类的clone()方法
 * 浅拷贝
 * 深拷贝有两种方式
 *      1. 对引用类型单独处理,再次clone()
 *      2. 利用序列化和反序列化,流来处理
 * @author: Elliot Ji
 * @createDate: 2021-06-16
 **/
@Data
@AllArgsConstructor
@ToString
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;

    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
