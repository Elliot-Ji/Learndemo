package com.example.pattern.observer;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-10
 **/
public class Client {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentCondition cs = new CurrentCondition();
        weatherData.registryObserver(cs);
        weatherData.setData(32.3f,130f,43f);
    }

}
