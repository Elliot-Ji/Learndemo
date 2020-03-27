package com.example.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by Elliot Ji on 2018/10/18.
 */
public class MyTimer {
    public static void main(String[] args) {
        //1.创建一个Timer 实例
        Timer timer = new Timer();

        //2.创建一个mytimertask实例
        MyTimerTask myTimerTask = new MyTimerTask("No.1");

        //3.通过timer定时定频率调用mytimertask的业务逻辑
       // timer.schedule(myTimerTask,2000l,1000l);

        /**
         * schedule函数的四种用法
         * */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(calendar.getTime()));
        calendar.add(Calendar.SECOND,3);
        //用法1:
//        myTimerTask.setName("schedule1");
//        timer.schedule(myTimerTask,calendar.getTime());

        //用法2:
       // myTimerTask.setName("schedule2");
        //timer.schedule(myTimerTask,calendar.getTime(),2000);

        //用法3:
        //myTimerTask.setName("schedule3");
        //timer.schedule(myTimerTask, 2000L);

        //用法4:
        //myTimerTask.setName("schedule4");
        //timer.schedule(myTimerTask,2000L,1000L);

        //timer.scheduleAtFixedRate()函数的两种用法
        /**
         * 用法1:
         * */
        //myTimerTask.setName("scheduleAtFixedRate1");
        //timer.scheduleAtFixedRate(myTimerTask,calendar.getTime(),2000);

        /**
         * 用法2:
         * */
//        myTimerTask.setName("scheduleAtFixedRate2");
//        timer.scheduleAtFixedRate(myTimerTask,2000L,1000L);

    }
}
