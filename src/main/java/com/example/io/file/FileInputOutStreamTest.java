package com.example.io.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Elliot Ji
 * @createDate: 2023-03-28
 **/
public class FileInputOutStreamTest {

    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File src = new File("jianfei.png");
            File dest = new File("jianfei_copy.png");

            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
