package com.example.lambda.syntax;

import com.example.lambda.interfaces.*;

/**
 *
 * Created by Elliot Ji on 2019/10/9.
 */
public class Syntax1 {
    public static void main(String[] args) {
          /*
          Lambda表达式基础语法:
              lambda是一个匿名函数
              参数列表 方法体
              () :表示参数列表
              {} :表示方法体
              -> :表示运算符 读作 goes to
           */
          //无参无返回
        LambdaNoneResultNoneParameter lambda1 = ()->{
            System.out.println("无参无返回方法...");
        };
        lambda1.test();
        //无返回,单个参数
        LambdaNoneResultSingleParameter lambda2 = (int a )->{
            System.out.println(a);
        };
        lambda2.test(2);
        //无返回,多个参数
        LambdaNoneResultMultiParameter lambda3 = (int a,int b) -> {
            System.out.println(a+b);
        };
        lambda3.test(10,20);
        //有返回无参数
        LambdaSingleReturnNoneParameter lambda4 = () ->{
            System.out.println("lambda4");
            return 404;
        };
        int test4 = lambda4.test();
        System.out.println(test4);
        //有返回,单个参数
        LambdaSingleReturnSingleParameter lambda5 = (int a)->{
            return a*20;
        };
        int test5 = lambda5.test(100);
        System.out.println(test5);
        //有返回,多个参数
        LambdaSingleReturnMultiParameter lambda6 = (int a ,int b)->{
            return a*b;
        };
        int test = lambda6.test(2, 8);
        System.out.println(test);
    }
}
