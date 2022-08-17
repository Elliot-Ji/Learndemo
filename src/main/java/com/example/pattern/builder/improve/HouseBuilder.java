package com.example.pattern.builder.improve;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-17
 **/
public abstract class HouseBuilder {

    protected House house = new House();

    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    public House buildHouse() {
        return house;
    }

}
