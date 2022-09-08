package com.example.suanfa.levelone.class10;

import java.util.*;

/**
 * 拓扑排序
 * @author: Elliot Ji
 * @createDate: 2022-09-05
 **/
public class Code03_TopologySort {

    //拓扑排序
    public static List<Node> sortedTopology(Graph graph) {
        Map<Node,Integer> inMap = new HashMap<>();//key: 某一个node, value: 剩余的入度

        Queue<Node> zeroInQueue = new LinkedList<>();//入度为0的点,才能进这个队列

        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next,inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }


}
