package com.example.concurrent.first.chapter6;

/**
 * return与finally的执行顺序
 * Created by Elliot Ji on 2019/10/31.
 */
public class tezst {
    public static void main(String[] args) {
        //System.out.println(show());
        int show = show();
        System.out.println( show);
    }

    public static int show(){
        try{
            System.out.println("1被执行...");
            System.out.println("2被执行....");
            return get();
        }finally{
            System.out.println("finally被执行....");
        }
    }

    public static int get(){
        return 2*4;
    }
}
