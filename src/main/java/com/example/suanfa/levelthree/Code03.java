package com.example.suanfa.levelthree;

import java.util.HashMap;

/**
 * 题目3：leetcode 494
 *        给定一个数组arr,你可以你在每个数字之前决定+ 或者 -，但是必须所有数字都参与
 *       再给定一个数target，请问最后算出target的方法数是多少？
 *
 * @author Elliot Ji
 * @date 2023/5/4
 */
public class Code03 {

    /**
     * 方法1：动态规划
     * @param arr
     * @param s
     * @return
     */
   public static int findTargetSum1(int[] arr,int s) {
       return process1(arr,0,s);
   }

   //
   public static int process1(int[] arr,int index,int rest) {
       if (index == arr.length) {
           return rest == 0 ? 1 : 0;
       }
       return process1(arr,index + 1,rest - arr[index]) + process1(arr,index + 1,rest + arr[index]);
   }

    /**
     * 方法2；加了缓存
     * @param arr
     * @param s
     * @return
     */
   public static int findTargetSum2(int[] arr,int s) {
       return process2(arr,0,s,new HashMap<>());
   }

    public static int process2(int[] arr, int index, int rest, HashMap<Integer, HashMap<Integer,Integer>> dp) {
       if (dp.containsKey(index) && dp.get(index).containsKey(rest)) {
           return dp.get(index).get(rest);
       }
       int ans = 0;
       if (index == arr.length) {
           ans = rest == 0 ? 1 : 0;
       }else {
           ans = process2(arr,index + 1,rest - arr[index],dp) + process2(arr,index + 1,rest + arr[index],dp);
       }
       if (!dp.containsKey(index)) {
           dp.put(index,new HashMap<>());
       }
       dp.get(index).put(rest,ans);
       return ans;
    }

    /**
     * 优化方法：1.把所有数组先转成非负数
     *         2.然后把所有数累加和，如果target > sum 则没有结果
     *         3.所有数的累加和 sum 的奇偶性与target的奇偶性对比
     */
}
























