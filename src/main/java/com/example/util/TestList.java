package com.example.util;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Elliot Ji on 2019/2/28.
 */
public class TestList {



   public static void main(String[] args) {
////        List<Map<String,String>> list = new ArrayList<>();
////        for(int i=0;i<10;i++){
////            Map<String,String> map = new HashMap<>();
////            map.put("name","Jerry"+i);
////            map.put("age","19"+i);
////            System.out.println(map);
////            list.add(map);
////
////        }
////
////        System.out.println(list);
//
//        List<String> ors = new ArrayList<>();
//        ors.add("dfefa");
//        ors.add("efadf");
//        System.out.println(ors.get(0));
       DecimalFormat numFormat = new DecimalFormat("0.00");
       Integer a = 23;
       Integer b = 34;
       Float c = Float.valueOf(b).floatValue();
       System.out.println(numFormat.format((a/c)*100)+"%");
       System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
