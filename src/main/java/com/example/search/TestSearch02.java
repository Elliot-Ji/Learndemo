package com.example.search;

/**
 * 二分查找
 * Created by Elliot Ji on 2019/6/13.
 */
public class TestSearch02 {

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8,9,10};
        int key = 13;
        int index = binarySearch(array, key);

        if(index == -1){
            System.out.println("不存在");
        }else{
            System.out.println(key + "的索引是:"+index);
        }


    }

    /**
     * 使用递归
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array,int key){
        int low = 0;
        int high = array.length-1;
        return binarySearch(array,key,low,high);
    }

    public static int binarySearch(int[] array,int key,int low, int high) {
        //递归结束条件
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == array[mid]) {
            return mid;
        } else if (key < array[mid]) {
            return binarySearch(array, key, low, mid - 1);
        } else{
            return binarySearch(array, key, mid + 1, high);
        }
     }


}
