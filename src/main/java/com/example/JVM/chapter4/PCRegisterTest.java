package com.example.JVM.chapter4;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Elliot Ji
 * @date 2024/11/19
 */
public class PCRegisterTest {

    public static void main(String[] args) {
//        String date1 = "2024-12-23";
//        LocalDateTime now = LocalDateTime.now();
//        now = now.minus(30, ChronoUnit.DAYS);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String date2 = now.format(formatter);
//        System.out.println(now.format(formatter));
//
//        boolean f = false;
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date dt1 = df.parse(date1);
//            Date dt2 = df.parse(date2);
//            if (dt1.getTime() >= dt2.getTime()) {
//                f = true;
//            }
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("f:" + f);

        int currentYear = Year.now().getValue();
        String publicDate = (currentYear - 4) + "-01-01";
        System.out.println(publicDate);

        String regionCode = "CN1103";

//        List<String> list = Arrays.asList("CN1101", "CN3101", "CN5001", "CN1201");
//        if (StringUtils.isNotEmpty(regionCode) && list.contains(regionCode)) {
//            regionCode = regionCode.substring(0,4);
//        }
        System.out.println(regionCode.substring(0,4));



    }



}
