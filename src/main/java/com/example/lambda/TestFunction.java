package com.example.lambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Elliot Ji
 * @date 2023/11/06
 */
public class TestFunction {

    @Test
    public void test1(){
        VUtils.isTure(false).throwMessage("有没有异常");
    }

    @Test
    public void test2() {
        VUtils.isTrueOrFalse(false).trueOrFalseHandle(() -> {
            System.out.println("true,this is true");
        },() -> {
            System.out.println("false,can not do anything");
        });
    }

    @Test
    public void test3(){
        VUtils.isBlankOrNotBlank("").presentOrElseHandle(System.out::println,() ->{
            System.out.println("空空如也");
        });
    }

    @Test
    public void test4(){
        System.out.println( UUID.randomUUID().toString().substring(0,4));
        System.out.println( UUID.randomUUID().toString().substring(0,4));
        System.out.println( UUID.randomUUID().toString().substring(0,4));
        System.out.println( UUID.randomUUID().toString().substring(0,4));
        System.out.println( UUID.randomUUID().toString().substring(0,4));
    }
    
}
