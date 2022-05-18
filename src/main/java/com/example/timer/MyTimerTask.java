package com.example.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created by Elliot Ji on 2018/10/18.
 * 定时调度工具类(jdk自带) Timer
 */

public class MyTimerTask extends TimerTask{
    private String name;
    private Integer count=0;

    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if(count<3){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Current exec time is : "+sf.format(calendar.getTime()));

            //打印当前name的内容
            System.out.println("Current exec name is "+name);
            count++;
        }else{
            cancel();
            System.out.println("Task cancel!");
        }
        //打印当前执行的时间

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
