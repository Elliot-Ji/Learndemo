package com.example.io;


import java.io.*;

/**
 * 文件复制
 * Created by Elliot Ji on 2019/3/8.
 */
public class CopyFile {

    public static void main(String[] args) {
        File file = new File("abc.txt");
        File fileOut = new File("copyabc.txt");

        InputStream ins = null;
        OutputStream out = null;
        int len = -1;
        byte[] bytes = new byte[1024];
        try {
            ins = new FileInputStream(file);
            out = new FileOutputStream(fileOut);
           while((len = ins.read(bytes))!=-1){
               out.write(bytes,0,len);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(out!=null)
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            try {
                if(ins!=null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
