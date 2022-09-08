package com.example.suanfa.levelone.class10;

import java.util.ArrayList;

/**
 * 点
 * @author: Elliot Ji
 * @createDate: 2022-08-29
 **/
public class Node {
    public int value;
    public int in;//直接入点数量
    public int out;//直接出点数量
    public ArrayList<Node> nexts;//直接出点的点
    public ArrayList<Edge> edges;//直接出入点的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
