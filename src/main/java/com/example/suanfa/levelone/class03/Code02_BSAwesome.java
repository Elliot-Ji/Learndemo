package com.example.suanfa.levelone.class03;

/**
 * 二分法:
 *      Q4: 局部最小值问题: 无序数组, i比左边小,比右边小
 * @author: Elliot Ji
 * @createDate: 2022-03-26
 **/
public class Code02_BSAwesome {

    //Q4: 前置条件: arr 整体无序
    //             arr 相邻的数不相等
    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N-1] < arr[N-2]) {
            return N-1;
        }
        int L = 0;
        int R = N -1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid -1] && arr[mid] < arr[mid + 1]) {
               return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {//中间的比左边的大,则二分左边的,舍弃右边的
                    R = mid - 1;
                }else { //中间的比右边的大,则二分右边的,舍弃左边的
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    //随机生成数组:满足相邻两个数不相等
    public static int[] randomArray(int maxLen,int maxValue) {
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int)(Math.random() * maxValue);
            for (int i = 1; i < len;i++) {
                do {
                    arr[i] = (int)(Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    //验证
    public static boolean check(int[] arr,int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    //打印数组
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 20;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen,maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr,ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("Nice!");

    }


}
