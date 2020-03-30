package com.example.pattern.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elliot Ji on 2018/8/2.
 */
public class Class {
      Car car = Car.getInstance();

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        List<String> list1 = list.subList(1,3);
        List<String> list2 = list.subList(1,list.size());
        System.out.println(list1);
        System.out.println(list2);
    }

}


class Car{
    //懒汉式(线程不安全)
    private static Car car;
    private  Car(){

    }
    public static Car getInstance(){
        if(car!=null){
            car = new Car();
        }
        return car;
    }
}

class CarBy{
    //懒汉式(线程安全)
    private static CarBy carBy;
    private CarBy(){}
    public  static synchronized CarBy getInstance(){
        if(carBy!=null){
            carBy = new CarBy();
        }
        return carBy;
    }
}
class Hoke{
    //饿汉式,即类加载时就实例化
    private static  Hoke hoke = new Hoke();
    private Hoke(){}
    public static Hoke getInstance(){
        return hoke;
    }

}
class Buy{
    //饿汉式(变种),也是累加载时实例化
    private static Buy instance ;
    static{
        instance = new Buy();
    }
    private Buy(){}
    public static Buy getInstance(){
        return instance;
    }
}

class Back{
    //静态内部类
    private static class BackHoder{
        private static  final  Back instance = new Back();
    }
    private Back(){}

    public  static final Back getInstance(){
        return BackHoder.instance;
    }
}













































