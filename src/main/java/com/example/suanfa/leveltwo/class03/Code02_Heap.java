package com.example.suanfa.leveltwo.class03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆结构: 就两个操作heapInsert和heapify
 *
 * @author: Elliot Ji
 * @createDate: 2023-03-14
 **/
public class Code02_Heap {

    //堆排序: 时间复杂度O(N*logN)  6000 - 4500 = 1500 + 1000 + 3000
    public static void heapSort(int[] arr) {
        if (arr == null ||arr.length < 2) {
            return;
        }
        //将数组调整成大根堆,从上往下
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        //或者这步实现大根堆，从下往上
//        for (int i = arr.length - 1; i >= 0; i--) {
//            heapify(arr,i,arr.length);
//        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    //堆插入添加操作,不断往上移,时间复杂度:O(logN)
    private static void heapInsert(int[] arr,int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //从index位置,不断往下沉,满足大根堆条件,时间复杂度:O(logN)
    private static void heapify(int[] arr,int index,int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left +1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest :index;
            if (largest == index) {
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 +1;
        }
    }

    public static void main(String[] args) {
        //优先级队列: 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //题目1：最大线段重合问题（堆实现）
    //步骤1： 所有线段的开始位置，进行从小到大排序
    //步骤2： 依次遍历排好序的的线段，建立一个小根堆，每个线段的开始位置的值  将 <=开始位置的值,从小根堆中弹出，
    //步骤3： 将每个线段结束位置的值，放到小根堆中，然后查看下小根堆中有几个数，返回这个数，就是当前这个线段的重合数
    public static int maxCover(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        Arrays.sort(lines,new StartComparator());
        PriorityQueue<Integer> heap = new PriorityQueue<>();//小根堆
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max,heap.size());
        }
        return max;
    }

    public static class Line {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class StartComparator implements Comparator<Line> {

        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }

    public static class EndComparator implements Comparator<Line> {

        @Override
        public int compare(Line o1, Line o2) {
            return o1.end - o2.end;
        }
    }




}






































