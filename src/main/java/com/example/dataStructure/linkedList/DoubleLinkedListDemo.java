package com.example.dataStructure.linkedList;

/**
 * Created by Elliot Ji on 2019/12/10.
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }

}

//双向链表类
class DouvleLinkedList{
    //先初始化一个头节点, 斗节点不要动,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历双向链表
     */
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
     * 添加节点到双向链表最后
     */
    public void add(HeroNode2 heroNode){
        //因为head节点不能动,因此我们需要一个辅助变量 temp
        HeroNode2 temp = head;
        //遍历链表,找到最后
        while(true){
            if(temp.next == null){
                break; //找到链表的最后
            }
            //不是最后,则将temp后移
            temp = temp.next;
        }
        //退出循环后,temp就指向了链表最后
        //形成一个双链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 修改一个节点的内容
     */
    public void update(HeroNode2 heroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
     * 删除一个节点
     */
    public void delete(int no){
        if(head.next == null){
            System.out.println("链表为空,无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;//找到了
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            //考虑删除的是最后一个节点
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("要删除的节点 %d 不存在\n",no);
        }
    }
}

//节点类
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
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

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }
}
