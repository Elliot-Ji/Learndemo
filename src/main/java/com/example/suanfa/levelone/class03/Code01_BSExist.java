package com.example.suanfa.levelone.class03;

import java.util.Arrays;

/**
 * 二分法:
 * Q1: 有序数组中找到num
 * Q2: 有序数组中找到 >= num 最左的位置
 * Q3: 有序数组中找到 <= num 最右的位置
 * Q4: 局部最小值问题: 无序数组, i比左边小,比右边小
 *
 * @author: Elliot Ji
 * @createDate: 2022-03-25
 **/
public class Code01_BSExist {

    // Q1: arr 保证有序
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    //Q2:
    public static int mostLeftNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    //每个方法,可以用对数器测试该方法是否正确
    //Q1对数器
    public static boolean testQ1(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            return true;
        }
        return false;
    }

    //Q2 对数器
    public static int testQ2(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    //生成随机数组
    public static int[] generatedRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generatedRandomArray(maxSize,maxValue);
            Arrays.sort(arr);
            int value = (int)((maxValue +1) * Math.random()) - (int)(maxValue * Math.random());
            if (testQ2(arr,value) != mostLeftNumIndex(arr,value)) {
                System.out.println(value);
                System.out.println(testQ2(arr,value));
                System.out.println(mostLeftNumIndex(arr,value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fail!");
    }
}
