package com.example.JVM.chapter1;

import java.io.FileNotFoundException;

/**
 * 自定义用户类加载器
 * @author Elliot Ji
 * @date 2024/11/19
 */
public class CustomClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            }else{
                return defineClass(name,result,0,result.length);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String name) {
        //细节略，读取该路径下的字节码文件
        return null;
    }
}
