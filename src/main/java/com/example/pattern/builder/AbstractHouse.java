package com.example.pattern.builder;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-17
 **/
public abstract class AbstractHouse {
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }

}
