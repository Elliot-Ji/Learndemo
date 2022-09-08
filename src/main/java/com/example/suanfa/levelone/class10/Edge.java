package com.example.suanfa.levelone.class10;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-29
 **/
public class Edge {
    public int weight;//权重
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
