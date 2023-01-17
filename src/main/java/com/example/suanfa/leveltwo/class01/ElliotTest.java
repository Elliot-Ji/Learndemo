package com.example.suanfa.leveltwo.class01;

import org.junit.Test;

import java.util.Arrays;

/**
 * 排序算法练习: 时间复杂度都为O(N^2)
 * @author: Elliot Ji
 * @createDate: 2022-12-05
 **/
public class ElliotTest {
    //选择排序
    @Test
    public void test1() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length -1; i++) {
            int minIndex = i;
            for (int j = i +1; j < arr.length ; j++) {
                minIndex =  arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    //冒泡排序
    @Test
    public void test2() {
        int[] arr = {3, 4, 34, 1, 5, 6, 2, 0};
        for (int i = 0; i <= arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 -i ; j++) {
                if (arr[j] > arr[j +1] ) {
                    swap(arr,j,j +1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    @Test
    public void test3() {
        int[] arr = {3, 4, 34, 1, 5, 6, 2, 0};
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i -1; j >=0 && arr[j] > arr[j + 1] ; j--) {
                swap1(arr,j,j + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr,int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void swap1(int[] arr,int i,int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
