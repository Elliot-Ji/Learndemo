package com.example.concurrent.second.chapter5;
/**
 * 单线程执行设计模式
 * Created by Elliot Ji on 2019/10/31.
 * 共享资源
 */
public class Gate {
    private int counter;
    private String name;
    private String address;

    /**
     * 临界值
     * @param name
     * @param address
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        /**
         * 多个线程一起争抢该值
         */
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("###############BROKEN###########" + toString());
        }
    }

    public String toString() {
        return "No. " + counter + ": " + name + ", " + address;
    }
}
