package com.example.collections.linkedList;

/**
 * Created by Elliot Ji on 2019/3/28.
 */
public class Node {

    Node previous;
    Node next;
    Object object;

    public Node(Node previous, Node next, Object object) {
        this.previous = previous;
        this.next = next;
        this.object = object;
    }

    public Node(Object object) {
        this.object = object;
    }
}
