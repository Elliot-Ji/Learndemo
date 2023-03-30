package com.example.suanfa.leveltwo.class02;

/**
 * 快排:荷兰国旗问题 :  时间复制度O(N * logN)
 *    方式一:  [<= x | >x]-->递归-->实现了快排1.0
 *    方式二: 选数组中最右侧的一个数,实现划分,-->左侧和右侧再递归-->快排2.0
 *    方式三: 从数组中随机选一个数,放到数组最右侧位置,再划分,递归-->快排3.0
 * @author: Elliot Ji
 * @createDate: 2023-02-22
 **/
public class Code04_QuickSort {

    public static int[] netherlandsFlag(int[] arr,int L,int R) {
        if (L > R) {
            return new int[] {-1,-1};
        }
        if (L == R) {
            return new int[] {L,R};
        }
        int less = L - 1; //< 区 右边界
        int more = R; // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            }else if (arr[index] < arr[R]) {
                swap(arr,index++,++less);
            }else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more,R);
        return  new int[] {less + 1,more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //快排3.0非递归版本,使用栈,Stack

}































