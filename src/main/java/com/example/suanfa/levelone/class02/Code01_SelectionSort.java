package com.example.suanfa.levelone.class02;

/**
 * 排序算法:
 * 选择排序: 每一步选出数组中的最小值,按照数组下标顺序摆放
 * @author: Elliot Ji
 * @createDate: 2022-03-09
 **/
public class Code01_SelectionSort {

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr) {
         if (arr == null || arr.length <2){
             return;
         }
         int N = arr.length;
         for (int i = 0; i < N; i++) {
             int minValueIndex = i;//最小值的下标
             for (int j = i; j < N; j++) {
                 minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
             }
             swap(arr,i,minValueIndex);
         }
    }

    /**
     * 数组中两个数交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void print(int[] arr){
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 4, 22, 4, 1, 45, 6, 7, 5, 1};
        print(arr);
        selectSort(arr);
        print(arr);
    }

}
