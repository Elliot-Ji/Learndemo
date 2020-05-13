package com.example.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义hashmap
 * 增加泛型
 * 未考虑key 为null的情况!!!!
 * Created by Elliot Ji on 2019/12/3.
 */
public class TestHashMap04<K,V> {
    Node2[] table; //位桶数组,
    int size;     //存放键值对的个数

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
    }


    public TestHashMap04() {
        table = new Node2[16]; //长度一般定义成2的整数次幂
    }

    // 1.根据key 对象的hashcode(),计算新节点的hash值;
    // 2.key,value键值对对象存放到节点对象中
    public void put(K key,V value){
        //定义一个新节点对象
       Node2 newNode = new Node2();
       newNode.hash = myHash(key.hashCode(),table.length);
       newNode.key = key;
       newNode.value = value;

       Node2 iterLast = null;//辅助变量
         boolean keyRepeat = false;
       //将新节点存放到数组中
        Node2 temp = table[newNode.hash];
        if(temp == null){
            //此处数组元素为空,则直接将新节点放进去
            table[newNode.hash] = temp;
            size++;
        }else{
            //此处数组元素不为空,则遍历链表,找到最后一个节点
            while(temp!=null){
                //判断key重复,则覆盖
                if(temp.key.equals(key)){
                    System.out.println("key重复了");
                    keyRepeat = true;
                    temp.value = value;//覆盖value值就可以了.
                    break;
                }else{
                    //key不重复,则遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if(!keyRepeat){ //key不重复,则添加到链表最后
                iterLast.next = newNode;
                size++;
            }
        }
    }

    public V get(K key){
        int hash = myHash(key.hashCode(),table.length);
        V value = null;
        if(table[hash]!= null){
           Node2 temp = table[hash];
           while(temp!=null){
               if(temp.key.equals(key)){
                   value = (V)temp.value;
                   break;
               }else{
                   temp = temp.next;
               }
           }
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder('{');
        //先遍历数组,再遍历数组对应下标中的链表
        for (int i=0;i<table.length;i++){
            Node2 temp = table[i];
            while(temp!=null){
                sb.append(temp.key+":"+temp.value);
                temp = temp.next;
            }
        }
        sb.setCharAt(table.length-1,'}');
        return sb.toString();
    }

    //计算hash值
    public static int myHash(int v,int length){
        System.out.println("hash in myhash:"+(v&(length-1))); //直接位运算,效率高
        System.out.println("hash in myhash:"+(v%(length-1))); //取模运算,效率低
        return v&(length-1);
    }


}
