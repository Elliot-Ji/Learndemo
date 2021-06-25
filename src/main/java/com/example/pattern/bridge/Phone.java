package com.example.pattern.bridge;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-25
 **/
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open(){
        this.brand.open();
    }
    protected void close(){
        this.brand.close();
    }
    protected  void call(){
        this.brand.call();
    }
}
