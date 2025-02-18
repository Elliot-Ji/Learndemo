package com.example.JVM.chapter1;

/**
 * @author Elliot Ji
 * @date 2024/11/18
 */
public class ClinitTest {
    //任何一个类声明以后，内部至少存在一个类的构造器
    private int a = 1;

    private static int c = 3;

    public static void main(String[] args) {
        int b = 2;
    }


    public ClinitTest(){
        a = 10;
        int d = 20;
    }
}
