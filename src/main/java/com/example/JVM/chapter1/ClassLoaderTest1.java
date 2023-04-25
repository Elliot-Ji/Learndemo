package com.example.JVM.chapter1;

import java.net.URL;

import static sun.misc.Launcher.getBootstrapClassPath;

/**
 * @author: Elliot Ji
 * @createDate: 2023-04-19
 **/
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("启动类加载器");
        //获取BootstrapClassLoader能够加载的api的路径
        URL[] urLs = getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }

        System.out.println("扩展类加载器");
        String property = System.getProperty("java.ext.dirs");
        for (String path : property.split(";")) {
            System.out.println(path);
        }

    }
}
