package com.example.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Elliot Ji
 * @createDate: 2022-02-18
 **/
public class TestDemo {



    public static void main(String[] args) {

//        String s = "[500 Internal Server Error] during [POST] to [http://dbcloud-service-base/user/add?userName=wang&password=test123123&nickName=wwwwwww&status=1&userType=admin] [BaseUserServiceClient#addUser(String,String,String,Integer,String,String,String,String,String)]: [{\"code\":1001,\"message\":\"用户名:wang已存在!\",\"path\":\"/user/add\",\"data\":null,\"extra\":{},\"timestamp\":\"1645765905221\"}]";
//        int i = s.indexOf("{");
//        int t = s.lastIndexOf("}");
//        System.out.println(s.substring(i, t+1));
//
//        String substring = s.substring(i, t + 1);
//
//        //String ss = "{\"code\":1001,\"message\":\"用户名:wang已存在!\",\"path\":\"/user/add\",\"data\":null,\"extra\":{}}";
//        Map<String,String> map
//                = new Gson().fromJson(substring, Map.class);
//        System.out.println(map.get("message"));
        String tt = "";
        List<String> objects = new ArrayList<>();
        objects.add("345dfd");
        objects.add("345dfdfdfs");
        //objects.add("adsfdsf");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < objects.size(); i ++) {
            if  (i == 0) {
                builder.append(objects.get(i));
            }else {
                builder.append(","+objects.get(i));
            }
        }
        System.out.println(builder.toString());
        String te = "0";
        System.out.println(Integer.parseInt(te) == 0);

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

