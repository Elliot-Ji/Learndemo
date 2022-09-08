package com.example.suanfa.levelone.class10;

import java.util.*;

/**
 * @author: Elliot Ji
 * @createDate: 2022-09-05
 **/
public class Code04_Kruskal {

    //并查集算法
    public static class UnionFind {
        private final HashMap<Node,Node> fatherMap; //key 某一个节点,value : key节点往上的节点

        private final HashMap<Node,Integer> sizeMap; //key: 某一个集合的代表节点,value: key所在集合的节点个数

        public UnionFind () {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        private Node findFather(Node n) {
            Stack<Node> path =  new Stack<>();
            while (n != fatherMap.get(n)) {
                path.add(n);
                n = fatherMap.get(n);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(),n);
            }
            return n;
        }

        public boolean isSameSet(Node a,Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a,Node b) {
            if (a == null || b == null ) {
                return;
            }
            Node aDai = findFather(a);
            Node bDai = findFather(b);
            if (aDai != bDai) {
                int aSetSize = sizeMap.get(aDai);
                int bSetSize = sizeMap.get(bDai);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aDai,bDai);
                    sizeMap.put(bDai,aSetSize + bSetSize);
                    sizeMap.remove(aDai);
                } else {
                    fatherMap.put(bDai,aDai);
                    sizeMap.put(aDai,aSetSize + bSetSize);
                    sizeMap.remove(bDai);
                }
            }
        }

    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1,Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    //K算法
    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }

        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from,edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }

}
