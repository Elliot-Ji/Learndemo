package com.example.testdemo;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-02
 **/
public class Test1 {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("测试")).start();
        System.out.println("main ()");


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
