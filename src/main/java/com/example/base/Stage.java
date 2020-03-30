package com.example.base;



/**
 * Created by Elliot Ji on 2018/10/12.
 * 舞台类
 */
public class Stage extends Thread {

    public void run(){
        System.out.println("欢迎收看隋唐演义!");
        //观众安静,等待开始
        try {
            //sleep()方法使得当前线程等待比如5s之后,再往下执行
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋朝末年,战火纷飞...");

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable接口创建军队线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农名起义军");

        //启动线程,让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣,半路杀出个程咬金");

        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");

        System.out.println("程咬金的理想就是结束战争,天下太平!");

        //军队停止作战
        //即停止线程
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 关键人物启动
         * */
        mrCheng.start();

        //所有线程等待程咬金完成任务
        //join()方法,某一线程调用该方法时,其它线程等待该线程执行结束后再往下进行.
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束!");

    }


    public static void main(String[] args) {
        new Stage().start();
    }
}
