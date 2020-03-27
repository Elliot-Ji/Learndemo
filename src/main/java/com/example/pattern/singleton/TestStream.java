package com.example.pattern.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Elliot Ji on 2018/9/4.
 */
public class TestStream {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        for(int i =0; i<10;i++){
//            list.add("stream"+i);
//        }
        List<Map> listMap = new ArrayList<>();
        for(int i =1;i<10;i++){
            Map map1 = new HashMap();
            map1.put("id",i);
            map1.put("name","luck"+i);
            listMap.add(map1);
        }


        List<Map> list1 = listMap.stream().filter(f -> f.get("id").toString().equals("2")).collect(Collectors.toList());//streamAPI 实现快速的查询集合
        System.out.println(list1);

    }
}
