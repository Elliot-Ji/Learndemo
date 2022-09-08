package com.example.suanfa.levelone.class10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-29
 **/
public class Code02_BFS {
    //从node出发,进行宽度优先遍历,即离我最近的点都优先遍历出来
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }

    }
}
