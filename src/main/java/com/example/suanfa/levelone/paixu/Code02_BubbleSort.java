package com.example.suanfa.levelone.paixu;

/**
 * 冒泡排序:
 *         1.第一个数和第二数比大小,大的交换位置,放到第二位
 *         2.第二个数和第三个数比大小......
 *         3. ........ 0 ~ N-1 : 第一个数和第二数比大小,大的交换位置,放到第二位.....
 *                     0 ~ N-2 : 第一个数和第二数比大小,大的交换位置,放到第二位.....
 *                     0 ~ N-3 : 第一个数和第二数比大小,大的交换位置,放到第二位.....
 *                     0 ~ end : 第一个数和第二数比大小,大的交换位置,放到第二位.....
 * @author: Elliot Ji
 * @createDate: 2022-03-09
 **/
public class Code02_BubbleSort {
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
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        int N = arr.length;
        for (int end = N -1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second -1] > arr[second]) {
                    swap(arr,second-1,second);
                }
            }
        }
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
        bubbleSort(arr);
        print(arr);
    }

}
