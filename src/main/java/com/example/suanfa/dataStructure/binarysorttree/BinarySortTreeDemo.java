package com.example.suanfa.dataStructure.binarysorttree;

/**
 * 二叉排序树的创建,中序遍历,删除
 * 删除结点:
 * 情况一: 删除的是叶子结点
 * 情况二: 删除只有一颗子树的结点
 * 情况三: 删除有两颗子树的结点
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i = 0; i<arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
        System.out.println("删除叶子节点");
        binarySortTree.delNode(2);
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回以node为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        while(target.left != null){//循环查找以target为根结点的左子结点的最小值
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value){
        if(root == null){
            return;
        }else{
            //1.找到要删除的结点
            Node targetNode = search(value);
            if(targetNode == null){
                return;
            }
            //当前的二叉排序树只有一个结点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            //2.找到删除结点的父节点
            Node parent = searchParent(value);
            if(targetNode.left == null && targetNode.right == null){//删除的是叶子节点
                //判断要删除的结点是父节点的左子节点还是右子节点
                if(parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if(parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if(targetNode.left != null && targetNode.right != null){//删除有两颗子树的结点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else{//删除只有一颗子树的结点
                if(targetNode.left != null){//如果要删除的结点的有左子结点
                    if(parent != null){
                        if(parent.left.value == value){//targetNode 是parent结点的左子结点
                            parent.left = targetNode.left;
                        }else{//targetNode 是parent结点的右子结点
                            parent.right = targetNode.left;
                        }
                    }else{//此时就剩一个根结点和和一个他的左子结点
                        root = targetNode.left;
                    }

                }else{//要删除的结点的有右子结点
                    if(parent != null){
                        if(parent.left.value == value){//targetNode 是parent结点的左子结点
                            parent.left = targetNode.right;
                        }else{//targetNode 是parent结点的右子结点
                            parent.right = targetNode.right;
                        }
                    }else{//此时就剩一个根结点和和一个他的左子结点
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    //查找要删除的结点
    public Node search(int value){
       if(root == null){
           return null;
       }else{
           return root.search(value);
       }
    }

    //查找要删除结点的父节点
    public Node searchParent(int value){
        if(root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

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

    //查找要删除的结点
    public Node search(int value){
        if(value == this.value){
            return this;
        }else if(value < this.value){//查找的值小于当前结点,向左子树递归查找
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{//查找的值不小于当前结点,向右子树递归查找
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除结点的父节点
    public Node searchParent(int value){
        if((this.left !=null && this.left.value == value)
                || (this.right != null && this.right.value == value)){
            return this;
        }else{
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
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
