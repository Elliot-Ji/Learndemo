package com.example.suanfa.levelthree;

/**
 * 题目：
 *    给定一个数组，求如果排序之后，相邻两数的最大差值。要求时间复杂度O（N）,且要求不能用非基于比较的排序
 * 分析：
 *    1.0 根据数组有多少个数（N个数），等分成 N + 1个桶
 *    1.先遍历一遍找出最大值和最小值，如果相等则返回，不等，则等分
 *    2.再遍历一遍数组，将每个数放到对应的桶内
 *    3.观察得出，只需要比较每个桶之间的最大值，最小值的比较，而不需要考虑桶内之间的比较
 *    理解空桶存在的意义： 排除计算桶内的数的比较（利用一个平凡解，排除大部分不可能得答案即非必要的计算步骤）
 *
 * @author Elliot Ji
 * @date 2023/8/1
 */
public class Code04 {
     public static int maxGap(int[] nums) {
         if (nums == null || nums.length < 2) {
             return 0;
         }
         int len = nums.length;
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         for (int j : nums) {
             min = Math.min(min, j);
             max = Math.max(max, j);
         }
         if (min == max) {
             return 0;
         }
         boolean[] hasNum = new boolean[len + 1];//hasNum[i] i号桶是否进来过数字
         int[] maxs = new int[len + 1];//maxs[i] i号桶收集所有的数字的最大值
         int[] mins = new int[len + 1];//mins[i] i号桶收集所有的数字的最小值
         int bid = 0;//桶号
         for (int i = 0; i < len; i++) {
             bid = bucket(nums[i], len, min, max);//决定进几号桶
             mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
             maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
             hasNum[bid] = true;
         }
         int res = 0;
         int lastMax = maxs[0];//上一个非空桶的最大值
         int i = 1;
         for (; i <= len ; i++) {
             if (hasNum[i]) {
                 res = Math.max(res,mins[i] - lastMax);
                 lastMax = maxs[i];
             }
         }
         return res;
     }

    private static int bucket(long num, long len, long min, long max) {
         return (int)((num -min) * len / (max -min));
    }

    public static void main(String[] args) {
        System.out.println("开始：" + System.currentTimeMillis());
        int[] arr = new int[]{3,45,65,43,32,11,67,655,74534,345,234,1231,65453,234,6546,41234,2345};
        int i = maxGap(arr);
        System.out.println(i);
        System.out.println("结束：" + System.currentTimeMillis());
    }

}
