package com.example.suanfa.levelone;

/**
 * 算法新手---1. 打印int类型的32位进制数  与 位运算
 * @author: Elliot Ji
 * @createDate: 2022-03-03
 **/
public class Code01_Print {

    public static void print(int num){
        /**
         *
         * 1 << 31 位移运算:
         *       1.数字 int = 1 在二进制中是 0000 .... 0001表示的
         *      2. m << n 左移 就是将数字1 左移n  位,空出的位置用0表示  也等同于m 这个数乘以2N次方
         * 2. & 运算: 两个1 相遇 为1
         * 3. int 最大值2^31 -1 和最小值
         * 4. 负数的表示: 原码,反码与补码
         *             口诀: 先取反,再加1 (位运算中  ~ 这个表示取反运算)
         * 5. 带符号位右移    -->以符号位替补空出的位置
         *    不带符号位右移  -->以0替补空出的位置
         *
         */
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//         int num = -2;
//
//         print(num);
//        System.out.println("=====");

//        int a = 111;
//        int b = 222;
//        print(a);
//        print(b);
//        System.out.println("==========");
//        print( a | b);
//        System.out.println(a | b);

        int c = 1024;
        print(c >> 1);
        int d = Integer.MIN_VALUE;
        print(d >> 1);
        print(d >>> 1);

        //取一个数的相反数
        int e = 5;
        int f = -e;
        int h = (~e + 1);


    }

}
