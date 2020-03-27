package com.example.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于接口的动态代理
 * 基于子类的动态代理,使用第三方jar包: cglib
 * Created by Elliot Ji on 2019/9/3.
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获取动态代理对象
     * 如何创建代理对象:
     *    使用Proxy类中的newProxyInstance()
     * 创建代理对象的要求:
     *    被代理类最少实现一个接口,如果没有则不能使用
     * newProxyInstance()方法中的参数:
     *    ClassLoader:类加载器
     *         是用于加载代理对象的字节码的.实际就是和被代理对象使用相同的类加载器(字节码文件).固定写法
     *    Class[] :字节码数组
     *         是用于让代理对象和被代理对象拥有相同的方法.固定写法
     *    InvocationHandler:用于提供增强的代码
     *         它是让我们写如何代理.我们一般是写一个该接口的实现类,通常情况下都是匿名内部类
     *         此接口的实现类都是谁用谁写.
     * @return
     */
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 该方法的作用:执行被代理对象的任何接口方法都会经过该方法.起拦截作用;
                     * 方法参数的含义:
                     * @param proxy:    代理对象的引用
                     * @param method:   当前执行的方法
                     * @param args:     当前执行的方法所需的参数
                     * @return:         和被代理对象当前执行的方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理开始....");
                        Object returnObj = method.invoke(target, args);
                        System.out.println("代理结束....");
                        return returnObj;
                    }
                }
        );
    }
}
