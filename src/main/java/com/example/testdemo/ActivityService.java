package com.example.testdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Elliot Ji
 * @createDate: 2023-04-24
 **/
@Service
public class ActivityService {
    @Autowired
    private ActivityStrategyService activityStrategyService;

    @FunctionalInterface
    interface ActivityFunction<A>{
        String dealActivity();
    }

    private final Map<Integer, ActivityFunction> strategyMap = new HashMap<>();

    @PostConstruct
    public void initDispatcher(){
        strategyMap.put(1,()->activityStrategyService.dealSpringActivity());
        strategyMap.put(2, ()-> activityStrategyService.dealSummerActivity());
        strategyMap.put(3, ()-> activityStrategyService.dealAutumnActivity());
        strategyMap.put(4, ()-> activityStrategyService.dealWinterActivity());
    }

    public String dealActivity(Integer code){
        ActivityFunction<Integer> function = strategyMap.get(code);
        //这里防止活动编号没匹配上，可以使用断言来判断从而抛出统一异常
        return function.dealActivity();
    }

}
