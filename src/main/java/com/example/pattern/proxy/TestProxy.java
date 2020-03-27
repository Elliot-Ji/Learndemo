package com.example.pattern.proxy;

/**
 *
 * Created by Elliot Ji on 2019/1/8.
 */
public class TestProxy {

    public static void main(String[] args) {
//        Moveable car = new Car2();
//        car.move();

//        Moveable car = new CarTimeProxy(new Car());
//        car.move();

        Car car = new Car();
        CarLogProxy clp = new CarLogProxy(car);
        CarTimeProxy ctp = new CarTimeProxy(clp);
        ctp.move();


    }

}
