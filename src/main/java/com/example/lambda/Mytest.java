package com.example.lambda;

import com.example.lambda.interfaces.LambdaSingleReturnSingleParameter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Elliot Ji
 * @createDate: 2022-05-06
 **/
public class Mytest {

    public static void main(String[] args) {
//        getT(5,x -> {
//            int v = x * 20;
//            return v;
//        } );
//        System.out.println( 1 % 10);
//        String d = "1112" + "-12-31";
//        LocalDate parse = LocalDate.parse(d);
//        System.out.println(parse);
//        String userArea = "10";
//        String dn = null;
//        List<String> list = null;
//        if (StringUtils.isNotEmpty(userArea)) {
//            list = new ArrayList<>();
//            AreaInfoEnum areaInfoEnum = AreaInfoEnum.getSonAreaByCode(userArea);
//            if (areaInfoEnum.getSonArea() != null) {
//
//                String sonArea = areaInfoEnum.getSonArea();
//                String[] split = sonArea.split(";");
//                for (int i = 0; i < split.length; i++) {
//                    String s = split[i];
//                    String[] dns = s.split("-");
//                    list.add(dns[1]);
//                }
//                dn = "dn4";
//            }else {
//                list.add(areaInfoEnum.getName());
//                dn = "dn3";
//            }
//            System.out.println(list);
//        }

//        LocalDate timeByDay = getTimeByDay(15);
//        LocalDate timeByMonth = getTimeByMonth(1);
//        System.out.println(timeByDay);
//        System.out.println(timeByMonth);
//        List<String> collect = new ArrayList<>();
//        List<String> names = Arrays.asList("烽火通信科技股份有限公司", "郑州信大捷安信息技术股份有限公司", "中兴通讯股份有限公司", "深圳忆联信息系统有限公司", "北京轩宇信息技术有限公司", "中标软件有限公司");
//        //List<String> names = Arrays.asList("烽火通信科技股份有限公司");
//        CompletableFuture<Void> futureOne = CompletableFuture.runAsync(() -> {
//            System.out.println(names.get(0));
//            collect.add(names.get(0));
//        });
//        if (names.size() >= 2) {
//            CompletableFuture<Void> futureTwo = CompletableFuture.runAsync(() -> {
//                System.out.println(names.get(1));
//                collect.add(names.get(1));
//            });
//            CompletableFuture.allOf(futureOne,futureTwo).join();
//        }else {
//            CompletableFuture.allOf(futureOne).join();
//        }
//        System.out.println(collect);

//        String type = "cn_in;cn_gp";
//        String[] split = type.split(";");
//        for (String s : split ) {
//            System.out.println(s);
//        }
//        double s = 22.344;
//        System.out.println(String.valueOf(s));


//        List<String> list = Arrays.asList("ff");
//        String[] objects =(String[]) list.toArray();
//        for (String s: objects) {
//            System.out.println(s);
//        }
//
//        List<String> list = new ArrayList<>();
//        //List<String> one = Arrays.asList("ee","3df","iei");
//        List<String> one = new ArrayList<>();
//        list.addAll(one);
//        list.forEach(x-> {
//            System.out.println(x);
//        });

        String attWord = "";
        List<String> entities = Arrays.asList("jie,jifjie,jifjefij,jifejf", "jeii,lsoe,iejf", "xnfuie,eisdf,jwiu", "iejfje,jalliefj,eidk");
        StringBuilder builder = new StringBuilder();
        entities.forEach(x -> builder.append(x).append(","));
        builder.deleteCharAt(builder.lastIndexOf(","));
        attWord = builder.toString();
        System.out.println(attWord);
    }


    public static LocalDate getTimeByDay(Integer day) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = now.plusDays(day);
        return dateTime.toLocalDate();
    }

    public static LocalDate getTimeByMonth(Integer month) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = now.plusMonths(month);
        return dateTime.toLocalDate();
    }




    public static LocalDateTime parse(String str,String format){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(str,df);
    }

    public static void getT(int a ,LambdaSingleReturnSingleParameter parameter){
        System.out.println("测试1");
        System.out.println(parameter.test(a));
        System.out.println("测试二");
    }

}
