package com.example.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-10
 **/
public class WeatherData implements Subject {

    private float temperature;
    private float pressure;
    private float humidity;
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void datachange(){
        notifyObservers();
    }

    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        datachange();
    }

    @Override
    public void registryObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removewObserver(Observer o) {
        if(observers.contains(o)){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i<observers.size();i++){
            observers.get(i).notifys(this.temperature,this.pressure,this.humidity);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
