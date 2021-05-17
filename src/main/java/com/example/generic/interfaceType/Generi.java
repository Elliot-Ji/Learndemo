package com.example.generic.interfaceType;

/**
 * 泛型接口:
 *      1. 普通类实现泛型接口,泛型标识需明确
 *      2. 泛型类实现泛型接口,泛型标识需一致
 * @author: Elliot Ji
 * @createDate: 2021-05-17
 **/
public interface Generi<T> {
    T getKey();
}
