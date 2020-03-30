package com.example.lambda.syntax;

import com.example.lambda.interfaces.LambdaNoneResultMultiParameter;
import com.example.lambda.interfaces.LambdaNoneResultNoneParameter;
import com.example.lambda.interfaces.LambdaNoneResultSingleParameter;
import com.example.lambda.interfaces.LambdaSingleReturnMultiParameter;

/**
 * Created by Elliot Ji on 2019/10/9.
 */
public class Syntax2 {
    public static void main(String[] args) {
        //lambda表达式语法精简
        //1.参数类型:
        //由于接口中已经定义了参数数量和类型,所以在lambda表达式中可以省略参数类型
        //备注:如果要省略参数类型,要么一起省略,要么都不省略
        LambdaNoneResultMultiParameter lambda1 = (a, b)->{
            System.out.println("");
            System.out.println("Hello World");
        };
        lambda1.test(1,3);
        //2.参数小括号
        //如果参数列表中,参数数量只有一个,此时小括号可以省略
        LambdaNoneResultSingleParameter lambda2 = a ->{
            System.out.println(a);
        };
        lambda2.test(10);
        //3.方法大括号
        //如果方法体中只有一条语句,此时大括号可以省略
        LambdaNoneResultNoneParameter lambda3 = ()-> System.out.println("大括号可以省略");
        LambdaNoneResultSingleParameter lambda4 = a -> System.out.println(a);
        lambda3.test();
        lambda4.test(110);
        //4.如果方法体中的唯一一条语句是一个返回语句,则省略大括号的同时,必须省略return
        LambdaSingleReturnMultiParameter lambda5 = (a,b) -> a*b;
        int test = lambda5.test(4, 4);
        System.out.println(test);


    }
}
