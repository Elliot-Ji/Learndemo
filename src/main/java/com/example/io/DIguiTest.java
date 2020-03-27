package com.example.io;


import java.io.File;

/**
 * Created by Elliot Ji on 2019/3/5.
 */
public class DIguiTest {

    public static void main(String[] args) {
        File src = new File("D:/demo");

        printInt(11);
        printNames(src);
    }

    public static void printInt(int n){
        if(n>10){
            return;
        }
        System.out.println(n);
        printInt(n+1);
    }

    public static void printNames(File src){
        System.out.println(src.getName());
        if(src == null || !src.exists()){
            return;
        }else if(src.isDirectory()){
            for(File s : src.listFiles()){
                printNames(s);
            }
        }
    }

}
