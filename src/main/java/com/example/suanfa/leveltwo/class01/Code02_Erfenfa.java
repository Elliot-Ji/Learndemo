package com.example.suanfa.leveltwo.class01;

/**
 * 二分法:
 * @author: Elliot Ji
 * @createDate: 2022-12-29
 **/
public class Code02_Erfenfa {

    //问题1: 一个有效数组,找某个数是否存在
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length -1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R-L) >> 1);// mid = (L + R) / 2  此写法存在溢出的风险
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid -1;
            }else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    //问题2:一个有序数组,找到>=某个数的最左侧位置
    public static int nearestIndex(int[] arr,int value) {
        int L = 0;
        int R = arr.length -1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid -1;
            }else {
                L = mid + 1;
            }
        }
        return index;
    }

    //问题3: 局部最小值问题: 条件:无序数组,任意两个相邻的数不相等
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length -1] < arr[arr.length -2]) {
            return arr.length -1;
        }
        int left = 1;
        int right = arr.length -2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid -1]) {
                right = mid -1;
            }else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }





}
