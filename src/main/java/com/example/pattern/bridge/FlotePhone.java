package com.example.pattern.bridge;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-25
 **/
public class FlotePhone extends Phone {

    public FlotePhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("折叠式手机");
    }

    public void close(){
        super.close();
        System.out.println("折叠式手机");
    }

    public void call(){
        super.call();
        System.out.println("折叠式手机");
    }
}
