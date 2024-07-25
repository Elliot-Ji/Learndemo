package com.example.suanfa.heimasuanfa.jichujiegou;

/**
 * 二分查找
 * @author Elliot Ji
 * @date 2024/02/20
 */
public class BinarySearch {

    /**
      * 前提： 此时的数组是有序数组（从小到大排序）
      * 1.0：二分查找基础版   把i,j作为边界查找参数
      * 问题：
     *      1.为啥是i <= j ,而不是 i < j ?
     *      2. (i + j) / 2 有没有问题 ?
     *            java中，二进制会把最高位视为符号位
     *            >>> 无符号右移1位
     *      3.判断条件为啥都写成 < ? 由于数组是升序，基于代码习惯编写
      */
    public static int binarySearchBasic(int[] a,int target) {
        int i = 0,j = a.length -1;
        while (i <= j) {
            //int m = (i + j) / 2;
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            }else if (a[m] < target) {
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    /**
      :2.0：二分查找改动版  i作为边界查找参数，把j不作为边界查找参数
      *
      */
    public static int binarySearchAlternative(int[] a,int target) {
        int i = 0,j = a.length; //变化1
        while (i < j) {  //变化2  如果i = j时，会出现死循环（当target不在数组中）
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m; //变化3
            }else if (a[m] < target) {
                i = m + 1;
            }else {
                return m;
            }
        }

        return -1;
    }

}































