package com.example.testdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-02
 **/
public class Test1 {

    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>(Arrays.asList("液压多路阀",
                " 油道",
                " 压力油道",
                " 凸起部",
                " 回油油道",
                " 回油",
                " 阀体内",
                " 滑动装配",
                " 外周面",
                " 外固定",
                " 复位组件",
                " 复位件",
                " 连接件",
                " 液压阀",
                " 滑动控制",
                " 阀芯滑动",
                " 控制油道",
                " 阀芯端部",
                " 腔体设置",
                " 驱动器控制",
                " 高压气缸",
                " 密封结构",
                " 导向套",
                " 缸筒",
                " 第一导向"));

//        String ss = "验证方法,jieijf,jifjeifj,jijfief";
//        List<String> s2 = Arrays.stream(ss.split(",")).collect(Collectors.toList());
//        //List<String> s2 = new ArrayList<>(Arrays.asList("fe", "fe", "jijief", "iejfdiejf"));
//        s1.removeAll(s2);
//        s1 = s1.stream().limit(5).collect(Collectors.toList());
//        System.out.println(s1);
        //List<String> s3 = new ArrayList<>(Arrays.asList("肝解毒的中药药丸"," 智能技术"," 高血压"," 消防"," 咨询和服务"," 电器机械零部件的制造"," 油道"," 凸起部"," 压力油道"," 回油油道"));
        String jsvk = "肝解毒的中药药丸,智能技术,高血压,消防,咨询和服务,电器机械零部件的制造,油道,凸起部,压力油道,回油油道, 液压多路阀, 阀体内";
        List<String> s3 = Arrays.stream(jsvk.split(",")).map(String::trim).collect(Collectors.toList());
        System.out.println(s3);
        s1 = s1.stream().map(String::trim).collect(Collectors.toList());
        System.out.println(s1);

        s1.removeAll(s3);
        s1 = s1.stream().limit(5).collect(Collectors.toList());
        System.out.println(s1);





//        new Thread(() -> System.out.println("测试")).start();
//        System.out.println("main ()");
//        String[] data = {"efef","ewefef","efefeffefef","eee","fff","eee"};
//        data = Arrays.stream(data).distinct().toArray(String[]::new);
//        String s = String.join(" ", data);
//        System.out.println(s);
//
//        String str = org.apache.commons.lang.StringEscapeUtils.unescapeHtml("&lt;p&gt;【产品名称】艾酷维多种维生素锌软糖&lt;/p&gt;");
//        System.out.println(str);
//        String str2 = org.apache.commons.lang.StringEscapeUtils.unescapeHtml("<p>【产品名称】艾酷维多种维生素锌软糖</p>");
//
//        System.out.println(str2);


//        BigDecimal wa = new BigDecimal(10000);
//        BigDecimal t = new BigDecimal(13200000);
//        System.out.println(t.multiply(wa));
//        System.out.println(t.divide(wa,2, RoundingMode.HALF_DOWN));

//        String[] data = {"de","ded","deds","iennf","djfiejf","de"};
//        List<String> strings = Arrays.asList(data);
//        List<String> t2 = Arrays.asList("efef","fefef","iejs");
//        List<String> collect = Stream.of(strings, t2).flatMap(Collection::stream).collect(Collectors.toList());
//        System.out.println(collect);
//
//        List<String> collect1 = collect.stream().distinct().collect(Collectors.toList());
//        System.out.println("去重后:" + collect1);


//        String join = StringUtils.join(strings.stream().distinct().toArray(), ",");
//        System.out.println("去重后:" + join);
//
//
//        System.out.println(strings);
//        strings = strings.stream().distinct().collect(Collectors.toList());
//        System.out.println(strings);
//        String[] strings1 = strings.toArray(new String[strings.size()]);
//        for (String ss : strings1) {
//            System.out.println(ss);
//        }


    }

}
