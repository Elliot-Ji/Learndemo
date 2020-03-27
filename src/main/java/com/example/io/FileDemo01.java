package com.example.io;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by Elliot Ji on 2019/3/6.
 */
public class FileDemo01 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String src = "io.txt";
        File file = new File("src");

        String ts = "性命生命使命a";
        byte[] bytes = ts.getBytes("gbk");
        System.out.println(bytes.length);

        String s = new String(bytes,"gbk");
        System.out.println(s);
    }


}
