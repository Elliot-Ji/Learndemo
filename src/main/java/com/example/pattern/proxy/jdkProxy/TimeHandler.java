package com.example.pattern.proxy.jdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理:事务处理器
 *
 * Created by Elliot Ji on 2019/1/8.
 */
public class TimeHandler implements InvocationHandler {

    private Object object;

    public TimeHandler(Object object) {
        super();
        this.object = object;
    }

    /*
    * o  被代理对象
    * method  被代理对象的方法
    * objects  方法参数
    *
    * 返回值:
    * Observer 方法的返回值
    * */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车启动了...");
        method.invoke(object);
        long endtime = System.currentTimeMillis();
        System.out.println("汽车停止..., 行驶时间为"+(endtime-starttime)+"毫秒");
        return null;
    }
}
