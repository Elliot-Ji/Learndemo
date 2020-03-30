package com.example.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by Elliot Ji on 2018/10/18.
 */
public class Executor {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time is:"+sf.format(calendar.getTime()));

        DancingRobot dr = new DancingRobot();
        WaterRobot wt = new WaterRobot(timer);

        timer.schedule(dr,calendar.getTime(),2000);
        timer.scheduleAtFixedRate(wt,calendar.getTime(),1000);


    }
}
