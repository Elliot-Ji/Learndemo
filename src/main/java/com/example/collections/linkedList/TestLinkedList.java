package com.example.collections.linkedList;

/**
 * 自写LinkedList容器
 * Created by Elliot Ji on 2019/3/28.
 */
public class  TestLinkedList {

    private Node first;
    private Node last;
    private int size;

    public void add(Object object){
        Node node = new Node(object);

        if(first == null){
//            node.previous = null;
//            node.next = null;
            first = node;
            last = node;
        }else{
            node.previous = last ;
            node.next = null;

            last.next = node;
            last = node;
        }
    }

    public String toString(){
        Node temp = first;
        while(temp!=null){
            System.out.println(temp.object);
            temp = temp.next;
        }
        return "";
    }

    public static void main(String[] args) {
        TestLinkedList list = new TestLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
//        list.add("d");
 //       System.out.println(list);

        String s = String.format("%012d",99);
        System.out.print(s);
    }

}
