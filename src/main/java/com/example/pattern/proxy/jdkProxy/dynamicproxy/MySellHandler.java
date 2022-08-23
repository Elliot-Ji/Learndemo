package com.example.pattern.proxy.jdkProxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-23
 **/
public class MySellHandler implements InvocationHandler {
    private Object target = null;

    public MySellHandler(Object target) {
        this.target = target;
    }

    //代理类要执行的方法,即为增强方法,
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类完成的功能");
        Object invoke = method.invoke(target,args);
        if (null != invoke) {
            Float price = (Float) invoke;
            invoke = price + 25;
        }
        System.out.println("代理类功能结束");
        return invoke;
    }
}
