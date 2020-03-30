package com.example.collections.arrayList;

/**
 * 自定义ArrayList数组
 * Created by Elliot Ji on 2019/3/20.
 */
public class TestList<E> {

    private Object[] elementData;
    private int size;
    private final static int DEFAULT_CAPCITY = 10;

    public TestList(){
      elementData = new Object[DEFAULT_CAPCITY];
    }

    public  TestList(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
        elementData[size++] = element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        TestList<String> tl = new TestList<>();
        tl.add("a");
        tl.add("b");
        System.out.println(tl);

    }
}
