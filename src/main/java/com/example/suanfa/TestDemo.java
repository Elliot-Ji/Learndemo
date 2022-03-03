package com.example.suanfa;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @author: Elliot Ji
 * @createDate: 2022-02-18
 **/
public class TestDemo {



    public static void main(String[] args) {

        String s = "[500 Internal Server Error] during [POST] to [http://dbcloud-service-base/user/add?userName=wang&password=test123123&nickName=wwwwwww&status=1&userType=admin] [BaseUserServiceClient#addUser(String,String,String,Integer,String,String,String,String,String)]: [{\"code\":1001,\"message\":\"用户名:wang已存在!\",\"path\":\"/user/add\",\"data\":null,\"extra\":{},\"timestamp\":\"1645765905221\"}]";
        int i = s.indexOf("{");
        int t = s.lastIndexOf("}");
        System.out.println(s.substring(i, t+1));

        String substring = s.substring(i, t + 1);

        //String ss = "{\"code\":1001,\"message\":\"用户名:wang已存在!\",\"path\":\"/user/add\",\"data\":null,\"extra\":{}}";
        Map<String,String> map
                = new Gson().fromJson(substring, Map.class);
        System.out.println(map.get("message"));

    }
}

enum UserTypeEnum {
    DEFAULT("default","默认用户"),
    JXNORMAL("jxnormal","普通用户"),
    JXEXPERT("jxexpert","专家用户");

    private String code;
    private String name;

    UserTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}

