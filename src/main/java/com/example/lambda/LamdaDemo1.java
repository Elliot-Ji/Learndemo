package com.example.lambda;

/**
 * Lambda表达式: 接口的函数式实现方式
 *      .filter() 的使用与谓词逻辑
 *      .map() 的使用
 * @author: Elliot Ji
 * @createDate: 2021-05-17
 **/
public class LamdaDemo1 {

    interface Printer{
        void print(String some);
    }

    public void printSomething(String some,Printer printer){
        printer.print(some);
    }

    public static void main(String[] args) {
        LamdaDemo1 lamdaDemo1 = new LamdaDemo1();
        Printer printer = new Printer() {
            @Override
            public void print(String some) {
                System.out.println(some);
            }
        };
        Printer printer1 = (String s)-> {
            System.out.println(s);
        };

        lamdaDemo1.printSomething("huawei",printer);
        lamdaDemo1.printSomething("huawei2",x -> System.out.println(x));
    }

}
