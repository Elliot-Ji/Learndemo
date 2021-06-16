package com.example.pattern.observer;

/**
 * 观察者模式 即多对一的关系,
 * @author: Elliot Ji
 * @createDate: 2021-06-10
 **/
public interface Subject {

    void registryObserver(Observer o);

    void removewObserver(Observer o);

    void notifyObservers();


}
