package com.example.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义文件系统类加载器
 * Created by Elliot Ji on 2019/12/12.
 */
public class FileSystemClassLoader extends ClassLoader {
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        //先查询有没有加载过这个类,如有加载的,则直接加载已加载好的;如没有,则加载新的类
        if(c!=null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try{
                c = parent.loadClass(name); //委派给父类加载
            }catch (Exception e){

            }
            if(c!=null){
                return c;
            }else{
                byte[] classData = getClassData(name);//获取字节数组
                if(classData == null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }

    /**
     * 通过文件内容(文件流)转成字节数组
     * @param classname
     * @return
     */
    private byte[] getClassData(String classname){
        String path = rootDir+"/"+classname.replace(".","/")+".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while((temp=is.read(buffer))!=-1){
                baos.write(buffer,0,temp);
            }

            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            try {
                if(is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(baos!=null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
