package com.example.testdemo;

import cn.hutool.core.collection.CollUtil;
import lombok.Data;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Elliot Ji
 * @date 2023/7/5
 */
public class Test6 {

    public static void main(String[] args) {
        Node first = new Node(1, 0, "first");
        Node second = new Node(2, 1, "second");
        Node third = new Node(3, 2, "third");
        Node second001 = new Node(4, 1, "second001");
        Node third001 = new Node(5, 4, "third001");
        // 组装树状数据
        List<Node> nodes = Arrays.asList(first, second, third, second001, third001);
        //List<Node> nodes1 = buildTree(nodes);
        List<Node> nodes1 = listToTree(nodes, Node::getId, Node::getPid, Node::setTreeNode, (l) -> l.getPid() == 0);
        System.out.println(nodes1);
        List<Node> nodes2 = treeToList(nodes1, Node::getTreeNode, Node::setTreeNode, (l) -> l.getPid() == 0);
        System.out.println(nodes2);
    }

    /**
     * 方法一：获取树形结构数据
     * @param nodes：所有节点数据
     * @return 返回树形结构
     */
    public static List<Node> buildTree(List<Node> nodes) {
        Map<Integer, List<Node>> nodeMap = nodes.stream().filter(node -> node.getPid() != 0).
                collect(Collectors.groupingBy(Node::getPid));
        nodes.forEach(node -> node.setTreeNode(nodeMap.get(node.getId())));
        return nodes.stream().filter(node -> node.getPid() == 0).collect(Collectors.toList());
    }

    /**
     * 方法二：思路与方法一是一样的，写法不一样而已
     * @param list 树形原数据
     * @param idFn 获取id的方法
     * @param pidFn 获取pid的方法
     * @param setChildListFn 设置递归
     * @param getRootCondition 获取根节点
     * @return 将List转 tree
     * @param <M>
     * @param <T>
     */
    public static <M,T> List<M> listToTree(List<M> list,
                                          Function<M,T>idFn,
                                          Function<M,T> pidFn,
                                          BiConsumer<M,List<M>> setChildListFn,
                                          Predicate<M> getRootCondition) {
        if (CollUtil.isEmpty(list)) return null;
        Map<T, List<M>> listMap = list.stream().collect(Collectors.groupingBy(pidFn));//根据pid分组
        list.forEach(model ->setChildListFn.accept(model,listMap.get(idFn.apply(model))));//给每个节点加上子节点
        return list.stream().filter(getRootCondition).collect(Collectors.toList());//获取根节点数据
    }

    //从前端、微服务或者第三方接口获取树形结构的数据，转成List
    public static <M> List<M> treeToList(List<M> source,Function<M,List<M>> getChildFn,
                                         BiConsumer<M,List<M>> setChildFn,Predicate<M> getRootCondition) {
        List<M> target = new ArrayList<>();
        if (CollUtil.isNotEmpty(source)) {
            treeToList(source,target,getChildFn);
            target.forEach(model -> setChildFn.accept(model,null));
            target.addAll(target.stream().filter(getRootCondition).collect(Collectors.toList()));
        }
        return target;
    }

    private static <F> void treeToList(List<F> source,List<F> target,Function<F,List<F>> getChildFn) {
        if (CollUtil.isNotEmpty(source)) {
            target.addAll(source);
            source.forEach(model -> {
                List<F> childList = getChildFn.apply(model);
                if (CollUtil.isNotEmpty(childList)) {
                    treeToList(childList,target,getChildFn);
                }

            });
        }

    }

}

@Data
class Node {
    private Integer id;
    private String name;
    private Integer pid;
    private List<Node> treeNode = new ArrayList<>();

    public Node(Integer id, Integer pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public Node(Integer id, Integer pid) {
        this.id = id;
        this.pid = pid;
    }
}