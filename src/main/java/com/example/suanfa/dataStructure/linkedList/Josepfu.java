package com.example.suanfa.dataStructure.linkedList;

/**
 * 约瑟夫问题-->环形单向链表来解决(类似丢手绢游戏,)
 * Created by Elliot Ji on 2020/1/14.
 */
public class Josepfu {

    public static void main(String[] args) {
          CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
          circleSingleLinkedList.addBoy(5);
          circleSingleLinkedList.showBoy();
          circleSingleLinkedList.countBoy(1,2,5);
    }

}
//构建环形的单向链表
class CircleSingleLinkedList{
    private Boy first = null;

    public void addBoy(int nums){
        if(nums < 2){
            System.out.println("输入的值不合法");
            return;
        }
        Boy curBoy = null;//辅助指针
        for(int i=1;i<=nums;i++){
            Boy boy = new Boy(i);
            if(i ==1){//第一个节点
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while(true){
            System.out.printf("节点的编号为: %d \n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 计算节点出圈的顺序
     * @param startNo 从第几个节点开始
     * @param countNo 报数
     * @param nums
     */
    public void countBoy(int startNo,int countNo,int nums){
         if(first ==null || startNo <1 ||startNo>nums){
             System.out.println("参数有误,请重新输入");
             return;
         }
         Boy helper = first;//辅助指针
         while(true){ //1.辅助指针指向该链表的最后一个节点
             if(helper.getNext() ==first){
                break;
             }
             helper = helper.getNext();
         }

         for(int j =0;j<startNo-1;j++){//2.将first和helper节点移动到指定的startNo位置处
             first = first.getNext();
             helper = helper.getNext();
         }

         while(true){//3.根据countNo,依次出圈countNo-1次,直至圈中只有一个节点
             if(first == helper){//只有一个节点
                 break;
             }
             //first和helper指针同时移动countNo-1次
             for(int j=0;j<countNo-1;j++){
                 first = first.getNext();
                 helper = helper.getNext();
             }
             System.out.printf("节点: %d 出圈 \n",first.getNo());
             //将出圈的节点移除
             first = first.getNext();
             helper.setNext(first);
         }
        System.out.printf("最后出圈的节点: %d \n",first.getNo());
    }
}

class Boy{
    private int no;//编号
    private Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
