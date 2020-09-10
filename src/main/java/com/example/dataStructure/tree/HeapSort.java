package com.example.dataStructure.tree;

import java.util.Arrays;

/**
 * 堆排序:利用堆排序实现数组的有序排序
 * 堆排序的速度非常快, 8百万的数据3,4,5秒排序结束
 */
public class HeapSort {

    public static void main(String[] args) {
         int arr[] = {4,6,5,8,9};
         heapSort(arr);
    }

    //一个堆排序的方法
    public static void heapSort(int arr[]){
        int temp = 0;
        //将无序数组变成了大顶堆
        for(int i = arr.length/2 -1;i >= 0;i--){
            adjustHeap(arr,i,arr.length);
        }

        //将堆顶值和堆尾值互换
        for(int j = arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }

        System.out.println("排序后的数组=" + Arrays.toString(arr));
    }

    //将一个数组(二叉树),调整成一个大顶堆

    /**
     *
     * @param arr 待调整的数组
     * @param i  非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整,length是逐渐减少的
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i]; //非叶子节点的值,i是非叶子节点的索引
        //找到i非叶子节点的左右节点,进行循环遍历,找到最大值和i非叶子节点的值进行交换
        for(int k = 2*i+1;k<length;k = 2*k+1){ //此时的k是i节点的左子节点
            if(k+1<length && arr[k]<arr[k+1]){ //说明左子节点小于右子节点
                k++; //此时k指向i的右子节点
            }
            if(arr[k]>temp){
                arr[i] = arr[k];
                i = k; //i指向k,继续循环比较
            }else{
                break;
            }
        }
        //for循环结束后,已经将i为父节点的树的最大值,放到了最顶(局部)
        arr[i] = temp;//将之前的值放到调整后的位置

    }


}
