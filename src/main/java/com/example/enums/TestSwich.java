package com.example.enums;



/**
 * Created by Elliot Ji on 2018/9/19.
 */
public class TestSwich {

    public static void main(String[] args) {
//        String a = "2";
//        String b=a;
//        switch (b){
//            case "1":
//                System.out.println("a");
//                break;
//            case "2":
//                System.out.println("b");
//                break;
//            case "3":
//                System.out.println("c");
//                break;
//            default:
//                break;
//
//        }
//
//        System.out.println("执行输出!sss");
//        System.out.println("df中文连吗");


        A a1 = A.day();
         a1 = new A(2);
        System.out.println(a1);
    }
}

class A{
    private Integer num;
    A(Integer num){
        this.num = num;
       // System.out.println(num);
    }

    public static A day(){
        return new A(3);
    }
}
