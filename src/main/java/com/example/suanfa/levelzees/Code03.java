package com.example.suanfa.levelzees;

/**
 * 题目3：给定一个数组arr,你可以你在每个数字之前决定+ 或者 -，但是必须所有数字都参与
 *       再给定一个数target，请问最后算出target的方法数是多少？
 *
 * @author Elliot Ji
 * @date 2023/5/4
 */
public class Code03 {

    /**
     * 方法1：
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

}
