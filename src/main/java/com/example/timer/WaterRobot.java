package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Elliot Ji on 2018/10/18.
 */
public class WaterRobot extends TimerTask {
    private Integer bucketCapacity = 0;
    private Timer timer;

    public WaterRobot(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        //灌水直至桶满为止
        if(bucketCapacity<5){
            System.out.println("Add 1L into the bucket!");
            bucketCapacity++;
        }else{
            //水满后停止执行
            System.out.println("The number of canceled task in timer is:"+timer.purge());
            cancel();
            System.out.println("The WaterRobot has been aborted!");
            System.out.println("The number of canceled task in timer is:"+timer.purge());
            System.out.println("Current Water is:"+bucketCapacity+"L");
            //等待两秒之后,停止timer里所有的内容
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel();
        }

    }
}
