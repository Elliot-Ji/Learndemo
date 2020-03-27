package com.example.dataStructure.stack;

/**
 * 用栈实现一个表达式的计算功能
 * Created by Elliot Ji on 2020/1/15.
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "3+2*6-2";
        //创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

    }

}

class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈,数据存放在数组中
    private int top;//栈顶

    public ArrayStack2(int maxSize) {
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

    //返回运算符的优先级,由程序员自己设定优先级
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper =='-'){
            return 0;
        }else{
            return -1;//假定目前只有+ - * / 四个运算符
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//用于存放计算的结果
        switch(oper){
            case '+':
                res = num1+num2;
                break;
            case'-':
                res = num2-num1;
                break;
            case'*':
                res = num1*num2;
                break;
            case'/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}

