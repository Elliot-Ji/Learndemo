package com.example.suanfa.levelone.class10;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 * @author: Elliot Ji
 * @createDate: 2022-08-29
 **/
public class Graph {
    public HashMap<Integer,Node> nodes;//点的集合
    public HashSet<Edge> edges;//边的集合

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
