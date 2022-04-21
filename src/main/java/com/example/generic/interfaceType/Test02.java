package com.example.generic.interfaceType;

/**
 * @author: Elliot Ji
 * @createDate: 2022-04-21
 **/
public class Test02<T,E> implements Generi<T> {
    private T key;
    private E value;

    @Override
    public T getKey() {
        return key;
    }

    public Test02(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
