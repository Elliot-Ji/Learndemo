package com.example.pattern.builder.improve;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-17
 **/
public class HouseClient {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.construcHouse();
        System.out.println(house);
    }
}
