/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.listnode;

import com.lyw.leetCode.model.ListNode;

import java.util.Stack;

/**
 * @author pangu
 * @version : IsPalindrome.java, v 0.1 2022年04月21日 上午10:12 pangu Exp $
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        //System.out.println(isPalindromeWithStack(node));
        System.out.println(isPalindrome(node));
    }

    private static boolean isPalindromeWithStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = node;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;

        }

        while (!stack.isEmpty()) {
            if (node.val != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    /**
     * 1. 找中点
     * 2. 拆成两部分
     * 3. 判断回文
     * 4. 恢复node
     * @param node
     * @return
     */
    private static boolean isPalindrome(ListNode node) {
        if (node == null || node.next == null) {
            return true;
        }
        ListNode n1 = node;
        ListNode n2 = node;

        //find mid node
        while (n2.next != null && n2.next.next != null) {
            //n1->mid
            n1 = n1.next;
            //n2->end
            n2 = n2.next.next;
        }
        //n2 -> right part first node
        n2 = n1.next;
        //mid .next -> null
        n1.next = null;
        ListNode n3 = null;
        //right part convert
        while (n2 != null) {
            //n3 -> save next node
            n3 = n2.next;
            //next of right node convert
            n2.next = n1;
            //n1 move
            n1 = n2;
            //n2 move
            n2 = n3;
        }
        //n3 -> save last node
        n3 = n1;
        //n2 -> left first node
        n2 = node;
        //check palindrome
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            //left ->mid
            n1 = n1.next;
            //right -> mid
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        //recover list
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return true;
    }

}