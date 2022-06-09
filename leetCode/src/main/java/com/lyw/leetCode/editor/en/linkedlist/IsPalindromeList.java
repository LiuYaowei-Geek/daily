package com.lyw.leetCode.editor.en.linkedlist;

import com.lyw.leetCode.model.ListNode;

import java.util.Stack;

public class IsPalindromeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(2,
                        new ListNode(1)))));
        System.out.println(isPalindromeListWithStack(head));
        System.out.println(isPalindromeList(head));
    }

    private static boolean isPalindromeListWithStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (!stack.empty()) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //1 2 3 2 1
    private static boolean isPalindromeList(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //找mid
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表拆分两半
        //fast是右半部分第一个值
        fast = slow.next;
        //原始链表head截取前半部分，mid.next->null
        slow.next = null;
        ListNode node = null;
        while (fast != null) {
            //node保存右半部分的下一个节点
            node = fast.next;
            //还原右半部分节点
            fast.next = slow;
            //slow保存已经还原的右半部分节点
            slow = fast;
            //fast位置移动到下一个位置，开始继续还原右半部分(23到123，一直还原到最后一个节点)
            fast = node;
        }
        //slow保存右半部分·
        node = slow;
        //fast保存左半部分，slow保存右半部分
        //1->2->3<-2<-1
        //fast=1->2->3
        //slow=3<-2<-1
        fast = head;
        //判断是否回文
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        //还原原链表
        slow = node.next;
        node.next = null;
        while (slow != null) {
            fast = slow.next;
            //拼接node节点数据，还原原链表head
            slow.next = node;
            node = slow;
            slow = fast;
        }
        //head=1 2 3 2 1
        //node=3 2 1
        //slow=3 2 1
        //fast=null
        return res;
    }
}
