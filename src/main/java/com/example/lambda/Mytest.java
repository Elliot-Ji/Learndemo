package com.example.lambda;

import com.example.lambda.interfaces.LambdaSingleReturnSingleParameter;

/**
 * @author: Elliot Ji
 * @createDate: 2022-05-06
 **/
public class Mytest {

    public static void main(String[] args) {
        getT(5,x -> {
            int v = x * 20;
            return v;
        } );
        System.out.println( 1 % 10);

    }

    public static void getT(int a ,LambdaSingleReturnSingleParameter parameter){
        System.out.println("测试1");
        System.out.println(parameter.test(a));
        System.out.println("测试二");
    }

}
