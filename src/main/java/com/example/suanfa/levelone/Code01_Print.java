package com.example.suanfa.levelone;

/**
 * 算法新手---1. 打印int类型的32位进制数
 * @author: Elliot Ji
 * @createDate: 2022-03-03
 **/
public class Code01_Print {

    public static void print(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 <<i)) == 0 ? "0" : "1");
        }

    }

    public static void main(String[] args) {
         int num = 5555555;

         print(num);
    }

}
