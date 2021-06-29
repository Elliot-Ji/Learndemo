package com.example.io.file.OutputStream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象的序列化,
 * Java中的基本数据类型都默认实现Serializable接口
 * 引用类型要想实现序列化都必须implements Serializable接口
 * @author: Elliot Ji
 * @createDate: 2021-06-28
 **/
public class ObjectOutputStreamDemp {
    public static void main(String[] args) {
        String path = "d:\\dog.dat";
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeInt(100);//int ---> Integer (实现了Serializable)
            oos.writeBoolean(false);
            oos.writeChar('F');
            oos.writeDouble(3.2);
            oos.writeObject(new Dog("Lily",2));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos != null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

class Dog implements Serializable {
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
