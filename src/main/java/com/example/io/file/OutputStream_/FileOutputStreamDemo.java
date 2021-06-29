package com.example.io.file.OutputStream_;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-28
 **/
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        fileOut();
    }

    public static void fileOut(){
        String path = "d:\\jack.txt";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            String content = "Learn Java IO";
            //fos.write('H');
            //fos.write(content.getBytes());
            //重点理解下面这个方法,后面两个参数的含义
            fos.write(content.getBytes(),0,content.length());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
