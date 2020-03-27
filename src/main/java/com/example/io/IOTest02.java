package com.example.io;

import java.io.*;

/**
 * Created by Elliot Ji on 2019/3/6.
 */
public class IOTest02 {

    public static void main(String[] args) {
        File file = new File("abc.txt");
        InputStream in = null;
        byte[] ts = new byte[6];//缓冲容器
        int len = -1; //实际接受的长度;
        try {
             in = new FileInputStream(file);
            while((len=in.read(ts))!=-1){
                String str = new String(ts,0,len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(in!=null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();

            }
        }
    }

}
