package com.example.pattern.proxy;

/**
 * Created by Elliot Ji on 2019/9/3.
 */
public class ClientTeacher {

    public static void main(String[] args) {
        IteacherDao target = new TeacherDao();
        ProxyFactory factory = new ProxyFactory(target);
        IteacherDao proxyInstance = (IteacherDao)factory.getProxyInstance();//获取动态代理对象
       // System.out.println(proxyInstance.getClass());
        proxyInstance.teach();
    }

}
