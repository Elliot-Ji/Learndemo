package com.example.suanfa.levelone.class10;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-29
 **/
public class Code02_DFS {
    //深度优先遍历,一个点往下走,走完所有的路,换下一个点继续
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack =  new Stack<>();
        HashSet<Node> set =  new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
