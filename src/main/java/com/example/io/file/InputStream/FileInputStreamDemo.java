package com.example.io.file.InputStream;


import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-28
 **/
public class FileInputStreamDemo {
    public static void main(String[] args) {
          input();
    }

    /**
     * 重点理解int a = file.read()方法,一次读取一个字节,其返回值的含义
     *        int a = file.read(byte[] b) 一次读取b个长度的字节
     *     区分中文和英文的编码集不同,中文所代表的字节数也不同;
     */
    public static void input(){
        String path = "d:\\hello.txt";
        FileInputStream fileInputStream = null;
        byte[] bytes = new byte[8];
        int read = 0;
        try {
            fileInputStream = new FileInputStream(path);
            while((read = fileInputStream.read(bytes)) != -1){
                System.out.print(new String(bytes,0,read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
