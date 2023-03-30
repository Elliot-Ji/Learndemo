package com.example.suanfa.levelzees;

/**
 *
 * @author: Elliot Ji
 * @createDate: 2023-03-28
 **/
public class Code01 {
    public static void main(String[] args) {
        String x = "((降低 耗能) OR 节能 OR 减排)";
        x = x.replace(" ","");
        if (x.contains("((")) {
            int i = x.indexOf(")");
            x = x.substring(2,i);
        }
        System.out.println(x);
    }
}
