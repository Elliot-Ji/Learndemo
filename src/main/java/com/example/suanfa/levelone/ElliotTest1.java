package com.example.suanfa.levelone;

import org.junit.Test;

/**
 * @author Elliot Ji
 * @date 2023/5/22
 */
public class ElliotTest1 {

    @Test
    public void test1() {

        int[] arr = new int[]{13, 56, 3, 4, 2, 0, 13, 43, 22};
        //maopaoSort(arr);
        //xuanzeSort(arr);
        charuSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    //maopaopaixu
    public static void maopaoSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.print(i + ":  " +j);
                if (arr[j] > arr[j + 1]) {
                    //exchange
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void xuanzeSort(int[] arr) {
        //数组判空
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length ; j++) {
               if(arr[minIndex] > arr[j]) {
                   int temp = arr[j];
                   arr[j] = arr[minIndex];
                   arr[minIndex] = temp;
               }
            }
        }
    }

    public static void charuSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int minIndex = i;
            while (minIndex - 1 >= 0 && arr[minIndex -1] > arr[minIndex]) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[minIndex -1];
                arr[minIndex -1] = temp;
                minIndex --;
            }
        }
    }

}
