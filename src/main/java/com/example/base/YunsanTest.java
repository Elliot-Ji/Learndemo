package com.example.base;

import java.util.Scanner;

/**
 * @author Elliot Ji
 * @date 2025/02/13
 */
public class YunsanTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int number = sc.nextInt();

        int ge = number % 10;
        int shi = number / 10 % 10;
        int bai = number /100 % 10;
        System.out.println(ge);
        System.out.println(shi);
        System.out.println(bai);

        int a = 10;
        int b = ++a;
        System.out.println(a + " " + b);
    }

}
