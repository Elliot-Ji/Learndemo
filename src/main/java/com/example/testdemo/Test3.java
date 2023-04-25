package com.example.testdemo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Elliot Ji
 * @createDate: 2023-01-30
 **/
public class Test3 {
    @Test
    public void test1(){
        String queryFormat = "{\n" +
                "    \"nested\": {\n" +
                "      \"path\": \"inn_info\",\n" +
                "      \"query\": {\n" +
                "        \"query_string\": {\n" +
                "          \"query\": \"inn_info.inn_id:%s\"\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }";
        //System.out.println(String.format(queryFormat,"jjjjjjjj"));

        String s = "{\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"must\": [\n" +
                "        {\"query_string\": {\n" +
                "          \"fields\": [\"name\",\"an\",\"re_cd\",\"re_dn1\",\"re_dn2\",\"re_dn3\",\"re_dn4\",\"agent_name\"],\n" +
                "          \"query\": \"type:J AND ic:5\"\n" +
                "        }}\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"size\": 10,\n" +
                "  \"from\": 10\n" +
                "}";
        //System.out.println(s);
        HashMap map = JSON.parseObject(s, HashMap.class);
        Object query = map.get("query");

        System.out.println(map);
        System.out.println(query);
    }

    @Test
    public void test2(){
        List<String> strings = Arrays.asList("江苏", "养大", "江苏的", "盐都的", "党的纪律", "德吉");
        if (strings.size() > 4 ) {
            strings = strings.stream().limit(4).collect(Collectors.toList());
        }
        strings.forEach(x -> {
            System.out.println(x);
        });
    }

    @Test
    public void test3(){
        String lsdMaxValue = "-Infill";
        try {
            LocalDate parse = LocalDate.parse(lsdMaxValue, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("dddd");
        }catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("zoubuz");
    }

    @Test
    public void test4(){
        Test4 test4 = new Test4();
        System.out.println(test4);
    }

}
