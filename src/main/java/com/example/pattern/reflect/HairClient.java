package com.example.pattern.reflect;

/**
 * Created by Elliot Ji on 2018/10/15.
 */
public class HairClient {

    public static void main(String[] args) {
        HairFactory factory  = new HairFactory();
//        LeftHair leftHair = (LeftHair) factory.getHair("left");
//        leftHair.draw();

        /**
         * 利用反射机制
         * */
        RightHair rightHair = (RightHair)factory.getHairClass("RightHair");
        rightHair.draw();

        /**
         * 将类名通过Properties文件读取
         * */
    }
}
