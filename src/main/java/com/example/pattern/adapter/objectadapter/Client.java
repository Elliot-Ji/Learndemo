package com.example.pattern.adapter.objectadapter;

/**
 * @author Elliot Ji
 * @date 2020/3/19.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("######对象适配器模式#########");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220()));
    }
}
