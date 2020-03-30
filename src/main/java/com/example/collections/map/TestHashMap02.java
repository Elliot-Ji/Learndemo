package com.example.collections.map;

/**
 * 自定义hashmap
 * 重写toString方法,
 * Created by Elliot Ji on 2019/12/3.
 */
public class TestHashMap02 {

    Node[] table; //位桶数组,
    int size;     //存放键值对的个数

    public TestHashMap02() {
        table = new Node[16]; //长度一般定义成2的整数次幂
    }

    // 1.根据key 对象的hashcode(),计算新节点的hash值;
    // 2.key,value键值对对象存放到节点对象中
    public void put(Object key,Object value){
        //定义一个新节点对象
       Node newNode = new Node();
       newNode.hash = myHash(key.hashCode(),table.length);
       newNode.key = key;
       newNode.value = value;

       Node iterLast = null;//辅助变量
         boolean keyRepeat = false;
       //将新节点存放到数组中
        Node temp = table[newNode.hash];
        if(temp == null){
            //此处数组元素为空,则直接将新节点放进去
            table[newNode.hash] = temp;
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
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder('{');
        //先遍历数组,再遍历数组对应下标中的链表
        for (int i=0;i<table.length;i++){
            Node temp = table[i];
            while(temp!=null){
                sb.append(temp.key+":"+temp.value);
                temp = temp.next;
            }
        }
        sb.setCharAt(table.length-1,'}');
        return sb.toString();
    }

    //计算hash值
    public int myHash(int v,int length){
        System.out.println("hash in myhash:"+(v&(length-1))); //直接位运算,效率高
        System.out.println("hash in myhash:"+(v%(length-1))); //取模运算,效率低
        return v&(length-1);
    }


}
