package com.example.JVM;

public class MyNN {
    private static int a = 1;
    public static String s = "jj";

    static {
        a = 4;
    }

    public static void main(String[]  args) {
        System.out.println(a);
        System.out.println(s);
    }
}
