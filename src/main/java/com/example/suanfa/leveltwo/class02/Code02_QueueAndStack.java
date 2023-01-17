package com.example.suanfa.leveltwo.class02;

/**
 * 栈和队列: 实际是一个逻辑结构
 * 1. 利用双向链表实现
 * 2. 利用数组实现
 * @author: Elliot Ji
 * @createDate: 2023-01-04
 **/
public class Code02_QueueAndStack {

    //数组实现队列
    public static class MyQueue {
        private final int[] arr;
        private int pushi;//进
        private int polli;//出
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了,不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了,不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        //i为当前的下标,返回下一个位置
        public int nextIndex(int i) {
            return i < limit -1 ? i + 1 : 0;
        }
    }

}
