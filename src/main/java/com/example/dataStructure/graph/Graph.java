package com.example.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图
 */
public class Graph {

    private List<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//表示边的数目

    public static void main(String[] args) {

    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
    }


}
