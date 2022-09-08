package com.example.suanfa.levelone.class10;

/**
 *
 * @author: Elliot Ji
 * @createDate: 2022-08-29
 **/
public class GraphGenerator {

    //根据入参不同,写这个构建一张图的方法
    //N * 3的矩阵
    //[weight,from节点上面的值,to上面的值]
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from,new Node(from));
            }
            if (graph.nodes.containsKey(to)) {
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

}
