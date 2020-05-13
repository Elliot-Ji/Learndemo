package com.example.pattern.proxy;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Elliot Ji on 2019/1/8.
 */
public class Car implements Moveable{


    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        StringBuffer buffer = new StringBuffer();
//
//        System.out.println(getname());
//
//        String str = "abaab";
//        char[] chars = str.toCharArray();
//        int[] count = new int[256];
//        for (int i = 0; i <chars.length ; i++) {
//            count[chars[i]]++;
//        }
//        for (int s: count) {
//            System.out.print(s);
//        }

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized(o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    public static String getname(){
        List<String> name = new ArrayList<>();
        name.add("新中街道");
        name.add("五种街道");
        name.add("舞蹈街道");
        name.add("bage");

        StringBuffer buffer = new StringBuffer();
        System.out.println(buffer.toString());
        buffer.append("[");
        name.forEach(x->{
            buffer.append(x).append(",");
        });
        buffer.replace(buffer.length()-1,buffer.length(),"");
        buffer.append("]");
        return buffer.toString();
    }
}
