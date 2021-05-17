package com.example.generic.interfaceType;

/**
 * @author: Elliot Ji
 * @createDate: 2021-05-17
 **/
public class Apple implements Generi<String> {
    @Override
    public String getKey() {
        return "普通类实现泛型接口,明确泛型标识";
    }
}
