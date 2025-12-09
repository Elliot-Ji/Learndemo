package com.example.testdemo;

import cn.hutool.json.JSON;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static cn.hutool.http.ContentType.JSON;

/**
 * @author Elliot Ji
 * @date 2023/5/16
 */
public class Test5 {
    private static final Random OR = new Random();
    private static final Random AR = new Random();
    private static final Random DR = new Random();


    public static void main(String[] args) {
        int n = 1;
        long factorial = 1;
        long sum = 0;
        int i = 1;
        do {
            factorial *= i;
            sum += factorial;
            i++;
        } while (i <= 100);
        System.out.println("1！ + 2！ + 3！ + ... + 100! 的和为: " + sum);
    }


    @Test
    public void test1(){
        Optional<Integer> integer = Optional.ofNullable(3).map(x -> x*30);
        System.out.println(integer.get());
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("XIAOMI INC.", "XIAO MI INC.", "CHEN XIAOPING", "XIAOMI INC");
        list.forEach(x -> {});
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger.get());
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger.get());
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger.get());
        Long ll = 20L;
        Long k3 = 20L;
        System.out.println(ll.equals(k3));
    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

        String reg = "";

//        String str = "{No. 6 Xiuyan Road, Fengdu Village, Pingyao Town, Yuhang District 中国浙江省杭州市余杭区瓶窑镇凤都村秀沿路6号, " +
//                "Zhejiang 311115Hangzhou, Zhejiang 311115;CN CN(CN)(CN)}{No.966-2, Changhongdong Street, Deqing Economic Development Area " +
//                "中国浙江省湖州市德清县经济开发区长虹东街966-2号, Zhejiang 313299Huzhou, Zhejiang 313299;CN CN(CN)(CN)}";
//        System.out.println("过滤出汉字：" + str.replaceAll("\\s*","").replaceAll("[^(\\u4e00-\\u9fa5)+\\.*(\\u4e00-\\u9fa5)+$]",""));
//        System.out.println("过滤出汉字：" + str.replaceAll("\\s*","").matches("[\\u4e00-\\u9fa5]+[0-9-]+[\\u4e00-\\u9fa5]"));

        String str = "{ZHAN, Zhaoxin 江苏省常州市 city 江苏省无锡市, Zhejiang 313000No.3-29, Building 2, No.48, Keyuan Road, Wuyang Street, Deqing CountyHuzhou, Zhejiang 313000;CN CN(CN)(CN)}";
        String p = "[\\u4e00-\\u9fa5]+[\\u4e00-\\u9fa50-9-（）()/]*";
        Pattern compile = Pattern.compile(p);
        Matcher matcher = compile.matcher(str);
        if (matcher.find()) {
            System.out.println("汉字：" + matcher.group());
        }
    }

    @Test
    public void test6() {
        String item = "('%s','%d','2020-07-%d 00:00:00','%d')";
        StringBuilder sql = new StringBuilder("INSERT INTO t_order(order_id,amount,payment_time,order_status) VALUES ");
        sql.append(String.format(item, UUID.randomUUID().toString().replace("-", ""),
                AR.nextInt(100000) + 1, DR.nextInt(31) + 1, OR.nextInt(3))).append(",");
        System.out.println(sql.toString());

        Integer count = null;
        System.out.println(Arrays.asList(count.toString(),"ee","eed"));
    }

}
