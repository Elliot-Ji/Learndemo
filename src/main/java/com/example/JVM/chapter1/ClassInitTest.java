package com.example.JVM.chapter1;

/**
 * @author Elliot Ji
 * @date 2024/11/18
 */
public class ClassInitTest {

    private static int num = 1;

    static {
        num = 2;
        number = 20;
    }

    private static int number = 10;
    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }



}
