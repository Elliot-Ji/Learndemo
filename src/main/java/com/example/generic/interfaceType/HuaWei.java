package com.example.generic.interfaceType;

/**
 * @author: Elliot Ji
 * @createDate: 2021-05-17
 **/
public class HuaWei<T,E> implements Generi<T> {
   private T key;
   private E value;

    public HuaWei(T key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }
}
