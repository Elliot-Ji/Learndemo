package com.example.JVM.chapter2;

/**
 * 栈大小： 11404
 * 修改参数 -Xss256K
 * @author: Elliot Ji
 * @createDate: 2023-04-23
 **/
public class StackErrorTest {
    private static int count = 1;

    public static void main(String[] args) {
        StackErrorTest errorTest = new StackErrorTest();
        System.out.println(count);
        count++;
        errorTest.test1();
    }

    public  void test1 () {
        System.out.println("test1执行。。。");
        test2();
    }

    public int test2() {
        System.out.println("test2....");
        return 3;
    }
}
