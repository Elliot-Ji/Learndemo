package com.example.dataStructure.queue;

/**
 * 使用数组模拟 队列
 * Created by Elliot Ji on 2019/12/12.
 */
public class ArrayQueueDemo {

}

class ArrayQueue{
    private int maxSize; //数组最大容量
    private int front; //队列头
    private int rear;  //队列尾
    private int[] arr; //存放数据, 模拟队列

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
       return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列数据已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空,不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i =0;i<arr.length;i++){
            System.out.printf("add[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列头数据,
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}

















