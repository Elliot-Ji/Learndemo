package com.example.suanfa.dataStructure.linkedList;

import java.util.Stack;

/**
 * 自定义单链表数据结构
 * Created by Elliot Ji on 2019/12/3.
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {


    }

}

//定义SingleLinkedList,来管理HeroNode对象
class SingleLinkedList{
    //先初始化一个头节点, 斗节点不要动,不存放具体的数据
    private final HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表中
     * 思路:
     * 1.先找到当前链表的最后节点,不考虑顺序
     * 2.将最后一个节点的next, 指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        //因为head节点不能动,因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        //遍历链表,找到最后
        while(true){
            if(temp.next == null){
                break; //找到链表的最后
            }
            //不是最后,则将temp后移
            temp = temp.next;
        }
        //退出循环后,temp就指向了链表最后
        //将最后的节点的next,指向新的节点
        temp.next = heroNode;
    }

    /**
     * 有序添加节点
     * 1.先找到要添加的位置节点(通过遍历查找)
     * 2.利用辅助变量插入数据
     * 3.编号如果相同,则不能再添加
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){//说明temp已经在链表最后
                break;
            }
            if(temp.next.no > heroNode.no){//位置找到就在temp后面插入
                break;
            }else if(temp.next.no == heroNode.no){//说明希望添加的节点编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移,遍历链表
        }
        //判断flag的值
        if(flag){//不能添加,说明编号已经存在
            System.out.printf("准备插入的英雄编号%d 已经存在,不能加入\n",heroNode.no);
        }else{
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点信息
     */
    public void update(HeroNode heroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;//已经遍历完链表
            }
            if(temp.no == heroNode.no){
                flag = true;//找到了
                break;
            }
            temp = temp.next;
        }
        //根据flag,判断是否找到需要修改的节点
        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else{//没有找到
            System.out.printf("没有找到编号 %d 的节点,不能修改\n",heroNode.no);
        }
    }

    /**
     * 删除节点
     */
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;//找到了
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的节点 %d 不存在\n",no);
        }
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            //已经遍历完链表
            if(temp == null){
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    /**
     * 需求:获取单链表的节点的个数(如果带头节点,则不统计头节点)
     * @param head
     * @return
     */
    public static int getLength(HeroNode head){
        if(head.next == null){//空链表
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 需求:查找单链表中倒数第k个节点的信息
     * 1.获取单链表的节点个数size,
     * 2.开始遍历,知道第(size-k)个节点;
     */
    public static HeroNode getLastIndexNode(HeroNode head,int index){
        if(head.next == null){
            return null;
        }

        int size = getLength(head);
        if(index <= 0 && index > size){
            return null;
        }
        HeroNode cur = head.next;
        for(int i = 0;i<size-index;i++){
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 需求:单链表的反转
     */
    public static void reversetList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return ;//当前只有一个节点或链表为空
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while(cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 需求:从尾到头打印单链表
     * 方式1: 利用栈这个数据结构,特点:先进后出,可以实现逆序打印的效果
     */
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        //压栈(遍历链表,将所有节点存入栈中)
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        //出栈
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}


//定义一个节点,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}


