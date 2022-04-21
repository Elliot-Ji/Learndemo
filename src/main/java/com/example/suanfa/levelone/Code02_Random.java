package com.example.suanfa.levelone;

/**
 * 随机函数的认识
 * @author: Elliot Ji
 * @createDate: 2022-03-09
 **/
public class Code02_Random {

    public static void main(String[] args) {
        //[0,1)的范围小数,每个数出现的概率都是 等概率出现的
        int testTimes = 10000000;
        int count = 0;

        //1. 统计一个数出现的概率,结果: 概率就是这个数
        for (int i = 0;i < testTimes; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }
        System.out.println((double) count /(double) testTimes);
        System.out.println("===============");

        count = 0;
        //范围: [0,8)
        double ans = Math.random() * 8;
        //2. 统计[0,8)范围内出现一个数的概率
        for (int i = 0;i < testTimes; i++) {
            if (Math.random()*8 < 4) {
                count++;
            }
        }
        System.out.println((double) count /(double) testTimes);
        System.out.println("===============");

        count = 0;
        int K = 9;
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int num = (int)(Math.random() * K);//范围: [0,K-1]个整数,每个数出现的概率都是等概率的
            counts[num]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数出现了 " + counts[i] + " 次");
        }

        System.out.println("===============");
        //3.将[0,X)范围出现的数的概率有原来的等概率变为 X的平方
        count = 0;
        double x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            if (XTOXPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count /(double) testTimes);
        System.out.println(Math.pow(x,2));
        System.out.println("===============");


        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if ( f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count /(double) testTimes);
        System.out.println("===============");

        //Question: 从1-5随机到1-7随机
        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = g();
            counts[num] ++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数出现了 " + counts[i] + " 次");
        }

    }

    //返回[0,1)的一个小数
    //任意的x,x属于[0,1),[0,X)范围出现的数的概率有原来的X(等概率)变为 X的平方
    public static double XTOXPower2(){
        return Math.max(Math.random(),Math.random());
    }

    //返回[1,5]中的一个整数的随机函数,等概率
    public static int f1(){
        return (int)(Math.random() * 5) + 1;
    }

    //随机机制,只能用f1();
    //f2函数的作用: 等概率返回0和1
    public static int f2(){
        int ans = 0;
        do{
            ans = f1();
        }while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    //等概率得到:000 ~ 111 即得到了 0~7等概率的值
    public static int f3(){
        int ans = (f2() << 2) + (f2() << 1) + (f2() << 0);
        return ans;
    }

    //等概率得到 0~6的值:
    public static int f4(){
        int ans = 0;
        do {
            ans = f3();
        }while (ans == 7);//当为7的时候就返回,重新获取
        return ans;
    }

    //等概率得到 1~7的值
    public static int g(){
        return f4() + 1;
    }
}
