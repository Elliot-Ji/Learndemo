package com.example.suanfa.levelone;

/**
 * 对数器
 * @author: Elliot Ji
 * @createDate: 2022-03-14
 **/
public class Code03_Comp {

    public static void main(String[] args) {

    }

    //返回一个数组arr,arr长度[0,maxLenovo-1],arr中的每个值为[0 ,maxValue-1]
    public static int[] lenRandomValueRandom(int maxLen,int maxValue) {
        int len = (int)(Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    //copy数组
    public static int[] copyArr(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    //验证数组是否从小到大的排序
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max,arr[i]);
        }
        return true;
    }

    //验证两个数组是否都是一样的
    public static boolean equalValues(int[] arr1,int[] arr2) {
        for (int i = 0; i< arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
