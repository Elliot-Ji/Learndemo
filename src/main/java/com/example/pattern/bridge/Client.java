package com.example.pattern.bridge;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-25
 **/
public class Client {
    public static void main(String[] args) {
        Phone phone1 = new FlotePhone(new XiaoMi());
        phone1.open();

        Phone phone2 = new FlotePhone(new Vivo());
        phone2.open();

        Phone phone3 = new UpRightPhone(new XiaoMi());
        phone3.call();

        Phone phone4 = new UpRightPhone(new Vivo());
        phone4.call();
    }
}
