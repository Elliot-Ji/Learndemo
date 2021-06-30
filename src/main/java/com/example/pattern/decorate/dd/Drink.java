package com.example.pattern.decorate.dd;

import lombok.Data;

/**
 * 装饰者模式: 基类
 * @author: Elliot Ji
 * @createDate: 2021-06-30
 **/
@Data
public abstract class Drink {
    public String des;
    private float price = 0.0f;

    public abstract float cost();
}
