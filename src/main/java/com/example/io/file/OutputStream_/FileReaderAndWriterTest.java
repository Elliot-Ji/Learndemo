package com.example.io.file.OutputStream_;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流：
 *
 * @author: Elliot Ji
 * @createDate: 2023-03-28
 **/
public class FileReaderAndWriterTest {

    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            int data;
            //read（）每次都是读一个字符
            while ((data = fileReader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //减少与磁盘的交互
    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            int data;
            char[] buffer = new char[5];
            while ((data = fileReader.read(buffer)) != -1) {
                for (int i = 0; i < data; i++) {
                    System.out.print(buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        int DEAFAULT_SIZE = 4 << 1;
        System.out.println(DEAFAULT_SIZE);
        FileWriter fw = null;
        try {
            File file = new File("info.txt");
            fw = new FileWriter(file);
            fw.write("I love U\n");
            fw.write("she loves him\n");
            fw.write("oops!!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
