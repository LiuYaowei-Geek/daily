package com.lyw.algorithms;


import com.lyw.algorithms.model.Node;

/**
 * @author liuyaowei488
 * @date created in 2020-4-17 10:48
 */
public class ReverseLinkList {

    //递归
    private static Node reverse1(Node node) {
        if (null == node || null == node.getNext()) {
            return node;
        }
        Node newNode = reverse1(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return newNode;
    }

    //遍历
    private static Node reverse2(Node node) {

        Node pre = null;
        Node next = null;

        while (node != null) {
            next = node.getNext();
            node.setNext(pre);
            pre = node;
            node = next;
        }
        return pre;

//        Node pre = null;
//        Node next = null;
//        while (node != null) {
//            next = node.getNext();
//            node.setNext(pre);
//            pre = node;
//            node = next;
//        }
//        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.setNext(new Node(2));
        node.getNext().setNext(new Node(3));

//        Node node1 =  reverse1(node);
//        while (node1 != null) {
//            System.out.println(node1.getValue());
//            node1 = node1.getNext();
//        }
        System.out.println("=================");
        Node node2 = reverse2(node);
        while (node2 != null) {
            System.out.println(node2.getValue());
            node2 = node2.getNext();
        }
    }
}
