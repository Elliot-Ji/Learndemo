package com.example.JVM.chapter1;

/**
 * @author Elliot Ji
 * @date 2024/11/18
 */
public class ClinitTest1 {
    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            // 内层循环控制列数，列数从 1 开始，最大到当前行数
            for (int j = 1; j <= i; j++) {
                // 打印乘法表达式，使用制表符 \t 分隔
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
            // 每一行结束后换行
            System.out.println();
        }
    }
}
