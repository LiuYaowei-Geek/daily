package com.lyw.algorithms.model;

/**
 * @author liuyaowei488
 * @date created in 2020-4-17 10:48
 */
public class Node {
    private int value;
    private Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
    }
}
