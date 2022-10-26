package com.example.suanfa.levelone.class07;

/**
 * @author: Elliot Ji
 * @createDate: 2022-09-09
 **/
public class Code02_Heap01 {

    public static class MyMaxHeap {
        private final int[] heap;
        private final int limit;
        private final int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        //TODO: 数组,每放一个数,生成大根堆
        public void push(int value) {


        }

        //TODO: 大根堆,返回最大值,在堆中删除这个最大值,剩余的数组还是需要变成大根堆
        public int pop () {
            int ans = 1;


            return ans;
        }

        private void heapInsert(int[] arr,int index) {

        }

        private void heapify(int[] arr,int index,int heapSize) {

        }

        private void swap (int[] arr,int i,int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }


    }



}
