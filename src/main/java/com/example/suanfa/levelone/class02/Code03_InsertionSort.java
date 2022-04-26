package com.example.suanfa.levelone.class02;

/**
 * 插入排序: 类似斗地主抓牌时,手上的拍已经排好序,摸下一张牌,按顺序插入手中
 *        1. 0~0: 排好序
 *        2. 0~1 : 将1跟前面的比价,小的就交换到前面
 *        3. 0~~2 : 将2跟前面的比较,小的就交换到前面
 *        4. 0~n-1: ....
 * @author: Elliot Ji
 * @createDate: 2022-03-09
 **/
public class Code03_InsertionSort {
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
     * 插入排序1
     * @param arr
     */
    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        // 0~0 完成排序
        // 0~1
        // 0~2
        // 0~3
        // 0~n-1
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr,newNumIndex - 1,newNumIndex);
                newNumIndex --;
            }
        }
    }

    /**
     * 插入排序2
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            //pre为新数下标的前一个位置下标
            for (int pre = end -1; pre >=0 && arr[pre] > arr[pre +1]; pre--) {
                swap(arr,pre,pre+1);
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
        insertSort2(arr);
        print(arr);
    }
}
