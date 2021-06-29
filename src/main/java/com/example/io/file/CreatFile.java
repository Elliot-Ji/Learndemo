package com.example.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件的三种方式
 * @author: Elliot Ji
 * @createDate: 2021-06-28
 **/
public class CreatFile {

    public static void main(String[] args) {
        //create01();
        //create02();
        create03();
    }

    //方式一:
    public static void create01(){
        File file = new File("d:\\news1.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式二
    public static void create02(){
        File file = new File(new File("d:\\"), "news2.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式三
    public static void create03(){
        File file = new File("d:\\","news3.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
