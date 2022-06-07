package com.lyw.algorithms.linkList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private String value;
    private Node next;

    public Node(String value) {
        this.value = value;
    }
    Node(){}
}
