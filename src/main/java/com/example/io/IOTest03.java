package com.example.io;



import java.io.*;

/**
 * 文件字节输出流
 * Created by Elliot Ji on 2019/3/6.
 */
public class IOTest03 {

    public static void main(String[] args) {
        File file = new File("dest.txt");
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            String src = "IO is so easy ";
            byte[] datas = src.getBytes();//字符串-->字节(编码)
            out.write(datas,0,datas.length);
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!= out){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
