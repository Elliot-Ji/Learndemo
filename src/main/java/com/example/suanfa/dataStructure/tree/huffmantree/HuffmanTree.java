package com.example.suanfa.dataStructure.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树的构建
 * Date:2020/9/11
 */
public class HuffmanTree {
    public static void main(String[] args) {
         int[] arr = {13,7,8,3,29,6,1};
        Node root = creatHuffmanTree(arr);
        preOrder(root);

    }

    //创建Huffman树
    public static Node  creatHuffmanTree(int[] arr){
        //1.将数组放进集合中
        List<Node> nodes = new ArrayList<Node>();
        for(int value : arr){
            nodes.add(new Node(value));
        }

        while(nodes.size() > 1){
            //排序,从小到大
            Collections.sort(nodes);

            //2.取出根结点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //3.构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //4.从集合中移除已经处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5.将parent放入集合中
            nodes.add(parent);
        }
       //最后返回赫夫曼树的root结点
        return nodes.get(0);

    }

    //前序遍历二叉树
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("空树!");
        }
    }
}

//创建结点类
class Node implements Comparable<Node>{
    int value;//结点的权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //实现从小到大排序
        return this.value-o.value;
    }
}
