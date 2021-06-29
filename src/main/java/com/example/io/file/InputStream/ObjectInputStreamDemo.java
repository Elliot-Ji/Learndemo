package com.example.io.file.InputStream;



import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 对象反序列化
 * 1. 属性被static,transient修饰的不会被序列化
 * 2. 默认属性类型都是实现了serializable接口
 * 3. 序列化具备可继承性,即其子类也默认实现序列化接口
 * 4. 推荐加上SerialVersionUID,为了提高版本的兼容性,即当某个类做了修改之后,告诉编译器,这个类还是之前的版本类型
 * @author: Elliot Ji
 * @createDate: 2021-06-28
 **/
public class ObjectInputStreamDemo {

    public static void main(String[] args) throws Exception {
        String path = "d:\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        Object o = ois.readObject();
        System.out.println(o.getClass());
        System.out.println(o);

        ois.close();

    }
}
