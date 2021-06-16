package com.example.pattern.prototype.deepcopy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-16
 **/
@Data
@ToString
@NoArgsConstructor
public class DeepPrototype implements Serializable,Cloneable {

    private String name;
    private int age;
    private DeepPrototypTarget target;

    @Override
    protected Object clone()  {
        Object p = null;
        try {
            p = super.clone();
            DeepPrototype p1 = (DeepPrototype)p;
            p1.target = (DeepPrototypTarget)target.clone();
            return p1;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object cloneDeep(){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前对象以对象流的方式输出

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepPrototype copyObj = (DeepPrototype)ois.readObject();
            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                ois.close();
                bis.close();
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
