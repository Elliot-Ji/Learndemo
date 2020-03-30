package com.example.classLoader;

/**
 * Created by Elliot Ji on 2019/12/12.
 */
public class TestFileSystemClassLoader {

    public static void main(String[] args) throws Exception {
        FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjavassist");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("d:/demo");

        Class<?> c = loader.loadClass("com.elliot.bean.HelloWorld");
        Class<?> c2 = loader.loadClass("com.elliot.bean.HelloWorld");
        Class<?> c3 = loader2.loadClass("com.example.classLoader.Demo");

        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c.getClassLoader());
        System.out.println(c3.getClassLoader());
    }

}
