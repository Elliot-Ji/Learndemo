package com.example.concurrent.first.chapter1;

/**
 * 理解thread构造函数中的stacksize的含义
 * 理解jvm内存结构,
 * Created by Elliot Ji on 2019/7/19.
 */
public class CreateThread {

    private static int counter = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    add(1);//在执行了counter次后,造成 java.lang.StackOverflowError,栈内存溢出
                }catch (Error e){
                    System.out.println(counter);
                    e.printStackTrace();
                }
            }
            private void add(int i){
                counter++;
                add(i+1);
            }
        });

        t1.start();
    }
}
