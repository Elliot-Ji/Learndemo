package com.example.base;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Elliot Ji on 2018/10/12.
 */
//军队进程
//模拟作战双方的行为
public class ArmyRunnable implements Runnable {

    //volatile保证了线程可以正确的读取其他线程写入的值
    //可见性
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while(keepRunning){
           //发动5连击
            for(int i =0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
                //让出处理器时间(让出当前线程执行的cpu时间),下次谁进攻不一定
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗!");
    }
}
