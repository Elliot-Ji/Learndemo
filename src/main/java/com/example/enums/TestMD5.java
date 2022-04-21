package com.example.enums;

import java.math.BigDecimal;

/**
 * @author: Elliot Ji
 * @createDate: 2022-04-12
 **/
public class TestMD5 {

    public static void main(String[] args) {
//        String key = "n9QMTNAr7dD8dEN8dxQKJg==";
//        String appid = "20220408001";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String time = sdf.format(new Date());
//        String data = key + appid + time;
//        String encrypt = DigestUtils.md5Hex(data);
//        System.out.println(time);
//        System.out.println(encrypt);

        String yuan = "1500000";
        BigDecimal decimal = new BigDecimal(yuan);
        BigDecimal divide = decimal.divide(new BigDecimal("10000"));
        System.out.println(divide);
        System.out.println(divide.toEngineeringString());

    }

}
