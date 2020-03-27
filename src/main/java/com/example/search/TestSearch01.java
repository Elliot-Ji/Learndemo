package com.example.search;

import static java.util.Arrays.binarySearch;

/**
 * 二分查找
 * Created by Elliot Ji on 2019/6/13.
 */
public class TestSearch01 {

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8,9,10};
        int key = 12;
        int index = binarySearch(array, key);

        if(index == -1){
            System.out.println("不存在");
        }else{
            System.out.println(key + "的索引是:"+index);
        }


    }

    /**
     * 不使用递归
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array,int key){
        int low = 0;
        int high = array.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(key == array[mid]){
                return mid;
            }else if(key<array[mid]){
                high = mid-1;
            }else if(key>array[mid]){
                low = mid+1;
            }
        }
        return -1;
    }

}
