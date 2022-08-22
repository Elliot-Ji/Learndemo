package com.example.pattern.reflect.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String address = "CZ";
    public String name = "拉菲";
    public int age = 2;

    public void hi() {
        System.out.println("我是可爱的猫猫" + this.name + "今年:" + age + "岁啦!");
    }

}
