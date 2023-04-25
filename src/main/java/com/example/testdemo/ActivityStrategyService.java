package com.example.testdemo;

import org.springframework.stereotype.Service;

/**
 * @author: Elliot Ji
 * @createDate: 2023-04-24
 **/
@Service
public class ActivityStrategyService {
    public String dealSpringActivity(){
        return "春季活动逻辑";
    }

    public String dealSummerActivity() {
        return "夏季活动逻辑";
    }

    public String dealAutumnActivity() {
        return "秋季活动逻辑";
    }

    public String dealWinterActivity() {
        return "冬季活动逻辑";
    }
}
