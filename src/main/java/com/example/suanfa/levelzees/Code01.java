package com.example.suanfa.levelzees;

/**
 *题目1：绳子覆盖最多的点数
 * @author: Elliot Ji
 * @createDate: 2023-03-28
 **/
public class Code01 {

    //方法1： 二分 +
    public static int maxPoint1(int[] arr,int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr,i,arr[i] -L);
            res = Math.max(res,i - nearest + 1);
        }
        return res;
    }

    /**
     *
     * @param arr
     * @param R
     * @param value
     * @return
     */
    public static int nearestIndex(int[] arr,int R,int value) {
        int L = 0;
        int index = R;
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

    //方法2：
    public static int maxPoint2(int[] arr,int L) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (left < N) {
            while (right < N && arr[right] -arr[left] <= L) {
                right++;
            }
            max = Math.max(max,right - (left++));
        }
        return max;
    }

}
