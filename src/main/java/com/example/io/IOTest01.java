package com.example.io;

import java.io.*;

/**
 * Created by Elliot Ji on 2019/3/6.
 */
public class IOTest01 {

    public static void main(String[] args) {
        File file = new File("abc.txt");
        InputStream inputStream = null;
        int temp;
        try {
            inputStream = new FileInputStream(file);
            while((temp=inputStream.read())!=-1){
                System.out.print((char)temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(inputStream!=null){
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }

}
