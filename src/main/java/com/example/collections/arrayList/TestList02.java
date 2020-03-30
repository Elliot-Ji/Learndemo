package com.example.collections.arrayList;



/**
 * 自定义ArrayList数组
 * 数组扩容
 * 增加get和set方法
 * 增加索引检查
 * 增加remove方法
 * Created by Elliot Ji on 2019/3/20.
 */
public class TestList02<E> {

    private Object[] elementData;
    private int size;
    private final static int DEFAULT_CAPCITY = 10;

    public TestList02(){
      elementData = new Object[DEFAULT_CAPCITY];
    }

    public TestList02(int capacity){
        if(capacity< 0){
            throw new RuntimeException("容量不能为负的");
        }else if(capacity ==0){
            elementData = new Object[DEFAULT_CAPCITY];
        }else{
            elementData = new Object[capacity];
        }

    }

    public void add(E element){
        //何时扩容
        if(size == elementData.length){
            //怎么扩容
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    public E get(int index){
        checkRang(index);
        return (E)elementData[index];
    }

    public void set(E element,int index){
        checkRang(index);
        elementData[index] = element;
    }

    public void remove(E element){
        for(int i =0;i<size;i++){
            if(element.equals(get(i))){
                remove(i);
            }
        }
    }

    public void remove(int index){
        //[a,b,c,d,e,f]
        //[a,b,c,e,f]
        int numMoved = elementData.length-index-1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size]=null;
    }

    private void checkRang(int index){
        //判断索引是否合法
        if(index<0 || index >size-1){
            throw new RuntimeException("索引不合法:"+index);

        }
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
        TestList02<String> tl = new TestList02<>(20);
        for(int i=0;i<40;i++){
            tl.add("季"+i);
        }
        System.out.println(tl);
        tl.set("wang",8);
        System.out.println(tl);
        System.out.println(tl.get(8));

    }
}
