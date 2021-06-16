package com.example.pattern.prototype;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-16
 **/
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("Shon",2,"red");
        Sheep sheep2 = (Sheep)sheep.clone();
        Sheep sheep3 = (Sheep)sheep.clone();
        Sheep sheep4 = (Sheep)sheep.clone();
        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
    }
}
