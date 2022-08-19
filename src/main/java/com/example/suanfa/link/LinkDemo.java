package com.example.suanfa.link;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-18
 **/
public class LinkDemo {

    public static void main(String[] args) {
        Node kthFromEnd = getKthFromEnd(headNode(), 3);
        System.out.println(kthFromEnd);
    }

    //返回倒数第k个节点
    public static Node getKthFromEnd(Node head,int k) {
        if (null == head) {
            return head;
        }
        Node pro = head;
        Node after = head;
        for (int i = 0; i < k -1; i++) {
          pro = pro.next;
        }
        while(pro.next != null) {
            pro = pro.next;
            after = after.next;
        }
        return after;
    }

    //构建一个链表
    public static Node headNode() {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return head;
    }

}

class Node {
    public Integer num;
    public Node next;

    public Node(Integer num) {
        this.num = num;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", next=" + next +
                '}';
    }
}
