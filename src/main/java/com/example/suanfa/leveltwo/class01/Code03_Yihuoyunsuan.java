package com.example.suanfa.leveltwo.class01;

import java.util.HashMap;

/**
 * 异或运算: 无进位相加
 *
 * @author: Elliot Ji
 * @createDate: 2022-12-29
 **/
public class Code03_Yihuoyunsuan {
    //问题1: 两个数交换位置,不使用额外变量
    public static void exchange(int a ,int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ": " + b);
    }

    //问题2: 一个数组中一个数出现了奇数次,其他数都出现偶数次,怎么找到这个数
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    //问题3: 怎么把一个int类型的数,提取出最右侧的1来
    public static void num2(int a) {
        a = a & ((~a) + 1); //a & (-a)
        System.out.println(a);
    }

    //问题4: 一个数组中有两种数出现了奇数次,其他数都出现了偶数次,怎么找到那两个数
    public static void printOddTimesNum2(int[] arr) {
         int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }//所有的数异或之后,eor必然有一个位置上是1,且 eor != 0

        int rightOne = eor & (~eor + 1);//提取出最右的1;

        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    //问题5: 一个数组中有一种数出现了K次,其他数都出现了M次,M > 1 且 K < M
    //      找到这个出现K次的数,要求额外空间复杂度O(1)
    public static int onlyKTimesNumKM(int[] arr,int k ,int m) {
        //思路: 步骤1.变量 int[] t 为32位的一个数组,表示一个int整型的二进制数
        //        数组中的每一个数(转成二进制),每个位置出现1的累加到上面的变量数组中
        //步骤2. 判断int[]变量的每一位能否被M整除(是否是M的整数倍),
        int[] t = new int[32];
        for (int num : arr) {//t[i] i位置上的1出现了几次
            for (int i = 0; i <= 31 ; i++) {
                t[i] += (num >> i) & 1;//等于下面的写法
//                if (((num >> i) & 1) != 0) {
//                    t[i]++;
//                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {//在第i位上有1
                ans |= (1 << i);
            }
        }
        return ans;
    }

    //第五问题的基本解法
    public static int testQuestion5(int[] arr,int k,int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) +1);
            }else {
                map.put(num,1);
            }
        }
        for(int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    public static int[] randomArray(int maxLen,int range,int k,int m){
        return null;
    }

    public static void main(String[] args) {
        int len = 100;
        int range = 200;
        int testTime = 100000;
        int max = 9;
        for (int i = 0; i < testTime; i++) {
            int a = (int)(Math.random() * max) + 1;//1~9
            int b = (int)(Math.random() * max) + 1;
            int k = Math.min(a,b);
            int m = Math.max(a,b);
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(len,range,k,m);
            int ans1 = testQuestion5(arr,k,m);
            int ans2 = onlyKTimesNumKM(arr,k,m);
            if (ans1 != ans2) {
                System.out.println("error !");
            }
        }
    }

}
