package com.example.pattern.proxy.jdkProxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-23
 **/
public class MainShop {

    public static void main(String[] args) {
        //1.创建目标对象
        UsbSell factory = new UsbKingFactory();
        //2.创建InvocationHandler对象,即代理对象要回调的方法,在该方法中对目标对象指定的方法进行执行,并增强
        InvocationHandler handler = new MySellHandler(factory);
        //3.创建代理对象
        UsbSell o = (UsbSell)Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), handler);
        //4.执行代理对象中的方法-->回调handler中的invoke()
        float sell = o.sell(1);
        System.out.println(sell);
    }

}
