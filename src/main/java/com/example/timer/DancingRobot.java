package com.example.timer;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * Created by Elliot Ji on 2018/10/18.
 */
public class DancingRobot extends TimerTask {
    @Override
    public void run() {
        //获取最近的一次任务执行的时间,并格式化
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current exec time is :"+sf.format(scheduledExecutionTime()));
        System.out.println("Dancing Happily!!!");
    }
}
