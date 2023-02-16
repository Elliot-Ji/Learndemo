package com.example.testdemo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;

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

}
