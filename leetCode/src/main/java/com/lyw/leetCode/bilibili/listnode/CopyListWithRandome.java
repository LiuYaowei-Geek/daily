package com.lyw.leetCode.bilibili.listnode;

import com.lyw.leetCode.model.RandomNode;

import java.util.HashMap;

public class CopyListWithRandome {

    public static void main(String[] args) {

    }

    private static RandomNode copyListWithRandomeUseHash(RandomNode head) {
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode cur = head;

        while (cur != null) {
            map.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    private static RandomNode copyListWithRandome(RandomNode head) {
        if (head == null) {
            return null;
        }

        RandomNode cur = head;
        RandomNode next = null;

        //克隆当前节点到当前节点的Next位置
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomNode(cur.val);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        RandomNode curCopy = null;

        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        RandomNode res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
