package com.example.pattern.observer;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-10
 **/
public class CurrentCondition implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;


    @Override
    public void notifys(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("***温度: "+ temperature + "***");
        System.out.println("***气压: "+ pressure + "***");
        System.out.println("***湿度: "+ humidity + "***");
    }

}
