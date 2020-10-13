package com.example.dataStructure.binarysorttree;

/**
 * 二叉排序树的创建,中序遍历,删除
 * 删除结点:
 * 情况一: 删除的是叶子结点
 * 情况二: 删除只有一颗子树的结点
 * 情况三: 删除有两颗子树的结点
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i = 0; i<arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree{
    private Node root;

    //添加结点
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }else{
            System.out.println("空树,无法遍历!");
        }
    }
}

//创建结点
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点
    public void add(Node node){
        if(node == null){
            return;
        }
        if(node.value < this.value){//于子树的根节点的值比较,小于则想左子树添加
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{//大于等于则向右子树添加
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

}
