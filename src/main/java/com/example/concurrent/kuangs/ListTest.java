package com.example.concurrent.kuangs;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全的解决方法: JUC中的并发类来解决
 * @author: Elliot Ji
 * @createDate: 2021-05-28
 **/
public class ListTest {

    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

}
