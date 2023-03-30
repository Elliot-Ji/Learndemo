package com.example.suanfa.dataStructure.stack;

/**
 * 数组模拟栈
 * Created by Elliot Ji on 2020/1/14.
 */
public class ArrayStackDemo {

    public static void main(String[] args) {

    }

}
//定义一个栈
class ArrayStack{
    private final int maxSize;//栈的大小
    private final int[] stack;//数组模拟栈,数据存放在数组中
    private int top;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d \n",i,stack[i]);
        }
    }
}
