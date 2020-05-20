package com.example.concurrent.third.atomic;

/**
 * @author Elliot Ji
 * @date 2020/5/13.
 */
public class JITTest {
    private static boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                while(!init){
                    System.out.println("###");
                }
            }
        }.start();

        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                init = true;
                System.out.println("set init to true...");
            }
        }.start();
    }

}
