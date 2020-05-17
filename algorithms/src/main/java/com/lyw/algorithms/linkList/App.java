package com.lyw.algorithms.linkList;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Node node = createNodeList("1,2,3,4,5");
        int n = 2;
        node = solution(node, n);
        //不能打印循环链表的toString()，会栈溢出
        printNodeList(node);
    }

    static Node createNodeList(String str) {
        Node head = new Node();
        Node res = head;
        String[] array = str.split(",");
        for (String s : Arrays.asList(array)) {
            head.setValue(s);
            if (s.equals(array[array.length - 1])) {
                head.setNext(null);
                break;
            }
            head.setNext(new Node());
            head = head.getNext();
        }
        return res;
    }

    static String printNodeList(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.getValue()).append(",");
            node = node.getNext();
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
        return stringBuilder.toString();
    }

    /**
     * 1、计算出链表的长度
     * 2、定义一个节点p指向链表尾部
     * 3、p的下一个节点指向原链表头，形成循环链表
     * 4、将原链表头指向右移后的位置，还是循环链表
     * 5、破坏循环
     *
     * @param node
     * @param n
     * @return
     */
    static Node solution(Node node, int n) {
        if (null == node || 0 == n) {
            return node;
        }
        Node p = node;
        int len = 1;
        while (null != p.getNext()) {
            p = p.getNext();
            len++;
        }
        //构成循环链表
        p.setNext(node);
        //找出右移后的位子
        n %= len;
        //将循环链表右转n个位子
        for (int i = 0; i < len - n; i++) {
            p = p.getNext();
        }
        //node为右移后的循环链表，头节点已经变了
        node = p.getNext();
        //断开循环链表
        p.setNext(null);
        return node;
    }
}
