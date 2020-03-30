package com.example.enums;

import com.example.enums.ClorEnum;

import static com.example.enums.ClorEnum.GREEN;


/**
 * Created by Elliot Ji on 2018/9/19.
 */
public class TestEnum {

    public static void main(String[] args) {
        ClorEnum clorEnumRed = ClorEnum.RED;
        ClorEnum clorEnumBlack = ClorEnum.BLACK;

        ClorEnum clorEnumTue = ClorEnum.Tue;
        ClorEnum clorEnumFri = ClorEnum.Fri;
        ClorEnum clorEnumSat = ClorEnum.Sat;

        System.out.println(ClorEnum.inforPrint());
        System.out.println(clorEnumTue.helloEnum());
        System.out.println(clorEnumFri.helloEnum());
        System.out.println(clorEnumFri.isWork());
        System.out.println(clorEnumSat.isWork());

          System.out.println(GREEN);

        System.out.println(clorEnumRed);
        System.out.println(clorEnumBlack);
        System.out.println(clorEnumBlack.toString());
        System.out.println(clorEnumRed.name());
        System.out.println(clorEnumBlack.ordinal());
        System.out.println(clorEnumRed.getDeclaringClass());
        System.out.println(clorEnumBlack.equals(clorEnumRed));
        System.out.println(clorEnumBlack.compareTo(clorEnumRed));



    }
}
